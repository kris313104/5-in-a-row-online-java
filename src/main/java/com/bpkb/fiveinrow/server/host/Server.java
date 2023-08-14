package com.bpkb.fiveinrow.server.host;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Port number

            System.out.println("Server waiting for connections...");
            Socket socket = serverSocket.accept(); // Wait for a client to connect

            System.out.println("Client connected!");

            // Create a thread for receiving messages from the client asynchronously
            Thread receiveThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Client: " + message);
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
}
