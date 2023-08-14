package com.bpkb.fiveinrow.server.host;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Server address and port

            // Create a thread for receiving messages from the server asynchronously
            Thread receiveThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
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
}
