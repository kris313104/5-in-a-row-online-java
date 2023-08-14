package com.bpkb.fiveinrow.client;

import com.bpkb.fiveinrow.client.game.FiveInRow;
import com.bpkb.fiveinrow.client.game.Menu;


import javax.swing.*;

//@SpringBootApplication
public class FiveinrowApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Menu::new);
	}

}
