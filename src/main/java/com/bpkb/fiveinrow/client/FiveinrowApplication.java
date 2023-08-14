package com.bpkb.fiveinrow.client;

import com.bpkb.fiveinrow.client.game.FiveInRow;
import com.bpkb.fiveinrow.client.game.Menu;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class FiveinrowApplication {
	public static volatile List<JFrame> openWindows = new ArrayList<>();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Menu::new);
	}

}
