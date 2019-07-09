package Models;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Config.BindingArrayList;
import Config.ConnectionSQL;
import Config.ConvertTableToArrayList;
import DAO.AccountDAO;
import MainForm.SystemForm;
import entities.Account;
import javafx.scene.layout.Background;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class AccountView extends JPanel {
	ConvertTableToArrayList mdModel;
	ResultSet rs;
	ConnectionSQL conn = new ConnectionSQL();
	BindingArrayList bdata;
	entities.Accounts accs = new entities.Accounts();
	static int idEdit;

	/**
	 * Create the panel.
	 */
	public AccountView() {

		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(1, 1));
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
				accItem.setphone(rs.getString("PHONE"));
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
		scrollPaneGird.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneGird.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneGird.setAutoscrolls(true);
		panelGird.add(scrollPaneGird);
		panelGird.revalidate();

		//
		JPanel pnlHeader = new JPanel();

		pnlHeader.setBorder(new LineBorder(Color.CYAN));
		JLabel lblSTTj = new JLabel("STT");
		JLabel lblUsernamej = new JLabel("USERNAME");
		JLabel lblPasswordj = new JLabel("PASSWORD");
		JLabel lblNamej = new JLabel("NAME");
		JLabel lblGenderj = new JLabel("GENDER");
		JLabel lblEmailj = new JLabel("EMAIL");
		JLabel lblPhonej = new JLabel("PHONE");
		JLabel lblAddressj = new JLabel("ADDRESS");
		JLabel lblRolej = new JLabel("ROLE_ID");
		JLabel lblDepartmentj = new JLabel("DEPARTMENT_ID");
		JLabel lblAction = new JLabel("ACTION");

		pnlHeader.setLayout(new GridLayout(1, 1));

		pnlHeader.add(lblSTTj);
		pnlHeader.add(lblUsernamej);
		pnlHeader.add(lblPasswordj);
		pnlHeader.add(lblNamej);
		pnlHeader.add(lblGenderj);
		pnlHeader.add(lblEmailj);
		pnlHeader.add(lblPhonej);
		pnlHeader.add(lblAddressj);
		pnlHeader.add(lblRolej);
		pnlHeader.add(lblDepartmentj);
		pnlHeader.add(lblAction);
		//
		scrollPaneGird.setColumnHeaderView(pnlHeader);
		JPanel pnlData = new JPanel();

		pnlData.setAutoscrolls(true);
		scrollPaneGird.setViewportView(pnlData);
		pnlData.setLayout(new GridLayout(accs.size(), 1));
		int stt = 1;
		for (Account account : accs) {

			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 1));
			pnlItem.setPreferredSize(new Dimension(10, 10));

			if (stt % 2 == 0) {
				pnlItem.setBackground(Color.WHITE);
			} else {
				pnlItem.setBackground(Color.CYAN);

			}
			JLabel lblSTT = new JLabel();
			lblSTT.setText(String.valueOf(stt));

			pnlItem.add(lblSTT);
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
				lblDepartment.setText("SERVICES");
			} else if (idRole == 2) {
				lblDepartment.setText("COMPLAIN");
			} else {
				lblDepartment.setText("Order");
			}
			pnlItem.add(lblDepartment);
			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("EditAccount");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idEdit = account.getId();
					EditAccount edc = new EditAccount(idEdit);
					edc.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.setSize(editBtn.getSize());
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.AccountDAO acc = new AccountDAO();
					int result = JOptionPane.showConfirmDialog(scrollPaneGird,
							"Delete Account : " + " ' " + account.getusername() + " ' " + " , " + " Are You Sure?",
							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							acc.delAccount(account.getId());
							panelGird.revalidate();
							panelGird.repaint();
						} catch (Exception e) {
							SystemForm.myArea.append(e.toString());
						}

					} else if (result == JOptionPane.NO_OPTION) {
						revalidate();
					}

				}
			});

			stt++;
			acPanel.add(editBtn);
			acPanel.add(deleteBtn);

			pnlItem.add(acPanel);
			//
			pnlData.add(pnlItem);
			pnlData.revalidate();
			pnlData.repaint();

		}
		panelGird.revalidate();
		panelGird.repaint();

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

class MyComboAction extends JComboBox {
	public MyComboAction() {
		addItem("Edit");
		addItem("Delete");
	}
}
