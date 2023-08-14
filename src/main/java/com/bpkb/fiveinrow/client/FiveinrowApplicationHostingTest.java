package com.bpkb.fiveinrow.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class FiveinrowApplicationHostingTest {

	public static void main(String... aArgs){

		FiveinrowApplicationHostingTest app = new FiveinrowApplicationHostingTest();
		app.buildAndDisplayGui();

//		System.out.println(host.generateRoomCode(6));

	}

	// PRIVATE

	private void buildAndDisplayGui(){
		JFrame frame = new JFrame("Test Frame");
		buildContent(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	private void buildContent(JFrame aFrame){
		JPanel panel = new JPanel();
		panel.add(new JLabel("Hello"));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ShowDialog(aFrame));
		panel.add(ok);

		JButton closeButton = new JButton("Stop server");
		closeButton.addActionListener(e -> {

		});
		panel.add(closeButton);


		aFrame.getContentPane().add(panel);
	}

	private static final class ShowDialog implements ActionListener {
		/**
		 * Defining the dialog's owner JFrame is highly recommended.
		 */
		ShowDialog(JFrame aFrame) {
			fFrame = aFrame;
		}

		@Override
		public void actionPerformed(ActionEvent aEvent) {

			JOptionPane.showMessageDialog(fFrame, "running spring app");
		}

		private JFrame fFrame;
	}
}
