package com.bpkb.fiveinrow.client.game;


import com.bpkb.fiveinrow.client.FiveinrowApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Five in a Row Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FiveinrowApplication.openWindows.add(this);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JButton singlePC = createStyledButton("Single PC game");
        JButton multiPlayerButton = createStyledButton("Multiplayer");
        JButton botButton = createStyledButton("VS Computer");

        addHoverEffect(singlePC);
        addHoverEffect(botButton);
        addHoverEffect(multiPlayerButton);

        singlePC.addActionListener(e -> {
            SwingUtilities.invokeLater(FiveInRow::new);
            dispose();
        });

        multiPlayerButton.addActionListener(e -> {
            GenerateCodeWindow generateCodeWindow = new GenerateCodeWindow();
        });



        buttonPanel.add(singlePC);
        buttonPanel.add(multiPlayerButton);
        buttonPanel.add(botButton);


        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(95, 158, 160));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(200, 60));
        return button;
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(135, 188, 190));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(95, 158, 160));
            }
        });
    }
}



