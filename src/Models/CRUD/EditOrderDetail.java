package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderDetailDAO;
import DAO.ProductElevationDAO;
import MainForm.SystemForm;
import Models.Views.OrderView;
import entities.Order_Detail;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class EditOrderDetail extends JDialog {
	private JTextField txtOrderId;
	private JTextField txtProductName;
	private JTextField txtNums;
	private JTextField txtPrice;
	private JTextField txtDateExp;
	private JComboBox cbWarrantyPeriod = new JComboBox();
	static int idSend;

	/**
	 * Create the dialog.
	 */
	public EditOrderDetail(int idSend) {
		setBounds(100, 100, 401, 395);
		getContentPane().setLayout(null);

		JLabel lblEditOrderDetail = new JLabel("EDIT ORDER DETAIL");
		lblEditOrderDetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditOrderDetail.setBounds(166, 11, 258, 27);
		getContentPane().add(lblEditOrderDetail);

		JLabel label = new JLabel("Order_ID: ");
		label.setBounds(10, 52, 108, 21);
		getContentPane().add(label);

		JLabel label_2 = new JLabel("Product_Name:");
		label_2.setBounds(10, 90, 93, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Num_Of_System_Installed:");
		label_3.setBounds(10, 123, 160, 21);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Price:");
		label_4.setBounds(10, 167, 65, 14);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("Warranty_Perriod:");
		label_5.setBounds(10, 202, 132, 14);
		getContentPane().add(label_5);

		JLabel label_6 = new JLabel("Warranty_Expire_Date:");
		label_6.setBounds(10, 241, 147, 21);
		getContentPane().add(label_6);
		// GET DATA FROM DB by Resulset
		DAO.OrderDetailDAO orDao = new OrderDetailDAO();
		ResultSet rs = orDao.findbyId(idSend);
		entities.Order_Detail ord = new Order_Detail();
		try {
			while (rs.next()) {

				ord.setorder_id(rs.getInt("ORDERS_ID"));
				ord.setproduct_id(rs.getInt("PRODUCT_ID"));
				ord.setnum_of_system_installed(rs.getInt("NUM_OF_SYSTEM_INSTALLED"));
				ord.setPrice(rs.getInt("PRICE"));
				ord.setwarranty_period(rs.getInt("WARRANTY_PERIOD"));
				ord.setwarranty_expire_date(rs.getString("WARRANTY_EXPIRE_DATE"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.OrderDetailDAO ordsDao = new OrderDetailDAO();

				int num_of_system_installed = Integer.parseInt(txtNums.getText());

				int price = Integer.parseInt(txtPrice.getText());
				int period = 0;
				if (cbWarrantyPeriod.getSelectedItem().equals("1 Year")) {
					period = 1;
				} else if (cbWarrantyPeriod.getSelectedItem().equals("2 Years")) {
					period = 2;
				} else {
					period = 3;
				}
				String warranty_expire_date = txtDateExp.getText();
				try {
					ordsDao.editOrder_Detail(ord.getorder_id(), ord.getproduct_id(), num_of_system_installed, price,
							period, warranty_expire_date);
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
		button.setBounds(182, 300, 89, 23);
		getContentPane().add(button);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(281, 300, 89, 23);
		getContentPane().add(btnCancel);

		txtOrderId = new JTextField();
		txtOrderId.setEditable(false);
		txtOrderId.setBounds(163, 49, 207, 20);
		getContentPane().add(txtOrderId);
		txtOrderId.setColumns(10);
		txtOrderId.setText(String.valueOf(ord.getorder_id()));

		//
		DAO.ProductElevationDAO proDao = new ProductElevationDAO();
		String pName;
		pName = proDao.findbyIdReturnName(ord.getproduct_id(), "sp_findName_Product_by_id");
		//
		txtProductName = new JTextField();
		txtProductName.setEditable(false);
		txtProductName.setBounds(163, 83, 207, 20);
		getContentPane().add(txtProductName);
		txtProductName.setColumns(10);
		txtProductName.setText(pName);

		//
		txtNums = new JTextField();
		txtNums.setBounds(163, 120, 207, 20);
		getContentPane().add(txtNums);
		txtNums.setColumns(10);
		txtNums.setText(String.valueOf(ord.getnum_of_system_installed()));

		txtPrice = new JTextField();
		txtPrice.setBounds(163, 162, 207, 20);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		txtPrice.setText(String.valueOf(ord.getPrice()));

		cbWarrantyPeriod.setBounds(163, 196, 104, 20);
		getContentPane().add(cbWarrantyPeriod);
		cbWarrantyPeriod.addItem("1 Year");
		cbWarrantyPeriod.addItem("2 Years");
		cbWarrantyPeriod.addItem("3 Years");

		if (ord.getwarranty_expire_date().equals("1")) {
			cbWarrantyPeriod.setSelectedIndex(0);
		} else if (ord.getwarranty_expire_date().equals("2")) {
			cbWarrantyPeriod.setSelectedIndex(1);
		} else {
			cbWarrantyPeriod.setSelectedIndex(2);
		}
		txtDateExp = new JTextField();
		txtDateExp.setBounds(163, 238, 104, 20);
		getContentPane().add(txtDateExp);
		txtDateExp.setColumns(10);

		JButton btnGetdate = new JButton("GetDate");
		btnGetdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl = new Calendar(txtDateExp);
				cl.setVisible(true);
			}
		});
		btnGetdate.setBounds(281, 237, 89, 23);
		getContentPane().add(btnGetdate);
	}
}
