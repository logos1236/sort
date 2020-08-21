package com.company.Window.DrawElement;

import java.awt.*;

public class Line extends DrawElement {
    private LineType type;
    private static int y_offset = 50;

    public static int getYoffset() {
        return y_offset;
    }

    public Line(int x, int y, int radius, Color color, LineType type) {
        super(x, y, radius, color);
        this.type = type;
    }

    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(this.getColor());

        int end_x = this.getX()+this.getRadius()/2;
        if (type.equals(LineType.RIGHT_CHILD)) {
            end_x = this.getX() + this.getRadius()*2;
        }

        g.drawLine(this.getX()+this.getRadius()/2, this.getY()+this.getRadius()/2, end_x, this.getY()+this.getRadius()+y_offset);
    }
}
