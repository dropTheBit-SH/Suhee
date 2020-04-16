package org.comstudy21.eventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.comstudy21.controller.InsertController;
import org.comstudy21.controller.ListController;
import org.comstudy21.view.ButtonView;


public class ButtonViewEventHandler implements ActionListener {
	public ButtonView buttonView;
	
	public ListController listController;
	public InsertController insertController;
	
	public ButtonViewEventHandler(ButtonView buttonView) {
		this.buttonView = buttonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listController = new ListController();
		insertController = new InsertController();
		
		if (e.getSource() instanceof JButton) {
			JButton jButton = (JButton) e.getSource();
			
			if (jButton == buttonView.seeAllBtn) {
				System.out.println("See all button");
				listController.service();
			}
			if (jButton == buttonView.insertBtn) {
				System.out.println("Insert Button");
				insertController.service();
			}
			if (jButton == buttonView.searchBtn) {
				System.out.println("Search button");
			}
			if (jButton == buttonView.deleteBtn) {
				System.out.println("Delete button");
			}
			if (jButton == buttonView.modifyBtn) {
				System.out.println("See all button");
			}
			if (jButton == buttonView.exitBtn) {
				System.out.println("Exit button");
			}

		}

	}

}
