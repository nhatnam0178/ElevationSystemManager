package Models.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Config.ConnectionSQL;
import DAO.ClientDAO;
import MainForm.SystemForm;
import Models.CRUD.EditClient;
import entities.Client;
import entities.Clients;
import java.awt.Component;

public class ClientView extends JPanel {
	entities.Clients clients = new Clients();
	ConnectionSQL conn = new ConnectionSQL();
	static int idEdit;

	public ClientView() {
		setLayout(new BorderLayout(0, 0));
		JPanel panelGird = new JPanel();
		panelGird.setLayout(new GridLayout(1, 1));
		add(panelGird);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		panelGird.add(scrollPane);
//Jpanel Header
		JPanel panelHeader = new JPanel();
		JLabel label1 = new JLabel();
		panelHeader.add(label1);
		JLabel label = new JLabel("STT");
		panelHeader.add(label);

		JLabel lblName = new JLabel("Name");
		panelHeader.add(lblName);

		JLabel lblNewLabel = new JLabel("Phone");
		panelHeader.add(lblNewLabel);

		JLabel lblAdd = new JLabel("Address");
		panelHeader.add(lblAdd);

		JLabel lblNewLabel_1 = new JLabel("CompanyName");
		panelHeader.add(lblNewLabel_1);

		JLabel lblAction = new JLabel("Action");
		panelHeader.add(lblAction);
		panelHeader.setLayout(new GridLayout(1, 1));
		scrollPane.setColumnHeaderView(panelHeader);
		// LoadData
		String strQuery = "SELECT * FROM CLIENT";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Client itemCli = new Client();
				itemCli.setId(rs.getInt("ID"));
				itemCli.setname(rs.getString("NAME"));
				itemCli.setphone(rs.getString("PHONE"));
				itemCli.setaddress(rs.getString("ADDRESS"));
				itemCli.setcompany_name(rs.getString("COMPANY_NAME"));
				clients.add(itemCli);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Jpanel Data
		JPanel panelData = new JPanel();
		// addPanel
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(clients.size() + 14, 1));
		int stt = 1;
		for (Client item : clients) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0));
			pnlItem.setPreferredSize(new Dimension(10, 10));
			
			JLabel lb1 = new JLabel();
			pnlItem.add(lb1);
			JLabel lbStt = new JLabel();
			lbStt.setText(String.valueOf(stt));
			if (stt % 2 == 0) {
				pnlItem.setBackground(Color.WHITE);
			} else {
				pnlItem.setBackground(Color.CYAN);

			}
			pnlItem.add(lbStt);
			JLabel lbName = new JLabel();
			lbName.setText(item.getname());
			pnlItem.add(lbName);
			JLabel lbPhone = new JLabel();
			lbPhone.setText(item.getphone());
			pnlItem.add(lbPhone);
			JLabel lbAddress = new JLabel();
			lbAddress.setText(item.getaddress());
			pnlItem.add(lbAddress);
			JLabel lbCompany = new JLabel();
			lbCompany.setText(item.getcompany_name());
			pnlItem.add(lbCompany);
			// add new Panel Action
			JPanel acPanel = new JPanel();
			acPanel.setLayout(new GridLayout(1, 1));
			JButton editBtn = new JButton("Edit");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idEdit = item.getId();
					EditClient edcl = new EditClient(idEdit);
					edcl.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.ClientDAO cliDao = new ClientDAO();
					int result = JOptionPane.showConfirmDialog(panelGird,
							"Delete Account : " + " ' " + item.getId() + " ' " + " , " + " Are You Sure?",
							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							cliDao.delClient(item.getId());
							ClientView act = new ClientView();
							act.setVisible(true);
							SystemForm.myTables[1].removeAll();
							SystemForm.myTables[1].validate();
							SystemForm.myTables[1].repaint();
							SystemForm.myTables[1].add(new ClientView());
							SystemForm.myTables[1].validate();
							SystemForm.myTables[1].repaint();
						} catch (Exception e) {
							System.err.println(e.getStackTrace());
						}

					} else if (result == JOptionPane.NO_OPTION) {
						revalidate();
					}

				}
			});

			acPanel.add(editBtn);
			acPanel.add(deleteBtn);

			pnlItem.add(acPanel);
			//
			panelData.add(pnlItem);
			stt++;
		}
		repaint();
		revalidate();
	}

}
