package org.comstudy21.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JPanel contentJPanel = null;

	public MainFrame() {
		contentJPanel = (JPanel) getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Serin Company Customer Serive");

		add(BorderLayout.NORTH, new InsertView());
		add(BorderLayout.CENTER, new ListView());
		add(BorderLayout.SOUTH, new ButtonView());
		setSize(750, 550);
		setVisible(true);
	}
}
