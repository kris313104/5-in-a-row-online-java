package com.bpkb.fiveinrow.client.game;

import com.bpkb.fiveinrow.client.FiveinrowApplication;
import com.bpkb.fiveinrow.server.host.ClientGame;
import com.bpkb.fiveinrow.server.host.HostGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerateCodeWindow extends JFrame {
    private JTextField ipTextField;
    private JTextField portTextField;
    private volatile JLabel infoLabel;

    public GenerateCodeWindow() {
        setTitle("Generate Code");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FiveinrowApplication.openWindows.add(this);

        JLabel ipLabel = new JLabel("Enter ip address: ");
        ipTextField = new JTextField(16);
        JLabel portLabel = new JLabel("Enter port");
        portTextField = new JTextField(6);
        infoLabel = new JLabel();
        JButton generateHost = new JButton("Host game");
        JButton connectButton = new JButton("Connect and play");


        generateHost.addActionListener(e -> {
            //code generation logic here



            try {
                int port = Integer.parseInt(portTextField.getText());

                Thread thread = new Thread(() -> {
                    HostGame hostGame = new HostGame();
                    hostGame.initConnection(port);
                    for (JFrame window : FiveinrowApplication.openWindows) {
                        window.dispose();
                    }
                });

                thread.start();

                generateHost.setEnabled(false);
                connectButton.setEnabled(false);
                infoLabel.setText("Hosting...");

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                infoLabel.setText("Invalid credentials");
            }


        });

        connectButton.addActionListener(e -> {
            // tu do connect and play
            try {
                String ip = ipTextField.getText();
                int port = Integer.parseInt(portTextField.getText());
                Thread thread = new Thread(() -> {
                    ClientGame clientGame = new ClientGame();
                    clientGame.initConnection(ip, port);

                });
//                for (JFrame window : FiveinrowApplication.openWindows) {
//                    window.dispose();
//                }

                thread.start();

//                this.dispose();
//                generateHost.setEnabled(false);
//                connectButton.setEnabled(false);

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                infoLabel.setText("Invalid port");
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(ipLabel);
        panel.add(ipTextField);
        panel.add(portLabel);
        panel.add(portTextField);

        panel.add(generateHost);
        panel.add(connectButton);
        panel.add(infoLabel);

        getContentPane().add(panel);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public String getCode() {
        return ipTextField.getText();
    }


}

