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
import Models.CRUD.EditStatusOrders;
import entities.Client;
import entities.Orders;
import entities.Orderss;
import entities.Status_Order;
import entities.Status_Orders;

public class OrderView extends JPanel {
	entities.Orderss orderList = new Orderss();

	Status_Orders stOr = new Status_Orders();
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

		// Jpanel Header
		JPanel panelHeader = new JPanel();
		JLabel labelStt = new JLabel("STT");
		JLabel lblClientID = new JLabel("ClientID");
		JLabel lblAccountID = new JLabel("AccountID");
		JLabel lblTotal = new JLabel("TotalPrice");
		JLabel lblDateOrder = new JLabel("DateOrder");
		JLabel lblDateInstall = new JLabel("DateInstall");
		JLabel lblDateComplete = new JLabel("DateComplete");
		JLabel lblStatusOrder = new JLabel("Status");

		panelHeader.setLayout(new GridLayout(1, 1));
		panelHeader.add(labelStt);
		panelHeader.add(lblClientID);
		panelHeader.add(lblAccountID);
		panelHeader.add(lblTotal);
		panelHeader.add(lblDateOrder);
		panelHeader.add(lblDateInstall);
		panelHeader.add(lblDateComplete);
		panelHeader.add(lblStatusOrder);

		JLabel lblAction = new JLabel("Action");
		panelHeader.add(lblAction);

		scrollPane.setColumnHeaderView(panelHeader);
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

		// LoadData
		String strQuery = "SELECT * FROM ORDERS";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Orders itemO = new Orders();
				itemO.setId(rs.getInt("ID"));
				itemO.setclient_id(rs.getInt("CLIENT_ID"));
				itemO.setaccount_id(rs.getInt("ACCOUNT_ID"));
				itemO.setTotal_price(rs.getInt("TOTAL_PRICE"));
				itemO.setdate_of_order(rs.getString("DATE_OF_ORDER"));
				itemO.setdate_of_system_installed(rs.getString("DATE_OF_SYSTEM_INSTALLED"));
				itemO.setdate_of_complete(rs.getString("DATE_OF_COMPLETE"));
				itemO.setstatus(rs.getInt("STATUS_ID"));

				orderList.add(itemO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Jpanel Data
		// addPanel

		JPanel panelData = new JPanel();

		panelData.setLayout(new GridLayout(1, 1));

		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(orderList.size()+9, 0));
		int stt = 1;
		for (Orders item : orderList) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 1));
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
			lbTotal.setText(String.valueOf(item.getTotal_price()));
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
			JLabel lbStatus = new JLabel();
			pnlItem.add(lbStatus);
			for (Status_Order it : stOr) {
				if (item.getstatus() == it.getid()) {
					lbStatus.setText(it.getname());
				}
			}

			// add new Panel Action
			JPanel acPanel = new JPanel();
			acPanel.setLayout(new GridLayout(1, 1));
			JButton changeStatus = new JButton("ChangeStatus");
			changeStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idGet = item.getId();
					EditStatusOrders edc = new EditStatusOrders(idGet);
					edc.setVisible(true);

				}
			});
			//
			JButton detailBtn = new JButton("Detail");
			detailBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.OrderDetailDAO detai = new OrderDetailDAO();
					int idGet = item.getId();
					OrderDetail or = new OrderDetail(idGet);
					or.setVisible(true);
				}
			});

			acPanel.add(changeStatus);
			JPanel acPanel1 = new JPanel();
			acPanel1.setLayout(new GridLayout(1, 1));
			acPanel1.add(detailBtn);
			stt++;
			pnlItem.add(acPanel);
			pnlItem.add(acPanel1);
			panelData.add(pnlItem);
		}
		repaint();
		revalidate();
	}
}
