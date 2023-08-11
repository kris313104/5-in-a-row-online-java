package com.bpkb.fiveinrow.client.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiveInRow implements ActionListener {

    private JFrame mainFrame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textfield1 = new JLabel("Five in a Row", SwingConstants.LEFT); // Added text and alignment
    private JLabel textfield2 = new JLabel();
    private JButton[] buttons = new JButton[15 * 15];

    public FiveInRow() {
        initializeUI();
        initializeButtons();
    }

    private void initializeUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 950); // Increased height for text fields
        mainFrame.setResizable(false);
        mainFrame.getContentPane().setBackground(new Color(50, 50, 50));
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);

        titlePanel.setLayout(new GridLayout(1, 2));

        textfield1.setHorizontalAlignment(JLabel.LEFT); // Align to the left
        textfield1.setVerticalAlignment(JLabel.TOP); // Align to the top
        textfield1.setFont(new Font("Ink Free", Font.BOLD, 70));
        textfield1.setForeground(new Color(125, 155, 150));
        textfield1.setOpaque(true);

        textfield2.setHorizontalAlignment(JLabel.CENTER);
        textfield2.setVerticalAlignment(JLabel.CENTER);
        textfield2.setFont(new Font("Ink Free", Font.BOLD, 70));
        textfield2.setForeground(new Color(125, 155, 150));
        textfield2.setOpaque(true);

        titlePanel.add(textfield1);
        titlePanel.add(textfield2);

        mainFrame.add(titlePanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel);

        mainFrame.setVisible(true);
    }

    private void initializeButtons() {
        buttonPanel.setLayout(new GridLayout(15, 15));
        buttonPanel.setBackground(new Color(15, 55, 50));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Quicksand Thin", Font.PLAIN, 25));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);

            buttonPanel.add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FiveInRow::new);
    }
}
