package org.comstudy21.controller;

import javax.swing.JTextField;

import org.comstudy21.model.Customer;
import org.comstudy21.view.InsertView;

public class InsertController implements Controller  {
	
	public InsertView insertView=new InsertView();
	
	public InsertController() {
	}

	@Override
	public void service() {
		String name = nameField.getText();
		String phone = phoneField.getText();
		String email = emailField.getText();
		Customer customer = new Customer(0, name, phone, email);
		dao.insert(customer);
	}
}
