package Models;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;

import java.awt.GridLayout;
import java.sql.ResultSet;

public class AccountView extends JPanel {
	ConvertTableToArrayList cvTable;
	ResultSet rs;


	/**
	 * Create the panel.
	 */
	public AccountView() {
		setLayout(null);

		JPanel jPanelTable = new JPanel();
		add(jPanelTable);

		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String query = "Select * from ACCOUNT";
		rs = conn.Query(query);
		cvTable = new ConvertTableToArrayList(rs);
		int x = cvTable.getColumnCount();
		int y = cvTable.getRowCount();

		jPanelTable.setLayout(new GridLayout(x, y));

	}
}
