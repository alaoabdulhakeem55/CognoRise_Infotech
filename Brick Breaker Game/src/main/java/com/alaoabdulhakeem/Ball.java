package com.alaoabdulhakeem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.Color;
import java.awt.Graphics;

@AllArgsConstructor
@Getter
public class Ball {
    private int x, y, radius;
    private Color color;
    private int dx, dy;

    public void move() {
        x += dx;
        y += dy;

        if (x < 0 || x > 800 - radius) {
            dx = -dx;
        }

        if (y < 0) {
            dy = -dy;
        }


        System.out.println("Ball position: (" + x + ", " + y + ")");
    }

    public void checkCollision(Paddle paddle, Brick[][] bricks) {
        if (x + radius > paddle.getX() && x < paddle.getX() + paddle.getWidth() && y + radius > paddle.getY() && y < paddle.getY() + paddle.getHeight()) {
            dy = -dy;
            y = paddle.getY() - radius;
        }

        for (Brick[] value : bricks) {
            for (Brick brick : value) {
                if (brick.isVisible() && x + radius > brick.getX() && x < brick.getX() + brick.getWidth() && y + radius > brick.getY() && y < brick.getY() + brick.getHeight()) {
                    dy = -dy;
                    brick.setVisible(false);
                    System.out.println("Brick hit at position: (" + brick.getX() + ", " + brick.getY() + ")");
                    break;
                }
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}
