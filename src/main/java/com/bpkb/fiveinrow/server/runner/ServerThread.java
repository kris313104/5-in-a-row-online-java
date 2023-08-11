package com.bpkb.fiveinrow.server.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
class ServerThread extends Thread {
    private String[] args;
    private ConfigurableApplicationContext context;

    public ServerThread(String[] args){
        this.args = args;
    }
    public void run() {
        super.run();
        context = SpringApplication.run(ServerThread.class, args);
    }

    @Override
    public void interrupt() {
        context.close();
        super.interrupt();
    }
}
