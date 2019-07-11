package Models;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.swing.JScrollPane;

import Config.ConnectionSQL;
import entities.Product_Elevation;
import entities.Product_Elevations;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ProductView extends JPanel {
	private JPanel panelData;
	entities.Product_Elevations products = new Product_Elevations();

	/**
	 * Create the panel.
	 */
	public ProductView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird, BorderLayout.NORTH);
		panelGird.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();
		panelGird.add(scrollPane);

		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(1, 1));

		panelData = new JPanel();
		panelData.setLayout(new GridLayout(1, 1));

		scrollPane.setColumnHeaderView(panelHeader);

		JLabel lblNewLabel = new JLabel("STT");
		panelHeader.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Name");
		panelHeader.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Type");
		panelHeader.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Price");
		panelHeader.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Date_of_Order");
		panelHeader.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Warranty");
		panelHeader.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Warranty_expire_date");
		panelHeader.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Action");
		panelHeader.add(lblNewLabel_7);

		scrollPane.setViewportView(panelData);
		// Load Data
		String strQuery = "SELECT * FROM PRODUCT_ELEVATION";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Product_Elevation pro = new Product_Elevation();
				pro.setId(rs.getInt("ID"));
				pro.setname(rs.getString("NAME"));
				pro.settype(rs.getString("TYPE"));
				pro.setprice(rs.getDouble("PRICE"));
				pro.setdate_of_order(rs.getDate("DATE_OF_ORDER"));
				pro.setwarranty(rs.getInt("WARRANTY"));
				pro.setwarranty_expire_date(1);

				products.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stt = 1;
		for (Product_Elevation item : products) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 1));
			pnlItem.setPreferredSize(new Dimension(10, 10));
			JLabel lbStt = new JLabel();
			lbStt.setText(String.valueOf(stt));
			pnlItem.add(lbStt);
			JLabel lbName = new JLabel();
			lbName.setText(item.getname());
			pnlItem.add(lbName);
			JLabel lbType = new JLabel();
			lbType.setText(item.gettype());
			pnlItem.add(lbType);
			JLabel lbPrice = new JLabel();
			lbPrice.setText(String.valueOf(item.getprice()));
			pnlItem.add(lbPrice);
			JLabel lbDateofOrder = new JLabel();
			lbDateofOrder.setText(item.getdate_of_order().toString());
			pnlItem.add(lbDateofOrder);
			JLabel lbWarranty = new JLabel();
			lbWarranty.setText(String.valueOf(item.getwarranty()));
			pnlItem.add(lbWarranty);
//			JLabel lbWarrantyExpire = new JLabel();
//			lbWarrantyExpire.setText(item.getwarranty_expire_date());
//			pnlItem.add(lbWarrantyExpire);
			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("Edit");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
////					idEdit = account.getId();
//					EditAccount edc = new EditAccount(idEdit);
//					edc.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
//					DAO.AccountDAO acc = new AccountDAO();
//					int result = JOptionPane.showConfirmDialog(scrollPaneGird,
//							"Delete Account : " + " ' " + account.getusername() + " ' " + " , " + " Are You Sure?",
//							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//					if (result == JOptionPane.YES_OPTION) {
//						try {
//							acc.delAccount(account.getId());
//							panelGird.revalidate();
//							panelGird.repaint();
//						} catch (Exception e) {
//							SystemForm.myArea.append(e.toString());
//						}
//
//					} else if (result == JOptionPane.NO_OPTION) {
//						revalidate();
//					}
//
				}
			});

			stt++;
			acPanel.add(editBtn);
			acPanel.add(deleteBtn);

			pnlItem.add(acPanel);
			//
			panelData.add(pnlItem);
			panelData.revalidate();
			panelData.repaint();

		}
	}

}
