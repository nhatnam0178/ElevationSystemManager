package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddNewOrderDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textNum_Of_Sys;
	private JTextField textPrice;
	private JTextField textWarrantyPeriod;
	private JTextField textWarrantyExp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewOrderDetail frame = new AddNewOrderDetail();
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
	public AddNewOrderDetail() {
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
		
		JLabel lblID = new JLabel("");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(290, 11, 46, 21);
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
		
		textWarrantyPeriod = new JTextField();
		textWarrantyPeriod.setBounds(146, 161, 200, 20);
		contentPane.add(textWarrantyPeriod);
		textWarrantyPeriod.setColumns(10);
		
		textWarrantyExp = new JTextField();
		textWarrantyExp.setBounds(146, 201, 200, 20);
		contentPane.add(textWarrantyExp);
		textWarrantyExp.setColumns(10);
		
		JLabel lblWarrantyexp = new JLabel("Warranty_EXP:");
		lblWarrantyexp.setBounds(10, 204, 111, 14);
		contentPane.add(lblWarrantyexp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(261, 264, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(163, 264, 89, 23);
		contentPane.add(btnOk);
		
		JComboBox comboBoxProductID = new JComboBox();
		comboBoxProductID.setBounds(146, 48, 200, 20);
		contentPane.add(comboBoxProductID);
	}
}
