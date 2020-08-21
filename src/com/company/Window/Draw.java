package com.company.Window;

import com.company.Window.DrawElement.Circle;
import com.company.Window.DrawElement.DrawElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JComponent {
    private ArrayList<DrawElement> draw_element_list = new ArrayList();

    public void addDrawElement(DrawElement draw_element) {
        draw_element_list.add(draw_element);
    }

    @Override
    protected void paintComponent(Graphics g) {
            /*super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.black);
            a = getWidth() / 2;
            b = getHeight() / 2;
            int m = Math.min(a, b);
            r = 4 * m / 5;
            int r2 = Math.abs(m - r) / 2;
            g2d.drawOval(a - r, b - r, 2 * r, 2 * r);
            g2d.setColor(Color.blue);
            for (int i = 0; i < n; i++) {
                double t = 2 * Math.PI * i / n;
                int x = (int) Math.round(a + r * Math.cos(t));
                int y = (int) Math.round(b + r * Math.sin(t));
                g2d.fillOval(x - r2, y - r2, 2 * r2, 2 * r2);
            }*/
        Graphics2D g2 = (Graphics2D) g;
        for (DrawElement draw_element:draw_element_list) {
            draw_element.paintComponent(g2);
        }
    }
}
