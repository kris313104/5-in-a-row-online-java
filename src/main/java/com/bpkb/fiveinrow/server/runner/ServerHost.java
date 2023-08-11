package com.bpkb.fiveinrow.server.runner;

import java.util.Random;

//@SpringBootApplication
public class ServerHost {
    private ServerThread serverThread;
    //    public static void main(String[] args) {
//        SpringApplication.run(ServerApp.class, args);
//    }
    public static String[] args;


    public ServerHost(String[] args) {
        ServerHost.args = args;
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

    public String generateRoomCode(int codeLength) {
        StringBuilder returnCodeBuilder = new StringBuilder();

        while (returnCodeBuilder.length() <= codeLength) {
            System.out.println((int)(Math.random() * 25 + 65));
            returnCodeBuilder.append((char) (int)(Math.random() * 25 + 65));
        }

        return returnCodeBuilder.toString();
    }


}
