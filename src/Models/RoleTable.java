package Models;

import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;
import MainForm.SystemForm;

public class RoleTable extends JPanel {
	JTable myTableRole;
	ConvertTableToArrayList cvTable;
	ResultSet rs;
	JScrollPane mySpane;

	/**
	 * Create the panel.
	 */
	public RoleTable() {

		try {
			ConnectionSQL conn = new ConnectionSQL();
			conn.Connect();
			String query = "Select * from ROLE";
			rs = conn.Query(query);
			cvTable = new ConvertTableToArrayList(rs);
			myTableRole = new JTable(cvTable);

			add(myTableRole);

			mySpane = new JScrollPane(myTableRole, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySpane);
		} catch (Exception e) {
			SystemForm.myArea.append(e.toString());
		}
	}

	public void ChangeModel() {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String qr = "Select * from ROLE";
		rs = conn.Query(qr);
		cvTable = new ConvertTableToArrayList(rs);
		myTableRole.setModel(cvTable);
	}

}
