package org.comstudy21.eventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import org.comstudy21.controller.InsertController;
import org.comstudy21.controller.ListController;
import org.comstudy21.view.ButtonView;
import org.comstudy21.view.InsertView;


public class ButtonViewEventHandler implements ActionListener {
	ButtonView buttonView;
	ListController listController = new ListController();
	InsertController insertController= new InsertController();
	InsertView insertView= new InsertView();

	public ButtonViewEventHandler(ButtonView buttonView) {
		this.buttonView = buttonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton jButton = (JButton) e.getSource();
			
			if (jButton == buttonView.seeAllBtn) {
				System.out.println("See all button");
				listController.service();
			}
			if (jButton == buttonView.insertBtn) {
				System.out.println("Insert Button");
				Vector<String> rawInputInfo= insertView.getTextField();
				
				insertController.service(rawInputInfo);
				listController.service();;
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
