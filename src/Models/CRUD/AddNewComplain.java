package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.ComplainDAO;
import entities.Account;
import entities.Accounts;
import entities.Orders;
import entities.Orderss;
import entities.Status_Complain;
import entities.Status_Complains;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AddNewComplain extends JDialog {

	private JPanel contentPane;
	private JTextField txtProblem;
	private JTextField txtDate;
	private JTextField txtPerson;
	Orderss ors = new Orderss();
	Accounts accs = new Accounts();
	Status_Complains sts = new Status_Complains();

	/**
	 * Create the frame.
	 */
	public AddNewComplain(JFrame root) {
		setTitle("ADD NEW COMPLAIN");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 365, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewComplain = new JLabel("INPUT NEW COMPLAIN");
		lblInputNewComplain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewComplain.setBounds(125, 11, 203, 14);
		contentPane.add(lblInputNewComplain);

		JLabel lblOrderid = new JLabel("Order_ID:");
		lblOrderid.setBounds(10, 45, 91, 14);
		contentPane.add(lblOrderid);

		JLabel lblAccountid = new JLabel("Account_ID:");
		lblAccountid.setBounds(10, 80, 91, 14);
		contentPane.add(lblAccountid);

		JLabel lblNewLabel = new JLabel("IS_Chargeable:");
		lblNewLabel.setBounds(10, 115, 91, 14);
		contentPane.add(lblNewLabel);

		JComboBox comboBoxIsChargeable = new JComboBox();
		comboBoxIsChargeable.setModel(new DefaultComboBoxModel(new String[] { "Yes", "No" }));
		comboBoxIsChargeable.setBounds(111, 112, 85, 20);
		contentPane.add(comboBoxIsChargeable);

		JComboBox comboBoxOrderID = new JComboBox();
		comboBoxOrderID.setBounds(111, 42, 217, 20);
		contentPane.add(comboBoxOrderID);
		// LoadData
		String strQuery = "SELECT * FROM ORDERS";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Orders itemO = new Orders();
				itemO.setId(rs.getInt("ID"));
				itemO.setclient_id(rs.getInt("CLIENT_ID"));
				itemO.setaccount_id(rs.getInt("ACCOUNT_ID"));

				itemO.setstatus(rs.getInt("STATUS_ID"));
				ors.add(itemO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Orders item : ors) {
			comboBoxOrderID.addItem(item.getId());
		}

		JComboBox comboBoxAccountID = new JComboBox();
		comboBoxAccountID.setBounds(111, 77, 217, 20);
		contentPane.add(comboBoxAccountID);
		String strQuery1 = "SELECT * FROM ACCOUNT";
		//
		rs = ConnectionSQL.Query(strQuery1);
		try {
			while (rs.next()) {
				entities.Account accItem = new entities.Account();
				accItem.setId(rs.getInt("ID"));
				accItem.setusername(rs.getString("USERNAME"));

				accItem.setname(rs.getString("NAME"));
				accs.add(accItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Account item : accs) {
			comboBoxAccountID.addItem(item.getname());
		}

		JLabel lblProblem = new JLabel("Problem:");
		lblProblem.setBounds(10, 153, 91, 14);
		contentPane.add(lblProblem);

		txtProblem = new JTextField();
		txtProblem.setBounds(111, 150, 217, 20);
		contentPane.add(txtProblem);
		txtProblem.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Date_Complain:");
		lblNewLabel_1.setBounds(10, 188, 100, 14);
		contentPane.add(lblNewLabel_1);

		txtDate = new JTextField();
		txtDate.setBounds(111, 185, 117, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 229, 91, 14);
		contentPane.add(lblStatus);

		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(111, 226, 217, 20);
		contentPane.add(comboBoxStatus);
		String strQ = "SELECT * FROM STATUS_COMPLAIN";
		rs = ConnectionSQL.Query(strQ);

		try {
			while (rs.next()) {
				entities.Status_Complain stac = new Status_Complain();
				stac.setId(rs.getInt("ID"));
				stac.setname(rs.getString("NAME"));

				sts.add(stac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Status_Complain item : sts) {
			comboBoxStatus.addItem(item.getname());
		}

		JLabel lblTechnicalperson = new JLabel("Technical_Person:");
		lblTechnicalperson.setBounds(10, 270, 100, 14);
		contentPane.add(lblTechnicalperson);

		txtPerson = new JTextField();
		txtPerson.setBounds(111, 267, 217, 20);
		contentPane.add(txtPerson);
		txtPerson.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(250, 325, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ComplainDAO compDao = new ComplainDAO();
				try {
					int orID = 0;
					for (Orders it : ors) {
						if (comboBoxOrderID.getSelectedItem().equals(it.getId())) {
							orID = it.getId();
						}
					}

					int acc_id = 0;
					for (Account it : accs) {
						if (comboBoxAccountID.getSelectedItem().equals(it.getname())) {
							acc_id = it.getId();
						}
					}

					int statusComplain_id = 0;
					for (Status_Complain item1 : sts) {
						if (comboBoxStatus.getSelectedItem().equals(item1.getname())) {
							statusComplain_id = item1.getId();
						}
					}
					int isChar = 0;
					if (comboBoxIsChargeable.getSelectedItem().equals("Yes")) {
						isChar = 1;
					}
					compDao.insertComplain(orID, acc_id, isChar, String.valueOf(txtProblem.getText()),
							String.valueOf(txtDate.getText()), statusComplain_id, String.valueOf(txtPerson.getText()));
					dispose();
				} catch (Exception e2) {
					System.err.println(e2.getStackTrace());
				}

			}

		});
		btnOk.setBounds(151, 325, 89, 23);
		contentPane.add(btnOk);

		JButton btnGetDate = new JButton("GetDate");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl = new Calendar(txtDate);
				cl.setVisible(true);
			}
		});
		btnGetDate.setBounds(239, 184, 89, 23);
		contentPane.add(btnGetDate);
	}
}
