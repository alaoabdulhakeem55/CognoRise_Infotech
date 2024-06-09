package com.alaoabdulhakeem;

import lombok.*;

import java.awt.Color;
import java.awt.Graphics;

@Getter
@Setter
public class Brick {
    private int x, y, width, height;
    private Color color;
    private boolean visible;

    public Brick(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.visible = true;
    }

    public boolean isVisible() {
        return visible;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
}
