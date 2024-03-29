package Models.CRUD;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import entities.Product_Elevation;
import entities.Product_Elevations;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class AddNewOrderDetail extends JDialog {

	private JPanel contentPane;
	private JTextField textNum_Of_Sys;
	private JTextField textPrice;
	private JTextField textWarrantyExp;
	private JComboBox comboBoxProductID = new JComboBox();;
	private JComboBox comboBoxWarrantyPeriod = new JComboBox();;
	static int idPut;
	entities.Product_Elevations pros = new Product_Elevations();

	/**
	 * Create the frame.
	 */
	public AddNewOrderDetail(int idPut) {
		setTitle("ADD NEW ORDER DETAIL");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 376, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewOrder = new JLabel("INPUT NEW ORDER DETAIL - ID : ");
		lblInputNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewOrder.setBounds(59, 11, 234, 25);
		contentPane.add(lblInputNewOrder);

		JLabel lblID = new JLabel();
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(300, 11, 46, 25);
		lblID.setText(String.valueOf(idPut));
		contentPane.add(lblID);

		JLabel lblProductid = new JLabel("PRODUCT_ID:");
		lblProductid.setBounds(10, 51, 111, 14);
		contentPane.add(lblProductid);

		JLabel lblQuantityproduct = new JLabel("Quantity_Product:");
		lblQuantityproduct.setBounds(10, 87, 111, 14);
		contentPane.add(lblQuantityproduct);

		textNum_Of_Sys = new JTextField();
		textNum_Of_Sys.setBounds(146, 84, 200, 20);
		contentPane.add(textNum_Of_Sys);
		textNum_Of_Sys.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 126, 46, 14);
		contentPane.add(lblPrice);

		textPrice = new JTextField();
		textPrice.setBounds(146, 123, 200, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);

		JLabel lblWarrantyperiod = new JLabel("Warranty_Period:");
		lblWarrantyperiod.setBounds(10, 164, 98, 14);
		contentPane.add(lblWarrantyperiod);

		textWarrantyExp = new JTextField();
		textWarrantyExp.setBounds(146, 201, 147, 20);
		contentPane.add(textWarrantyExp);
		textWarrantyExp.setColumns(10);

		JLabel lblWarrantyexp = new JLabel("Warranty_EXP:");
		lblWarrantyexp.setBounds(10, 204, 111, 14);
		contentPane.add(lblWarrantyexp);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(261, 264, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.OrderDetailDAO orDeDAO = new OrderDetailDAO();
				// PRODUCT
				String strQuery = "SELECT * FROM PRODUCT_ELEVATION";
				//
				ResultSet rs = ConnectionSQL.Query(strQuery);
				try {
					while (rs.next()) {
						entities.Product_Elevation prodItem = new entities.Product_Elevation();
						prodItem.setId(rs.getInt("ID"));
						prodItem.setname(rs.getString("NAME"));
						prodItem.setPrice(rs.getInt("PRICE"));
						pros.add(prodItem);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int product_id = 1;
				for (Product_Elevation item : pros) {
					if (comboBoxProductID.getSelectedItem().equals(item.getname())) {
						product_id = item.getId();
					}
				}
				// Num of System Installed
				int num_of_system_installed = Integer.parseInt(textNum_Of_Sys.getText());
				// Price
				int price = Integer.parseInt(textPrice.getText());
				// WarrantyPeriod
				String[] str1 = { "1 Year", "2 Years", "3 Years" };
				int warranty_period = 0;
				for (int i = 0; i < str1.length; i++) {
					if (comboBoxWarrantyPeriod.getSelectedItem().equals(str1[i])) {
						warranty_period = i + 1;
					}
				}
				// WarrantyDate
				orDeDAO.insertOrderDetail(idPut, product_id, num_of_system_installed, price, warranty_period,
						String.valueOf(textWarrantyExp.getText()));

				dispose();
			}
		});
		btnOk.setBounds(163, 264, 89, 23);
		contentPane.add(btnOk);
		comboBoxProductID.setBounds(146, 48, 200, 20);
		contentPane.add(comboBoxProductID);
		// loadList Product
		// PRODUCT
		String strQuery = "SELECT * FROM PRODUCT_ELEVATION";
		//
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Product_Elevation prodItem = new entities.Product_Elevation();
				prodItem.setId(rs.getInt("ID"));
				prodItem.setname(rs.getString("NAME"));
				prodItem.setPrice(rs.getInt("PRICE"));
				pros.add(prodItem);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Product_Elevation it : pros) {
			comboBoxProductID.addItem(it.getname());
		}
		String[] str1 = { "1 Year", "2 Years", "3 Years" };

		for (String st : str1) {
			comboBoxWarrantyPeriod.addItem(st);
		}
		comboBoxWarrantyPeriod.setBounds(146, 161, 98, 20);
		contentPane.add(comboBoxWarrantyPeriod);

		JButton buttonGetDate = new JButton("...");
		buttonGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar cl = new Calendar(textWarrantyExp);
				cl.setVisible(true);
			}
		});
		buttonGetDate.setBounds(303, 200, 43, 23);
		contentPane.add(buttonGetDate);
	}
}