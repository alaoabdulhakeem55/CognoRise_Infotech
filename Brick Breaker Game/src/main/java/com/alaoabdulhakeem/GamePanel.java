package com.alaoabdulhakeem;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Paddle paddle;
    private Ball ball;
    private Brick[][] bricks;
    private boolean gameOver;
    private boolean gameWon;
    private int score;

    public GamePanel() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);

        initGame();

        Timer timer = new Timer(10, this);
        timer.start();
    }

    private void initGame() {
        paddle = new Paddle(350, 550, 100, 20, Color.BLUE);
        ball = new Ball(400, 300, 10, Color.RED, 2, -2);
        bricks = new Brick[5][10];

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j] = new Brick(j * 70 + 50, i * 30 + 50, 60, 20, Color.GREEN);
            }
        }

        gameOver = false;
        gameWon = false;
        score = 0;

        System.out.println("Game initialized. Ball position: (" + ball.getX() + ", " + ball.getY() + ")");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over", 350, 300);
        } else if (gameWon) {
            g.setColor(Color.GREEN);
            g.drawString("You Win!", 350, 300);
        } else {
            paddle.draw(g);
            ball.draw(g);

            for (Brick[] brick : bricks) {
                for (Brick value : brick) {
                    if (value.isVisible()) {
                        value.draw(g);
                    }
                }
            }

            g.setColor(Color.BLACK);
            g.drawString("Score: " + score, 700, 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !gameWon) {
            ball.move();
            ball.checkCollision(paddle, bricks);
            checkGameOver();
            checkWin();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    private void checkGameOver() {
        if (ball.getY() > getHeight()) {
            gameOver = true;
        }
    }

    private void checkWin() {
        for (Brick[] brick : bricks) {
            for (Brick value : brick) {
                if (value.isVisible()) {
                    return;
                }
            }
        }
        gameWon = true;
    }
}
