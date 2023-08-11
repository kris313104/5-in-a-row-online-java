package com.bpkb.fiveinrow.client.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateCodeWindow extends JFrame {
    private JTextField codeTextField;

    public GenerateCodeWindow() {
        setTitle("Generate Code");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel codeLabel = new JLabel("Enter code: ");
        codeTextField = new JTextField(15);
        JButton generateHost = new JButton("Host game");
        JButton connectButton = new JButton("Connect and play");

        generateHost.addActionListener(e -> {
            //code generation logic here
//                String generatedCode = Integer.toString((int) (Math.random() * 10000));
//                codeTextField.setText(generatedCode);
        });

        connectButton.addActionListener(e -> {
            // tu do connect and play


        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(codeLabel);
        panel.add(codeTextField);
        panel.add(generateHost);
        panel.add(connectButton);

        getContentPane().add(panel);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public String getCode() {
        return codeTextField.getText();
    }
}

