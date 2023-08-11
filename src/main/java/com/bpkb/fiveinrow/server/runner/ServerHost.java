package com.bpkb.fiveinrow.server.runner;

//@SpringBootApplication
public class ServerHost {
    ServerThread serverThread;
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

}
