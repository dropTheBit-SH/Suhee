package org.comstudy21.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListView extends View {
	
	JTable table;
	static DefaultTableModel dtm = new DefaultTableModel();
	
	public ListView() {
		String[] columnsofTable = { "No", "Name", "Email", "Phone" };
		dtm.setColumnIdentifiers(columnsofTable);
		table = new JTable(dtm);
		init();
	}
	public DefaultTableModel getTableModel() {
		
		return dtm;
	}
	@Override
	public void init() {
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	@Override
	public void start() {

	}

}
