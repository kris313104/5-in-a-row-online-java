package com.bpkb.fiveinrow.client;

import com.bpkb.fiveinrow.client.game.FiveInRow;
import com.bpkb.fiveinrow.client.game.Menu;
import com.bpkb.fiveinrow.server.runner.ServerHost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

//@SpringBootApplication
public class FiveinrowApplication {

	public static void main(String[] args) {
		ServerHost.args = args;
		SwingUtilities.invokeLater(Menu::new);
	}

}
