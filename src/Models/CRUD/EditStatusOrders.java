package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.OrdersDAO;
import MainForm.SystemForm;
import Models.Views.OrderView;
import entities.Status_Order;
import entities.Status_Orders;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditStatusOrders extends JDialog {
	static int idGet;
	Status_Orders stOr = new Status_Orders();

	/**
	 * Create the dialog.
	 */
	public EditStatusOrders(int idGet) {
		setBounds(100, 100, 373, 181);
		getContentPane().setLayout(null);

		JLabel lblSelectNewStatus = new JLabel("SELECT NEW STATUS For ORDER");
		lblSelectNewStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectNewStatus.setBounds(83, 11, 251, 19);
		getContentPane().add(lblSelectNewStatus);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 55, 68, 14);
		getContentPane().add(lblStatus);
		// LoadStatusView
		String str1 = "SELECT * FROM STATUS_ORDER";
		ResultSet rs1 = ConnectionSQL.Query(str1);

		try {
			while (rs1.next()) {
				entities.Status_Order dep = new Status_Order();
				dep.setid(rs1.getInt("ID"));
				dep.setname(rs1.getString("NAME"));

				stOr.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 52, 251, 20);
		getContentPane().add(comboBox);
		for (Status_Order item : stOr) {
			comboBox.addItem(item.getname());
		}
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idS = 0;
				for (Status_Order it : stOr) {
					if (comboBox.getSelectedItem().toString().equals(it.getname())) {
						idS = it.getid();
					}
				}
				DAO.OrdersDAO orDao = new OrdersDAO();
				try {
					orDao.changeStatus(idGet, idS);
					OrderView aor = new OrderView();
					aor.setVisible(true);
					SystemForm.myTables[3].removeAll();
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					SystemForm.myTables[3].add(new OrderView());
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(123, 107, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(245, 107, 89, 23);
		getContentPane().add(btnNewButton_1);
	}
}
