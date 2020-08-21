package com.company.Window.DrawElement;

import java.awt.*;

public abstract class DrawElement implements DrawElementInterface {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public DrawElement(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
}
