package Models.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import DAO.ProductElevationDAO;
import entities.Order_Detail;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OrderDetail extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	static int idGet;

	public static void main(String[] args) {
		try {
			OrderDetail dialog = new OrderDetail(idGet);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param idGet
	 */
	public OrderDetail(int idGet) {
		setTitle("Order Detail");
		setBounds(100, 100, 519, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Order_ID: ");
		lblNewLabel.setBounds(10, 57, 108, 21);
		contentPanel.add(lblNewLabel);

		JLabel lblOrderDetail = new JLabel("Order Detail");
		lblOrderDetail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblOrderDetail.setBounds(205, 11, 206, 30);
		contentPanel.add(lblOrderDetail);

		JLabel lblNewLabel_1 = new JLabel("Product_Name:");
		lblNewLabel_1.setBounds(10, 89, 93, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Num_Of_System_Installed:");
		lblNewLabel_2.setBounds(10, 114, 160, 21);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Price:");
		lblNewLabel_3.setBounds(10, 146, 65, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblWarrantyperriod = new JLabel("Warranty_Perriod:");
		lblWarrantyperriod.setBounds(10, 171, 132, 14);
		contentPanel.add(lblWarrantyperriod);

		JLabel lblWarrantyexpired = new JLabel("Warranty_Expire_Date:");
		lblWarrantyexpired.setBounds(10, 196, 147, 21);
		contentPanel.add(lblWarrantyexpired);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnOk.setBounds(205, 298, 89, 23);
		contentPanel.add(btnOk);

//GET DATA FROM DB by Resulset
		DAO.OrderDetailDAO orDao = new OrderDetailDAO();
		ResultSet rs = orDao.findbyId(idGet);
		entities.Order_Detail ord = new Order_Detail();
		try {
			while (rs.next()) {

				ord.setorder_id(rs.getInt("ORDERS_ID"));
				ord.setproduct_id(rs.getInt("PRODUCT_ID"));
				ord.setnum_of_system_installed(rs.getInt("NUM_OF_SYSTEM_INSTALLED"));
				ord.setprice(rs.getDouble("PRICE"));
				ord.setwarranty_period(rs.getInt("WARRANTY_PERIOD"));
				ord.setwarranty_expire_date(rs.getString("WARRANTY_EXPIRE_DATE"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lbVariableOrderID = new JLabel();
		lbVariableOrderID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbVariableOrderID.setBounds(186, 55, 307, 21);
		lbVariableOrderID.setText(String.valueOf(ord.getorder_id()));
		contentPanel.add(lbVariableOrderID);

		DAO.ProductElevationDAO proDao = new ProductElevationDAO();
		String pName;
		pName = proDao.findbyIdReturnName(ord.getproduct_id(), "sp_findName_Product_by_id");

		JLabel lbProductName = new JLabel();
		lbProductName.setText(pName);
		lbProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbProductName.setBounds(186, 82, 307, 21);
		contentPanel.add(lbProductName);

		JLabel lbNumber = new JLabel();
		lbNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNumber.setBounds(186, 112, 307, 21);
		lbNumber.setText(String.valueOf(ord.getnum_of_system_installed()));
		contentPanel.add(lbNumber);

		JLabel lbPrice = new JLabel();
		lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPrice.setBounds(186, 141, 307, 21);
		lbPrice.setText(String.valueOf(ord.getprice()));
		contentPanel.add(lbPrice);

		JLabel lbWarrantyPeriod = new JLabel();
		lbWarrantyPeriod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbWarrantyPeriod.setText(String.valueOf(ord.getwarranty_period()));
		lbWarrantyPeriod.setBounds(186, 166, 307, 21);

		contentPanel.add(lbWarrantyPeriod);

		JLabel lbWarrantyEx = new JLabel();
		lbWarrantyEx.setText(ord.getwarranty_expire_date().toString());
		lbWarrantyEx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbWarrantyEx.setBounds(186, 194, 307, 21);
		contentPanel.add(lbWarrantyEx);
	}
}
