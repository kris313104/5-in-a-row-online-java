package com.bpkb.fiveinrow.client;

import com.bpkb.fiveinrow.client.game.FiveInRow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

//@SpringBootApplication
public class FiveinrowApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(FiveInRow::new);
	}

}
