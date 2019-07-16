package Models.Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import entities.Client;
import entities.Orders;
import entities.Orderss;

public class OrderView extends JPanel {
	entities.Orderss orderList = new Orderss();

	/**
	 * Create the panel.
	 */
	static int idGet;

	public OrderView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGrid = new JPanel();
		add(panelGrid);
		panelGrid.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelGrid.add(scrollPane);

		JPanel panelData = new JPanel();

		panelData.setLayout(new GridLayout(1, 1));

		// Jpanel Header
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(1, 1));

		JLabel labelStt = new JLabel("STT");
		panelHeader.add(labelStt);

		JLabel lblClientID = new JLabel("Client ID");
		panelHeader.add(lblClientID);

		JLabel lblTotal = new JLabel("Total Price");
		panelHeader.add(lblTotal);

		JLabel lblDateOrder = new JLabel("Date Order");
		panelHeader.add(lblDateOrder);

		JLabel lblDateInstall = new JLabel("Date Install");
		panelHeader.add(lblDateInstall);

		JLabel lblDateComplete = new JLabel("Date Complete");
		panelHeader.add(lblDateComplete);

		JLabel lblStatusOrder = new JLabel("Status");
		panelHeader.add(lblStatusOrder);

		JLabel lblAction = new JLabel("Action");
		panelHeader.add(lblAction);
		panelHeader.setLayout(new GridLayout(1, 1));

		scrollPane.setColumnHeaderView(panelHeader);
		// LoadData
		String strQuery = "SELECT * FROM ORDERS";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Orders itemO = new Orders();
				itemO.setId(rs.getInt("ID"));
				itemO.setclient_id(rs.getInt("CLIENT_ID"));
				itemO.setaccount_id(rs.getInt("ACCOUNT_ID"));
				itemO.settotal_price(rs.getDouble("TOTAL_PRICE"));
				itemO.setdate_of_order(rs.getDate("DATE_OF_ORDER"));
				itemO.setdate_of_system_installed(rs.getDate("DATE_OF_SYSTEM_INSTALLED"));
				itemO.setdate_of_complete(rs.getDate("DATE_OF_COMPLETE"));
				itemO.setstatus(rs.getInt("STATUS_ID"));

				orderList.add(itemO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Jpanel Data
		// addPanel
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(orderList.size() + 5, 0));
		int stt = 1;
		for (Orders item : orderList) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0));
			pnlItem.setPreferredSize(new Dimension(10, 10));

			JLabel lbStt = new JLabel();
			lbStt.setText(String.valueOf(stt));
			pnlItem.add(lbStt);
			JLabel lbClientID = new JLabel();
			lbClientID.setText(String.valueOf(item.getclient_id()));
			pnlItem.add(lbClientID);

			JLabel lbAccountId = new JLabel();
			lbAccountId.setText(String.valueOf(item.getaccount_id()));
			pnlItem.add(lbAccountId);

			JLabel lbTotal = new JLabel();
			lbTotal.setText(String.valueOf(item.gettotal_price()));
			pnlItem.add(lbTotal);

			JLabel lbDateofOrder = new JLabel();
			lbDateofOrder.setText(item.getdate_of_order().toString());
			pnlItem.add(lbDateofOrder);

			JLabel lbDateofInstall = new JLabel();
			lbDateofInstall.setText(item.getdate_of_system_installed().toString());
			pnlItem.add(lbDateofInstall);

			JLabel lbDateofComplete = new JLabel();
			lbDateofComplete.setText(item.getdate_of_complete().toString());
			pnlItem.add(lbDateofComplete);

			// add new Panel Action
			JPanel acPanel = new JPanel();
			acPanel.setLayout(new GridLayout(1, 1));
			JButton editBtn = new JButton("ChangeStatus");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
////							idEdit = account.getId();
//							EditAccount edc = new EditAccount(idEdit);
//							edc.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Detail");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.OrderDetailDAO detai = new OrderDetailDAO();
					int idGet = item.getId();
					OrderDetail or = new OrderDetail(idGet);
					or.setVisible(true);
				}
			});

			acPanel.add(editBtn);
			acPanel.add(deleteBtn);
			stt++;
			pnlItem.add(acPanel);
			panelData.add(pnlItem);
		}
		repaint();
		revalidate();
	}
}
