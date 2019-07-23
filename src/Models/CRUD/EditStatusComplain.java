package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.ComplainDAO;
import MainForm.SystemForm;
import Models.Views.ComplainView;
import entities.Complain;
import entities.Status_Complain;
import entities.Status_Complains;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditStatusComplain extends JDialog {
	static int idGet;
	entities.Status_Complains stComp = new Status_Complains();
	JComboBox cbStatus = new JComboBox();
	JComboBox cbIsChar = new JComboBox();

	/**
	 * Create the dialog.
	 */
	public EditStatusComplain(int idGet) {
		setBounds(100, 100, 299, 160);
		getContentPane().setLayout(null);

		JLabel lblNewStatusComlain = new JLabel("New Status Comlain: ");
		lblNewStatusComlain.setBounds(10, 11, 116, 14);
		getContentPane().add(lblNewStatusComlain);
		//
		ComplainDAO cpDao = new ComplainDAO();
		ResultSet rs1 = cpDao.findbyId(idGet);
		Complain comItem = new Complain();
		try {
			while (rs1.next()) {

				comItem.setId(rs1.getInt("ID"));
				comItem.setorder_id(rs1.getInt("ORDER_ID"));
				comItem.setaccount_id(rs1.getInt("ACCOUNT_ID"));
				comItem.setis_chargeable(rs1.getBoolean("IS_CHARGEABLE"));
				comItem.setproblem(rs1.getString("PROBLEM"));
				comItem.setdate_complain(rs1.getDate("DATE_COMPLAIN"));
				comItem.setstatus_id(rs1.getInt("STATUS_ID"));
				comItem.settechnician_person(rs1.getString("TECHNICIAN_PERSON"));
				//

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String str = "SELECT * FROM STATUS_COMPLAIN";
		ResultSet rs = ConnectionSQL.Query(str);

		try {
			while (rs.next()) {
				entities.Status_Complain dep = new Status_Complain();
				dep.setId(rs.getInt("ID"));
				dep.setname(rs.getString("NAME"));

				stComp.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cbStatus.setBounds(136, 8, 135, 20);
		getContentPane().add(cbStatus);
		cbStatus.addItem("Solved");
		cbStatus.addItem("Cannot be solved");
		cbStatus.addItem("Pending");
		if (comItem.getstatus_id() == 1) {
			cbStatus.setSelectedIndex(0);
		} else if (comItem.getstatus_id() == 2) {
			cbStatus.setSelectedIndex(1);
		} else {
			cbStatus.setSelectedIndex(2);
		}
		JLabel lblIsCharge = new JLabel("Is Charge:");
		lblIsCharge.setBounds(10, 48, 98, 14);
		getContentPane().add(lblIsCharge);

		cbIsChar.setBounds(136, 45, 89, 20);
		getContentPane().add(cbIsChar);
		cbIsChar.addItem("Yes");
		cbIsChar.addItem("No");
		if (comItem.getis_chargeable() == true) {
			cbIsChar.setSelectedIndex(0);
		} else {
			cbIsChar.setSelectedIndex(1);
		}
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(182, 87, 89, 23);
		getContentPane().add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.ComplainDAO cmDao = new ComplainDAO();
				int isChar = 0;
				if (cbIsChar.getSelectedIndex() == 0) {
					isChar = 1;
				}
				int status = 0;
				if (comItem.getstatus_id() == 1) {
					status = 1;
				} else if (comItem.getstatus_id() == 2) {
					status = 2;
				} else {
					status = 3;
				}
				try {
					cmDao.ChangeStatus(idGet, isChar, status);
					ComplainView adcom = new ComplainView();
					adcom.setVisible(true);
					SystemForm.myTables[5].removeAll();
					SystemForm.myTables[5].validate();
					SystemForm.myTables[5].repaint();
					SystemForm.myTables[5].add(new ComplainView());
					SystemForm.myTables[5].validate();
					SystemForm.myTables[5].repaint();
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnOk.setBounds(80, 87, 89, 23);
		getContentPane().add(btnOk);

	}
}
