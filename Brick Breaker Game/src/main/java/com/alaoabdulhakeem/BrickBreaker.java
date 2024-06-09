package com.alaoabdulhakeem;

import javax.swing.JFrame;

public class BrickBreaker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
