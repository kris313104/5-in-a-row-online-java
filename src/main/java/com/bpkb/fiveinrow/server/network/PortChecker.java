package com.bpkb.fiveinrow.server.network;

import java.net.ServerSocket;

public class PortChecker {
    public static boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // If the socket can be created, the port is available
            return true;
        } catch (Exception e) {
            // If an exception occurs, the port is already in use
            return false;
        }
    }
}
