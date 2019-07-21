package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ProductElevationDAO;
import MainForm.SystemForm;
import Models.Views.AccountView;
import Models.Views.ProductView;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class AddNewProduct extends JDialog {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textType;
	private JTextField textPrice;
	private JComboBox comboBoxWarranty = new JComboBox();
	private JTextField textFieldDate;
	private JTextField textFieldDateExp;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddNewProduct frame = new AddNewProduct();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddNewProduct(JFrame root) {
		setTitle("ADD NEW PRODUCT");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 355, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewProduct = new JLabel("INPUT NEW PRODUCT");
		lblInputNewProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewProduct.setBounds(117, 11, 153, 26);
		contentPane.add(lblInputNewProduct);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 53, 82, 14);
		contentPane.add(lblNewLabel);

		textName = new JTextField();
		textName.setBounds(89, 50, 232, 20);
		contentPane.add(textName);
		textName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setBounds(10, 94, 46, 14);
		contentPane.add(lblNewLabel_1);

		textType = new JTextField();
		textType.setBounds(89, 91, 232, 20);
		contentPane.add(textType);
		textType.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 137, 46, 14);
		contentPane.add(lblPrice);

		textPrice = new JTextField();
		textPrice.setBounds(89, 134, 232, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);

		JLabel lblDateorder = new JLabel("Date_Order:");
		lblDateorder.setBounds(10, 176, 66, 14);
		contentPane.add(lblDateorder);

		JLabel lblWarranty = new JLabel("Warranty (y):");
		lblWarranty.setBounds(10, 217, 82, 14);
		contentPane.add(lblWarranty);

		JLabel lblWarrantyExp = new JLabel("Warranty EXP:");
		lblWarrantyExp.setBounds(10, 260, 82, 14);
		contentPane.add(lblWarrantyExp);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAO.ProductElevationDAO proDao = new ProductElevationDAO();
				String name = textName.getText();
				String type = textType.getText();
				double price = Double.parseDouble(textPrice.getText());
				int warranty;
				if (comboBoxWarranty.getSelectedIndex() == 0) {
					warranty = 1;
				} else if (comboBoxWarranty.getSelectedIndex() == 1) {
					warranty = 2;
				} else {
					warranty = 3;
				}
				try {
					proDao.insertProductElevation(name, type, price, String.valueOf(textFieldDate.getText()), warranty,
							String.valueOf(textFieldDateExp.getText()));
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
					e.getStackTrace();
				}
			}
		});

		btnOk.setBounds(133, 314, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(232, 314, 89, 23);
		contentPane.add(btnCancel);

		comboBoxWarranty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxWarranty.addItem("1 Year");
		comboBoxWarranty.addItem("2 Years");
		comboBoxWarranty.addItem("3 Years");
		comboBoxWarranty.setBounds(89, 214, 82, 20);
		contentPane.add(comboBoxWarranty);

		JButton btnGetDate = new JButton("Get Date");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar cl = new Calendar(textFieldDate);
				cl.setVisible(true);
			}
		});
		btnGetDate.setBounds(246, 172, 75, 23);
		contentPane.add(btnGetDate);

		JButton btnGetDateExp = new JButton("Get Date");
		btnGetDateExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar cl1 = new Calendar(textFieldDateExp);
				cl1.setVisible(true);
			}
		});
		btnGetDateExp.setBounds(246, 256, 75, 23);
		contentPane.add(btnGetDateExp);

		textFieldDate = new JTextField();
		textFieldDate.setBounds(89, 173, 153, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);

		textFieldDateExp = new JTextField();
		textFieldDateExp.setBounds(89, 257, 153, 20);
		contentPane.add(textFieldDateExp);
		textFieldDateExp.setColumns(10);
	}
}
