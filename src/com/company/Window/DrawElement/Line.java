package com.company.Window.DrawElement;

import java.awt.*;

public class Line extends DrawElement {
    private int end_x;
    private int end_y;

    public Line(int start_x, int start_y, Color color, int end_x, int end_y) {
        super(start_x, start_y, color);
        this.end_x = end_x;
        this.end_y = end_y;
    }

    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(this.getColor());

        //g.drawLine(this.getX()+this.getRadius()/2, this.getY()+this.getRadius()/2, end_x, this.getY()+this.getRadius()+y_offset);
        g.drawLine(this.getX(), this.getY(), end_x, end_y);
    }
}
