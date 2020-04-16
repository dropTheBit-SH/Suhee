package org.comstudy21.controller;

import org.comstudy21.model.Dao;
import org.comstudy21.view.ButtonView;
import org.comstudy21.view.InsertView;
import org.comstudy21.view.ListView;
import org.comstudy21.view.Test;

public interface Controller extends Test{
	
	Dao dao= new Dao();
	
	void service();
}
