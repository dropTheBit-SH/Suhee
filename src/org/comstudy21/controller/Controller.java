package org.comstudy21.controller;

import org.comstudy21.model.Dao;
import org.comstudy21.view.ButtonView;
import org.comstudy21.view.InsertView;
import org.comstudy21.view.ListView;

public interface Controller {
	
	ButtonView buttonView= new ButtonView();
	InsertView inputView=new InsertView();
	ListView listView= new ListView();
	Dao dao= new Dao();
	
	
	void service();
	
}
