package Models;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Config.BindingArrayList;
import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;
import entities.Account;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ClientView extends JPanel {
	ConvertTableToArrayList mdModel;
	ResultSet rs;
	ConnectionSQL conn = new ConnectionSQL();
	BindingArrayList bdata;
	entities.Accounts accs = new entities.Accounts();

	/**
	 * Create the panel.
	 */
	public ClientView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(0, 2, 0, 0));
		String strQuery = "SELECT * FROM ACCOUNT";
		//
		rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Account accItem = new entities.Account();
				accItem.setId(rs.getInt("ID"));
				accItem.setusername(rs.getString("USERNAME"));
				accItem.setpassword(rs.getString("PASSWORD"));
				accItem.setname(rs.getString("NAME"));
				accItem.setgender(rs.getBoolean("GENDER"));
				accItem.setemail(rs.getString("EMAIL"));
				accItem.setaddress(rs.getString("ADDRESS"));
				accItem.setrole_id(rs.getInt("ROLE_ID"));
				accItem.setdepartment_id(rs.getInt("DEPARTMENT_ID"));
				accs.add(accItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JScrollPane scrollPaneGird = new JScrollPane();
		scrollPaneGird.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneGird.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelGird.add(scrollPaneGird);

		//
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBorder(new LineBorder(Color.CYAN));

		JLabel lblAcc = new JLabel("Account");
		JLabel lblPass = new JLabel("Password");
		JLabel lblNameh = new JLabel("Name");
		JLabel lblGenderh = new JLabel("Gender");
		JLabel lblEmailh = new JLabel("Email");
		JLabel lblAddressh = new JLabel("Address");
		JLabel lblRoleh = new JLabel("Role");
		JLabel lblDeparth = new JLabel("Department");
		JLabel lblAction = new JLabel("Action");
		pnlHeader.setLayout(new GridLayout(1, 0, 1, 1));

		pnlHeader.add(lblAcc);
		pnlHeader.add(lblPass);
		pnlHeader.add(lblNameh);
		pnlHeader.add(lblGenderh);
		pnlHeader.add(lblEmailh);
		pnlHeader.add(lblAddressh);
		pnlHeader.add(lblRoleh);
		pnlHeader.add(lblDeparth);
		pnlHeader.add(lblAction);
		//
		scrollPaneGird.setColumnHeaderView(pnlHeader);
		JPanel pnlData = new JPanel();

		pnlData.setBounds(200, 200, 400, 400);
		scrollPaneGird.setViewportView(pnlData);
		pnlData.setLayout(new GridLayout(accs.size(), 0, 1, 1));

		for (Account account : accs) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0, 1, 1));
			JLabel lblUserName = new JLabel();
			lblUserName.setText(account.getusername());
			pnlItem.add(lblUserName);

			JLabel lblPassword = new JLabel();
			lblPassword.setText(account.getpassword());
			pnlItem.add(lblPassword);

			JLabel lblName = new JLabel();
			lblName.setText(account.getname());
			pnlItem.add(lblName);

			Object gStatus = 0;
			JLabel lblGender = new JLabel();
			if (account.getgender() == true) {
				gStatus = 1;
				lblGender.setText("Male");
			} else {
				lblGender.setText("Female");
			}
			pnlItem.add(lblGender);
			//
			JLabel lblEmail = new JLabel();
			lblEmail.setText(account.getemail());
			pnlItem.add(lblEmail);
			//
			JLabel lblPhone = new JLabel();
			lblPhone.setText(account.getphone());
			pnlItem.add(lblPhone);
			//
			JLabel lblAddress = new JLabel();
			lblAddress.setText(account.getaddress());
			pnlItem.add(lblAddress);
			//
			JLabel lblRole = new JLabel();
			int idRole = account.getrole_id();

			if (idRole == 1) {
				lblRole.setText("ADMIN");
			} else if (idRole == 2) {
				lblRole.setText("EMPLOYEE");
			} else {
				lblRole.setText("CLIENT");
			}
			pnlItem.add(lblRole);
			//
			JLabel lblDepartment = new JLabel();
			int intDepartment = account.getdepartment_id();

			if (intDepartment == 1) {
				lblRole.setText("SERVICES");
			} else if (idRole == 2) {
				lblRole.setText("COMPLAIN");
			} else {
				lblRole.setText("Order");
			}
			pnlItem.add(lblDepartment);
			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("Edit");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("---> " + account.getId());
				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			//
			JButton detailBtn = new JButton("Detail");
			detailBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});

			acPanel.add(editBtn);
			acPanel.add(deleteBtn);
			acPanel.add(detailBtn);
			pnlItem.add(acPanel);
			//
			pnlData.add(pnlItem);

		}
		pnlData.revalidate();
		pnlData.repaint();

//		for (int i = 0; i < numpnl; i++) {
//			JPanel pnlItem = new JPanel();
//			pnlItem.setLayout(new FlowLayout());
//			pnlData.add(pnlItem);
//			JButton btnItem = new JButton();
//			JLabel lbAdd = new JLabel("a" + i);
//			btnItem.setText("Delete");
//			btnItem.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//
//					JButton btn = (JButton) e.getSource();
//					JPanel pnlParrent = (JPanel) btn.getParent();
//					pnlData.remove(pnlParrent);
//					pnlData.revalidate();
//					pnlData.repaint();
//				}
//			});
//			pnlItem.add(btnItem);
//			pnlItem.add(lbAdd);
//		}
//
//		pnlData.revalidate();
//		pnlData.repaint();
//	}

	}

}
