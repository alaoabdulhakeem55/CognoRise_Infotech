package com.alaoabdulhakeem;

import lombok.Getter;

import java.awt.Color;
import java.awt.Graphics;

@Getter
public class Paddle {
    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;
    private final int SPEED = 15;

    public Paddle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void moveLeft() {
        x -= SPEED;
    }

    public void moveRight() {
        x += SPEED;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
