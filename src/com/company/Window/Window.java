package com.company.Window;

import com.company.Window.DrawElement.Circle;
import com.company.Window.DrawElement.DrawElement;
import com.company.Window.DrawElement.Line;
import com.company.Window.DrawElement.LineType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    public Window() {
        initComponents();
    }

    private JFrame viewForm;

    private void initComponents() {
        JFrame.setDefaultLookAndFeelDecorated(false);
        viewForm = new JFrame("Калькулятор");
        viewForm.setSize(620, 620);
        viewForm.setLocationRelativeTo(null);
        viewForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Draw draw = new Draw();
        draw.addDrawElement(new Circle(100, 100, 50, Color.BLUE, "900"));
        draw.addDrawElement(new Line(100, 100, 50, Color.BLUE, LineType.LEFT_CHILD));
        draw.addDrawElement(new Line(100, 100, 50, Color.BLUE, LineType.RIGHT_CHILD));

        viewForm.add(draw);

        viewForm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
