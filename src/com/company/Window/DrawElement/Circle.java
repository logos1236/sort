package com.company.Window.DrawElement;

import java.awt.*;

public class Circle extends DrawElement {
    private String text;

    public Circle(int x, int y, int radius, Color color, String text) {
        super(x, y, radius, color);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static void drawCenteredString(Graphics g, String text, int rect_x, int rect_y, int rect_radius) {
        g.setColor(Color.WHITE);

        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics();
        // Determine the X coordinate for the text
        int x = rect_x + (rect_radius - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect_y + ((rect_radius - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        // Draw the String
        g.drawString(text, x, y);
    }

    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(this.getColor());
        g.fillOval(this.getX(), this.getY(), this.getRadius(), this.getRadius());

        drawCenteredString(g, this.getText(), this.getX(), this.getY(), this.getRadius());
    }
}
