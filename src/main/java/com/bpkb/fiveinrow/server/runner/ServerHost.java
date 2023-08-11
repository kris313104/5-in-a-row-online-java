package com.bpkb.fiveinrow.server.runner;

import java.util.Random;

//@SpringBootApplication
public class ServerHost {
    private static final int ROOM_CODE_LENGTH = 6;
    private ServerThread serverThread;
    private static String roomCode;
    public static String[] args;


    public ServerHost(String[] args) {
        ServerHost.args = args;
        roomCode = generateRoomCode(ROOM_CODE_LENGTH);
    }

    public void runHostingServer() {
        serverThread = new ServerThread(args);
        serverThread.start();
    }

    public void stopHostingServer() {
        System.out.println("Stopping server");
        serverThread.interrupt();
        System.out.println("Server stopped");
    }

    public static String getRoomCode() {
        return roomCode;
    }

    private static String generateRoomCode(int codeLength) {
        StringBuilder returnCodeBuilder = new StringBuilder();

        while (returnCodeBuilder.length() <= codeLength) {
//            System.out.println((int)(Math.random() * 25 + 65));
            returnCodeBuilder.append((char) (int)(Math.random() * 25 + 65));
        }
        System.out.println(returnCodeBuilder.toString());
        return returnCodeBuilder.toString();
    }


}
