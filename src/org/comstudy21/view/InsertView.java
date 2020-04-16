package org.comstudy21.view;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertView extends View {

	JPanel panelForName = new JPanel();
	JPanel panelForPhone = new JPanel();
	JPanel panelForEmail = new JPanel();
	JTextField nameField = new JTextField(15);
	JTextField phoneField = new JTextField(15);
	JTextField emailField = new JTextField(15);

	public InsertView() {

		
		init();
	}
	
	public Vector<String>getTextField() {
		Vector<String>TextFieldInput = new Vector<String>();
		
//		TextFieldInput.add(nameField.getText());
//		TextFieldInput.add(phoneField.getText());
//		TextFieldInput.add(emailField.getText());
	
		return TextFieldInput;
	}
	
	

	@Override
	public void init() {

		add(panelForName);
		add(panelForPhone);
		add(panelForEmail);

		panelForName.add(new JLabel("Name"));
		panelForName.add(nameField);
		
		panelForPhone.add(new JLabel("Phone"));
		panelForPhone.add(phoneField);
		
		panelForEmail.add(new JLabel("Email"));
		panelForEmail.add(emailField);
	}

	@Override
	public void start() {
			
	}

}
