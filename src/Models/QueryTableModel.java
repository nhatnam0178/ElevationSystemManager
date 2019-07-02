package Models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Config.ConnectionSQL;

public class QueryTableModel extends AbstractTableModel {


	int colCount;

	String[] headers;

	ConnectionSQL conn = new ConnectionSQL();
	ResultSet rs;
	ResultSetMetaData rsmd;

	public String getColumnName(int i) {
		return headers[i];
	}

	public int getColumnCount() {
		return colCount;
	}



	// All the real work happens here; in a real application,
	// we'd probably perform the query in a separate thread.
	public void setQuery() {
		
		try {
			String strQuery = "SELECT * FROM ACCOUNT";
			// Execute the query and store the result set and its metadata
			rs = ConnectionSQL.Query(strQuery);
			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount();

			// Now we must rebuild the headers array with the new column names
			headers = new String[colCount];
			for (int h = 1; h <= colCount; h++) {
				headers[h - 1] = meta.getColumnName(h);
			}

			// and file the cache with the records from our query. This would
			// not be
			// practical if we were expecting a few million records in response
			// to our
			// query, but we aren't, so we can do this.
			while (rs.next()) {
				String[] record = new String[colCount];
				for (int i = 0; i < colCount; i++) {
					record[i] = rs.getString(i + 1);
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
