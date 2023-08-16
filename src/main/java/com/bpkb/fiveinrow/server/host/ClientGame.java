package com.bpkb.fiveinrow.server.host;

import com.bpkb.fiveinrow.client.FiveinrowApplication;
import com.bpkb.fiveinrow.client.game.FiveInRow;
import com.bpkb.fiveinrow.client.game.GenerateCodeWindow;
import com.bpkb.fiveinrow.server.game.FiveInRowMultiplayer;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientGame {
    private static Socket socket = null;
    public void initConnection(String host, int port){

        try {
            socket = new Socket(host, port);

            // Create a thread for receiving messages from the server asynchronously
            Thread receiveThread = new Thread(() -> {

                try {

                    SwingUtilities.invokeLater(FiveInRowMultiplayer::new);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                        FiveInRowMultiplayer.setPlayer1_turn(false);
                        FiveInRowMultiplayer.updateBoardState(Integer.parseInt(message));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Read console input and send messages to the server
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String consoleInput;
            while ((consoleInput = consoleReader.readLine()) != null) {
                writer.println("Client: " + consoleInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Socket getSocket() {
        return socket;
    }
}
