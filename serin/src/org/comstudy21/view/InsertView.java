package org.comstudy21.view;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.comstudy21.controller.InsertController;
import org.comstudy21.model.Customer;

public class InsertView extends View {


	public InsertView() {
		init();
	}
	

	@Override
	public void init() {
		add(new JLabel("Name"));
		add(nameField);
		
		add(new JLabel("Phone"));
		add(phoneField);
		
		add(new JLabel("Email"));
		add(emailField);
	}

	@Override
	public void start() {
			
	}

}
