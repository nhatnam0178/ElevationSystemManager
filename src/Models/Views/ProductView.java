package Models.Views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Config.ConnectionSQL;
import DAO.AccountDAO;
import DAO.ProductElevationDAO;
import MainForm.SystemForm;
import Models.CRUD.AddNewProduct;
import Models.CRUD.EditAccount;
import Models.CRUD.EditProduct;
import entities.Product_Elevation;
import entities.Product_Elevations;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProductView extends JPanel {
	entities.Product_Elevations products = new Product_Elevations();
	ConnectionSQL conn = new ConnectionSQL();
	static int idEdit;

	/**
	 * Create the panel.
	 */
	public ProductView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelGird.add(scrollPane);

		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(1, 1));
		JLabel lblNewLabe1l = new JLabel();
		panelHeader.add(lblNewLabe1l);

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

		scrollPane.setColumnHeaderView(panelHeader);
		JPanel panelData = new JPanel();
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(products.size() + 9, 1));
		// Load Data

		String strQuery = "SELECT * FROM PRODUCT_ELEVATION";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Product_Elevation pro = new Product_Elevation();
				pro.setId(rs.getInt("ID"));
				pro.setname(rs.getString("NAME"));
				pro.settype(rs.getString("TYPE"));
				pro.setPrice(rs.getInt("PRICE"));
				pro.setdate_of_order(rs.getString("DATE_OF_ORDER"));
				pro.setwarranty(rs.getInt("WARRANTY"));
				pro.setwarranty_expire_date(rs.getString("WARRANTY_EXPIRE_DATE"));

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

			JLabel lblNewLabel1 = new JLabel();
			pnlItem.add(lblNewLabel1);
			JLabel lbStt = new JLabel();
			lbStt.setText(String.valueOf(stt));
			pnlItem.add(lbStt);
			if (stt % 2 == 0) {
				pnlItem.setBackground(Color.WHITE);
			} else {
				pnlItem.setBackground(Color.CYAN);

			}
			JLabel lbName = new JLabel();
			lbName.setText(item.getname());
			pnlItem.add(lbName);

			JLabel lbType = new JLabel();
			lbType.setText(item.gettype());
			pnlItem.add(lbType);

			JLabel lbPrice = new JLabel();
			lbPrice.setText(String.valueOf(item.getPrice()));
			pnlItem.add(lbPrice);

			JLabel lbDateofOrder = new JLabel();
			lbDateofOrder.setText(item.getdate_of_order());
			pnlItem.add(lbDateofOrder);

			JLabel lbWarranty = new JLabel();
			lbWarranty.setText(String.valueOf(item.getwarranty()));
			pnlItem.add(lbWarranty);

			JLabel lbWarrantyExpire = new JLabel();
			lbWarrantyExpire.setText(item.getwarranty_expire_date());
			pnlItem.add(lbWarrantyExpire);

			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("Edit     ");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idEdit = item.getId();
					EditProduct epc = new EditProduct(idEdit);
					epc.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.ProductElevationDAO proDAO = new ProductElevationDAO();
					int result = JOptionPane.showConfirmDialog(scrollPane,
							"Delete Account : " + " ' " + item.getname() + " ' " + " , " + " Are You Sure?",
							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							proDAO.delProduct(item.getId());
							ProductView pvw = new ProductView();
							pvw.setVisible(true);
							SystemForm.myTables[2].removeAll();
							SystemForm.myTables[2].validate();
							SystemForm.myTables[2].repaint();
							SystemForm.myTables[2].add(new ProductView());
							SystemForm.myTables[2].validate();
							SystemForm.myTables[2].repaint();

						} catch (Exception e) {
							System.out.println(e.getStackTrace());
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
			panelData.add(pnlItem);
		}
		repaint();

		revalidate();
	}
}
