package org.comstudy21.view;

import java.awt.Color;

import javax.swing.JButton;
import org.comstudy21.eventHandler.ButtonViewEventHandler;

public class ButtonView extends View {	
	
	public JButton seeAllBtn= new JButton("See all");
	public JButton insertBtn= new JButton("Insert");
	public JButton searchBtn= new JButton ("Search");
	public JButton deleteBtn= new JButton ("Delete");
	public JButton modifyBtn= new JButton("Modify");
	public JButton exitBtn= new JButton("Exit");
	
	public ButtonView() {
		init();
		start();
	}
	
	@Override
	public void init() {
		add(seeAllBtn);
		add(insertBtn);
		add(searchBtn);
		add(deleteBtn);
		add(modifyBtn);
		add(exitBtn);
	}

	@Override
	public void start() {
		ButtonViewEventHandler handler= new ButtonViewEventHandler(this);
		
		seeAllBtn.addActionListener(handler);
		insertBtn.addActionListener(handler);
		searchBtn.addActionListener(handler);
		deleteBtn.addActionListener(handler);
		modifyBtn.addActionListener(handler);
		exitBtn.addActionListener(handler);
		
		
	}

}
