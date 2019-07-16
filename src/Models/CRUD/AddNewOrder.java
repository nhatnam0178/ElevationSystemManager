package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textTotalPrice;
	private JTextField textDateOrder;
	private JTextField textDateInstall;
	private JTextField textDateComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewOrder frame = new AddNewOrder();
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
	public AddNewOrder() {
		setTitle("ADD NEW ORDER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputNewOrder = new JLabel("INPUT NEW ORDER");
		lblInputNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewOrder.setBounds(113, 11, 181, 19);
		contentPane.add(lblInputNewOrder);
		
		JLabel lblNewLabel = new JLabel("Client_Name:");
		lblNewLabel.setBounds(10, 45, 99, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxClient = new JComboBox();
		comboBoxClient.setBounds(140, 42, 181, 20);
		contentPane.add(comboBoxClient);
		
		JLabel lblAccountid = new JLabel("Account_ID:");
		lblAccountid.setBounds(10, 83, 99, 14);
		contentPane.add(lblAccountid);
		
		JComboBox comboAccountID = new JComboBox();
		comboAccountID.setBounds(140, 80, 181, 20);
		contentPane.add(comboAccountID);
		
		JLabel lblTotalprice = new JLabel("Total_Price:");
		lblTotalprice.setBounds(10, 121, 99, 14);
		contentPane.add(lblTotalprice);
		
		textTotalPrice = new JTextField();
		textTotalPrice.setBounds(140, 118, 181, 20);
		contentPane.add(textTotalPrice);
		textTotalPrice.setColumns(10);
		
		JLabel lblDateorder = new JLabel("Date_Order (y/M/dd):");
		lblDateorder.setBounds(10, 160, 123, 14);
		contentPane.add(lblDateorder);
		
		textDateOrder = new JTextField();
		textDateOrder.setBounds(140, 157, 181, 20);
		contentPane.add(textDateOrder);
		textDateOrder.setColumns(10);
		
		JLabel lblDateinstalled = new JLabel("Date_Installed:");
		lblDateinstalled.setBounds(10, 197, 99, 14);
		contentPane.add(lblDateinstalled);
		
		textDateInstall = new JTextField();
		textDateInstall.setBounds(140, 194, 181, 20);
		contentPane.add(textDateInstall);
		textDateInstall.setColumns(10);
		
		JLabel lblDatecomplete = new JLabel("Date_Complete:");
		lblDatecomplete.setBounds(10, 234, 99, 14);
		contentPane.add(lblDatecomplete);
		
		textDateComplete = new JTextField();
		textDateComplete.setBounds(140, 231, 181, 20);
		contentPane.add(textDateComplete);
		textDateComplete.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 275, 46, 14);
		contentPane.add(lblStatus);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(140, 272, 181, 20);
		contentPane.add(comboBoxStatus);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(237, 328, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(138, 328, 89, 23);
		contentPane.add(btnOk);
	}

}
