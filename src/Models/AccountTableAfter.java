package Models;

import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;
import MainForm.SystemForm;

public class AccountTableAfter extends JPanel {
	JTable myTableAccount;
	ConvertTableToArrayList cvTable;
	ResultSet rs;
	JScrollPane mySpane;

	/**
	 * Create the panel.
	 */
	public AccountTableAfter() {
		try {
			ConnectionSQL conn = new ConnectionSQL();
			conn.Connect();
			String query = "Select * from ACCOUNT";
			rs = conn.Query(query);
			cvTable = new ConvertTableToArrayList(rs);
			myTableAccount = new JTable(cvTable);

			add(myTableAccount);

			mySpane = new JScrollPane(myTableAccount, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySpane);
		} catch (Exception e) {
			SystemForm.myArea.append(e.toString());
		}

	}

	public void ChangeModel() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String qr = "Select * from ACCOUNT";
		rs = conn.Query(qr);
		cvTable = new ConvertTableToArrayList(rs);
		myTableAccount.setModel(cvTable);
	}

}
