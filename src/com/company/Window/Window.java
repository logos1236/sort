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
    public Window(Draw draw) {
        JFrame viewForm;
        JFrame.setDefaultLookAndFeelDecorated(false);
        viewForm = new JFrame("Дерево");
        viewForm.setSize(620, 620);
        viewForm.setLocationRelativeTo(null);
        viewForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewForm.add(draw);

        viewForm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
