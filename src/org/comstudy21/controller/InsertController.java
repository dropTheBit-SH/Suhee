package org.comstudy21.controller;

import java.util.Vector;

import org.comstudy21.model.Customer;

public class InsertController implements Controller {

	public InsertController() {
	}

	@Override
	public void service() {
	}

	public void service(Vector<String> TextFieldInput) {
		String name = TextFieldInput.get(0);
		String phone = TextFieldInput.get(1);
		String email = TextFieldInput.get(2);

		Customer customer = new Customer(0, name, phone, email);
		dao.insert(customer);
	
	}
}
