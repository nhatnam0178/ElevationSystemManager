package Models;

import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;

public class AccountTable extends JPanel {
	private JTable myTableAccount;
	ConvertTableToArrayList cvTable;
	ResultSet rs;
	private JScrollPane mySpane;
	ConnectionSQL conn;

	/**
	 * Create the panel.
	 */
	public AccountTable(ConnectionSQL conn) {
		try {
			conn.Connect();
			cvTable = new ConvertTableToArrayList(rs);
			String query = "Select * from Account";
			rs = conn.Query(query);
			cvTable = new ConvertTableToArrayList(rs);
			myTableAccount = new JTable(cvTable);
			myTableAccount.setBounds(225, 5, 0, 0);
			add(myTableAccount);
			mySpane = new JScrollPane(myTableAccount, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySpane);
			add(myTableAccount);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void ChangeModel() {
		rs = conn.Query("Select * from Account");
		cvTable = new ConvertTableToArrayList(rs);
		myTableAccount.setModel(cvTable);
	}

}
