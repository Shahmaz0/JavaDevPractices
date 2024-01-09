//Selecting java class using Java app from DB JDBC
package com.shahma.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectJDBC {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple GUI");
        JPanel panel = new JPanel();

        JTextField textField = new JTextField(20); // 20 columns width for the text field
        JButton button = new JButton("Click me");

        // Adding components to the panel
        panel.add(textField);
        panel.add(button);

        // Adding panel to the frame
        frame.add(panel);

        // Handling button click event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                JOptionPane.showMessageDialog(frame, "Text entered: " + text);
            }
        });

        // Setting frame properties
        frame.setSize(300, 150); // Width x Height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
