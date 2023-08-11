package com.bpkb.fiveinrow.server.network;

import java.net.ServerSocket;

public class PortChecker {
    public static boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return true;

        } catch (Exception e) {
            return false;

        }
    }
}
