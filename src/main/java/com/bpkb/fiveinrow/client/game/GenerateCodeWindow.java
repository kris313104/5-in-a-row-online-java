package com.bpkb.fiveinrow.client.game;

import com.bpkb.fiveinrow.server.runner.ServerHost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GenerateCodeWindow extends JFrame {
    private JTextField codeTextField;

    private static ServerHost host;


    public GenerateCodeWindow() {
        setTitle("Generate Code");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel codeLabel = new JLabel("Enter code: ");
        codeTextField = new JTextField(15);
        JButton generateHost = new JButton("Host game");
        JButton connectButton = new JButton("Connect and play");

        host = new ServerHost(ServerHost.args);
        generateHost.addActionListener(e -> {
            //code generation logic here
                host.runHostingServer();
                codeTextField.setText(ServerHost.getRoomCode());
                codeTextField.setEnabled(false);
                generateHost.setEnabled(false);
                connectButton.setEnabled(false);


        });

        connectButton.addActionListener(e -> {
            // tu do connect and play
            HttpURLConnection connection;
            try {
                String joinURLString = new StringBuilder("http://localhost:2137/").append(codeTextField.getText()).append("/join").toString();
                URL joinURL = new URL(joinURLString);

                URLConnection yc = joinURL.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

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

