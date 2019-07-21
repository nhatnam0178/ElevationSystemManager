package Models.CRUD;

import javax.swing.JButton;
import javax.swing.JDialog;

import DAO.ProductElevationDAO;
import MainForm.SystemForm;
import Models.Views.AccountView;
import Models.Views.ProductView;
import entities.Product_Elevation;
import entities.Product_Elevations;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EditProduct extends JDialog {
	static int idEdit;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtPrice;
	private JTextField txtDateOrder;
	private JTextField txtWarrantyEXP;
	private JComboBox comboBoxWarranty = new JComboBox();;

	/**
	 * Create the dialog.
	 */
	public EditProduct(int idEdit) {
		setTitle("EDIT PRODUCT");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 373, 377);
		getContentPane().setLayout(null); 

		JLabel lblEditProduct = new JLabel("EDIT PRODUCT");
		lblEditProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditProduct.setBounds(159, 11, 138, 19);
		getContentPane().add(lblEditProduct);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(10, 48, 77, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(10, 85, 77, 14);
		getContentPane().add(lblType);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 123, 77, 14);
		getContentPane().add(lblPrice);

		JLabel lblDateorder = new JLabel("Date_Order:");
		lblDateorder.setBounds(10, 165, 77, 14);
		getContentPane().add(lblDateorder);

		JLabel lblWarranty = new JLabel("Warranty:");
		lblWarranty.setBounds(10, 204, 77, 14);
		getContentPane().add(lblWarranty);

		JLabel lblWarrantyExp = new JLabel("Warranty EXP:");
		lblWarrantyExp.setBounds(10, 248, 91, 14);
		getContentPane().add(lblWarrantyExp);
		//
		txtName = new JTextField();
		txtName.setBounds(97, 45, 235, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtType = new JTextField();
		txtType.setBounds(97, 82, 235, 20);
		getContentPane().add(txtType);
		txtType.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(97, 120, 235, 20);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);

		txtDateOrder = new JTextField();
		txtDateOrder.setBounds(97, 162, 136, 20);
		getContentPane().add(txtDateOrder);
		txtDateOrder.setColumns(10);

		txtWarrantyEXP = new JTextField();
		txtWarrantyEXP.setBounds(97, 245, 136, 20);
		getContentPane().add(txtWarrantyEXP);
		txtWarrantyEXP.setColumns(10);
		// Load Data

		ProductElevationDAO proDao = new ProductElevationDAO();

		ResultSet rs = proDao.findbyId(idEdit);
		try {
			while (rs.next()) {
				entities.Product_Elevation item = new Product_Elevation();
				item.setId(rs.getInt("ID"));
				item.setname(rs.getString("NAME"));
				item.settype(rs.getString("TYPE"));
				item.setprice(rs.getDouble("PRICE"));
				item.setdate_of_order(rs.getString("DATE_OF_ORDER"));
				item.setwarranty(rs.getInt("WARRANTY"));
				item.setwarranty_expire_date(rs.getString("WARRANTY_EXPIRE_DATE"));
// 
				txtName.setText(item.getname());
				txtType.setText(item.gettype());
				txtPrice.setText(String.valueOf(item.getprice()));
				txtDateOrder.setText(item.getdate_of_order());
				txtWarrantyEXP.setText(item.getwarranty_expire_date());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(258, 305, 89, 23);
		getContentPane().add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAO.ProductElevationDAO proDao = new ProductElevationDAO();

				try {
					int warranty;
					if (comboBoxWarranty.getSelectedIndex() == 0) {
						warranty = 1;
					} else if (comboBoxWarranty.getSelectedIndex() == 1) {
						warranty = 2;
					} else {
						warranty = 3;
					}
					String name = txtName.getText();
					String type = txtType.getText();
					proDao.editProductElevation(idEdit, name, type, Double.parseDouble(txtPrice.getText()),
							String.valueOf(txtDateOrder.getText()), warranty, String.valueOf(txtWarrantyEXP.getText()));
					ProductView pvw = new ProductView();
					pvw.setVisible(true);
					SystemForm.myTables[2].removeAll();
					SystemForm.myTables[2].validate();
					SystemForm.myTables[2].repaint();
					SystemForm.myTables[2].add(new ProductView());
					SystemForm.myTables[2].validate();
					SystemForm.myTables[2].repaint();
					dispose();
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

			}
		});
		btnOk.setBounds(159, 305, 89, 23);
		getContentPane().add(btnOk);

		JButton btnGetdateOrder = new JButton("GetDate");
		btnGetdateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl = new Calendar(txtDateOrder);
				cl.setVisible(true);
			}
		});
		btnGetdateOrder.setBounds(243, 161, 89, 23);
		getContentPane().add(btnGetdateOrder);

		comboBoxWarranty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxWarranty.addItem("1 Year");
		comboBoxWarranty.addItem("2 Years");
		comboBoxWarranty.addItem("3 Years");
		comboBoxWarranty.setBounds(97, 200, 82, 20);
		getContentPane().add(comboBoxWarranty);

		JButton btnGetdateWarrantyEXP = new JButton("GetDate");
		btnGetdateWarrantyEXP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl = new Calendar(txtWarrantyEXP);
				cl.setVisible(true);
			}
		});
		btnGetdateWarrantyEXP.setBounds(243, 244, 89, 23);
		getContentPane().add(btnGetdateWarrantyEXP);
	}
}
