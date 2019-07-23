package MyLibrary;

import java.util.ArrayList;

public class DataSource {
	public Object[] columNames;
	public Object[][] data;

	public DataSource() {
		columNames = null;
		data = null;
	}

	/**
	 * Constructor have parameter
	 * 
	 * @param column list of column Names ArrayList
	 * @param datas  list of data for Rows ArrayList
	 * @author Giang
	 */
	public DataSource(ArrayList<Object> column, ArrayList<Object[]> datas) {
		columNames = new String[column.size()];
		int count = 0;
		for (Object str : column) {
			columNames[count] = str;
			count++;
		}
		data = new Object[datas.size()][column.size()];

		int index = 0;
		for (Object[] objects : datas) {

			for (int j = 0; j < objects.length; j++) {
				data[index][j] = objects[j];
			}
			index++;
		}

	}
}
