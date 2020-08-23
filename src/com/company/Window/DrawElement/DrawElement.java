package com.company.Window.DrawElement;

import java.awt.*;

public abstract class DrawElement implements DrawElementInterface {
    private int x;
    private int y;
    private Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public DrawElement(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
