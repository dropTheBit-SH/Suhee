package org.comstudy21.controller;

import java.util.Vector;

public class ListController implements Controller {

	public ListController() {
	}

	@Override
	public void service() {

		Vector<Vector<Object>> dataList;
		dataList = dao.selectAll();
		
		while (listView.getTableModel().getRowCount() > 0) {
			listView.getTableModel().removeRow(0);
		}

		for (Vector<Object> data : dataList) {
			listView.getTableModel().addRow(data);
		}
	}
}
