package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ClientDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtCompany;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewClient frame = new AddNewClient();
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
	public AddNewClient() {
		setTitle("ADD NEW CLIENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewClient = new JLabel("INPUT NEW CLIENT");
		lblInputNewClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewClient.setBounds(99, 11, 169, 19);
		contentPane.add(lblInputNewClient);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(10, 51, 94, 14);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(120, 48, 224, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Phone:");
		lblNewLabel_1.setBounds(10, 91, 52, 14);
		contentPane.add(lblNewLabel_1);

		txtPhone = new JTextField();
		txtPhone.setBounds(120, 88, 224, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(10, 133, 58, 14);
		contentPane.add(lblNewLabel_2);

		txtAddress = new JTextField();
		txtAddress.setBounds(120, 130, 224, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel lblCompanyname = new JLabel("Company_Name:");
		lblCompanyname.setBounds(10, 170, 111, 14);
		contentPane.add(lblCompanyname);

		txtCompany = new JTextField();
		txtCompany.setBounds(120, 167, 224, 20);
		contentPane.add(txtCompany);
		txtCompany.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String address = txtAddress.getText();
				String companyName = txtCompany.getText();

				try {
					DAO.ClientDAO cliDao = new ClientDAO();
					cliDao.insertClient(name, phone, address, companyName);
					setVisible(false);

				} catch (Exception e2) {
					System.out.println(e2.getStackTrace());
				}
			}
		});
		btnOk.setBounds(156, 228, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(255, 228, 89, 23);
		contentPane.add(btnCancel);
	}

}
