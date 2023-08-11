package com.bpkb.fiveinrow.server.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
class ServerThread extends Thread {
    private final String[] args;
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
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        // Customize the port here
        return factory -> {
            factory.setPort(2137); // Change to your desired port
        };
    }
}
