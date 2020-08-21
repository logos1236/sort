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
        Graphics2D g2 = (Graphics2D) g;
        for (DrawElement draw_element:draw_element_list) {
            draw_element.paintComponent(g2);
        }
    }
}
