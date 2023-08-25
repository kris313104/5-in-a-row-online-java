package com.bpkb.fiveinrow.server.host;

import com.bpkb.fiveinrow.client.FiveinrowApplication;
import com.bpkb.fiveinrow.client.game.FiveInRow;
import com.bpkb.fiveinrow.client.game.GenerateCodeWindow;
import com.bpkb.fiveinrow.server.game.FiveInRowMultiplayer;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HostGame {
    private static Socket socket = null;



    public void initConnection(int port){

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server waiting for connections...");
            socket = serverSocket.accept(); // Wait for a client to connect

            System.out.println("Client connected!");

            // Create a thread for receiving messages from the client asynchronously
            Thread receiveThread = new Thread(() -> {
                try {
                    SwingUtilities.invokeLater(FiveInRowMultiplayer::new);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Client: " + message);
                        FiveInRowMultiplayer.setPlayer1_turn(true);
                        FiveInRowMultiplayer.updateBoardState(Integer.parseInt(message));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Read console input and send messages to the client
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String consoleInput;
            while ((consoleInput = consoleReader.readLine()) != null) {
                writer.println("Server: " + consoleInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Socket getSocket() {
        return socket;
    }
}
