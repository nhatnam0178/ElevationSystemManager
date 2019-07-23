package MyLibrary;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoadTable {

	/**
	 * Load data and column label for the table
	 * 
	 * @param table       table get data
	 * @param ds          DataSource include (columName and data)
	 * @param columnIndex index of column start
	 * @author Giang
	 */
	public void load(JTable table, DataSource ds, DefaultTableModel model) {
		model.setDataVector(ds.data, ds.columNames);
		table.setModel(model);
		table.revalidate();
		table.repaint();
	}

	/**
	 * Add a button into a table
	 * 
	 * @param table  The table add the button
	 * @param column The column index need turn in button
	 */
	public void addbtn(JTable table, int[] column) {
		for (int i = 0; i < column.length; i++) {
			table.getColumnModel().getColumn(column[i]).setCellRenderer(new ButtonRenderer());
			table.getColumnModel().getColumn(column[i]).setCellEditor(new ButtonEditor(new JTextField()));
		}

	}
}
