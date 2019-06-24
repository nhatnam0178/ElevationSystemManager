package MainForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewAccount frame = new AddNewAccount();
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
	public AddNewAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewInfo = new JLabel("INPUT NEW INFO ACCOUNT");
		lblInputNewInfo.setBounds(108, 11, 147, 14);
		contentPane.add(lblInputNewInfo);

		JLabel lblName = new JLabel("Username:");
		lblName.setBounds(10, 40, 67, 14);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setBounds(10, 72, 67, 14);
		contentPane.add(lblNewLabel);

		JLabel lblName_1 = new JLabel("Name: ");
		lblName_1.setBounds(10, 106, 46, 14);
		contentPane.add(lblName_1);

		JLabel lblNewLabel_1 = new JLabel("Gender: ");
		lblNewLabel_1.setBounds(10, 145, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone: ");
		lblNewLabel_2.setBounds(10, 183, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Address: ");
		lblNewLabel_3.setBounds(10, 219, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(10, 255, 46, 14);
		contentPane.add(lblRole);

		JLabel lblNewLabel_4 = new JLabel("Department: ");
		lblNewLabel_4.setBounds(10, 292, 67, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(208, 343, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(59, 343, 89, 23);
		contentPane.add(btnOk);

		txtUsername = new JTextField();
		txtUsername.setBounds(87, 36, 232, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(87, 69, 232, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(87, 103, 232, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(87, 180, 231, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(87, 216, 231, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JComboBox cbRole = new JComboBox();
		cbRole.setBounds(87, 252, 147, 20);
		contentPane.add(cbRole);

		JComboBox cbDepartment = new JComboBox();
		cbDepartment.setBounds(87, 289, 147, 20);
		contentPane.add(cbDepartment);

		JComboBox cbGender = new JComboBox();
		cbGender.setBounds(87, 142, 147, 20);
		contentPane.add(cbGender);
	}
}
