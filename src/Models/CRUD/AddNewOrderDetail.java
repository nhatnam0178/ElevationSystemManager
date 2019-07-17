package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import MainForm.SystemForm;
import entities.Account;
import entities.Accounts;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddNewOrderDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textNum_Of_Sys;
	private JTextField textPrice;
	private JTextField textWarrantyExp;
	private JComboBox comboBoxProductID;
	private JComboBox comboBoxWarrantyPeriod;
	static int idPut;
	entities.Accounts accs = new Accounts();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewOrderDetail frame = new AddNewOrderDetail(idPut);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNewOrderDetail(int idPut) {
		setTitle("ADD NEW ORDER DETAIL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				String strQuery = "SELECT * FROM ACCOUNT";
				//
				ResultSet rs = ConnectionSQL.Query(strQuery);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Account item : accs) {
					comboBoxProductID.addItem(item.getname());
				}
				int product_id = 0;
				for (Account it : accs) {
					if (comboBoxProductID.getSelectedItem().equals(it.getname())) {
						product_id = it.getId();
					}
				}
				// Num of System Installed
				int num_of_system_installed = Integer.parseInt(textNum_Of_Sys.getText());
				// Price
				double price = Double.parseDouble(textPrice.getText());
				// WarrantyPeriod
				String[] str1 = { "1 Year", "2 Years", "3 Years" };
				int warranty_period = 0;
				for (int i = 0; i < str1.length; i++) {
					if (comboBoxWarrantyPeriod.getSelectedItem().equals(str1[i])) {
						warranty_period = i + 1;
					}
				}
				// WarrantyDate
				String warranty_expire_date = String.valueOf(textWarrantyExp);
				orDeDAO.insertOrderDetail(idPut, product_id, num_of_system_installed, price, warranty_period,
						warranty_expire_date);
				
				dispose();
			}
		});
		btnOk.setBounds(163, 264, 89, 23);
		contentPane.add(btnOk);

		JComboBox comboBoxProductID = new JComboBox();
		comboBoxProductID.setBounds(146, 48, 200, 20);
		// loadList Product

		contentPane.add(comboBoxProductID);
		String[] str1 = { "1 Year", "2 Years", "3 Years" };
		JComboBox comboBoxWarrantyPeriod = new JComboBox();
		comboBoxWarrantyPeriod.addItem(str1);
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
