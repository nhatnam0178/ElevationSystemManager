package MainForm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AccountDAO;
import entities.Account;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private MyComboBox cbGender = new MyComboBox();
	private MyComboRole cbRole = new MyComboRole();
	private MyComboDepart cbDepartment = new MyComboDepart();
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccount frame = new EditAccount();
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
	public EditAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
	
		
		JLabel lblInputNewInfo = new JLabel("EDIT ACCOUNT");
		lblInputNewInfo.setBounds(108, 11, 171, 14);
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
		lblRole.setBounds(10, 290, 46, 14);
		contentPane.add(lblRole);

		JLabel lblNewLabel_4 = new JLabel("Department: ");
		lblNewLabel_4.setBounds(10, 327, 67, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(230, 387, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtName.getText();
				String password = txtPassword.getText();
				String name = txtName.getText();
				boolean gender = false;
				String obj = (String) cbGender.getSelectedItem();
				if (obj == "Male") {
					gender = true;
				}
				String phone = txtPhone.getText();
				String address = txtAddress.getText();
				String email = txtEmail.getText();
				int role_id = 2;
				String obj1 = (String) cbRole.getSelectedItem();
				if (obj1 == "Admin") {
					role_id = 1;
				}
				int department_id = 0;
				if (cbDepartment.equals("Services")) {
					department_id = 1;
				} else if (cbDepartment.equals("Complain")) {
					department_id = 2;
				} else {
					department_id = 3;
				}
				try {
					AccountDAO acc = new AccountDAO();
					acc.insertAccount(username, password, name, gender, email, phone, address, role_id, department_id);
					dispose();
				} catch (Exception e) {
					SystemForm.myArea.append(e.toString());
				}

			}
		});
		btnOk.setBounds(131, 387, 89, 23);
		contentPane.add(btnOk);

		txtUsername = new JTextField();
		txtUsername.setEditable(false);
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

		MyComboRole cbRole = new MyComboRole();
		cbRole.setBounds(87, 287, 147, 20);
		contentPane.add(cbRole);

		MyComboDepart cbDepartment = new MyComboDepart();
		cbDepartment.setBounds(87, 324, 147, 20);
		contentPane.add(cbDepartment);

		MyComboBox cbGender = new MyComboBox();
		cbGender.setBounds(87, 142, 147, 20);
		contentPane.add(cbGender);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 255, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(87, 252, 232, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}

	public EditAccount(int idSend) {
		// TODO Auto-generated constructor stub
	}
}

class MyComboBox extends JComboBox {
	public MyComboBox() {
		addItem("Male");
		addItem("Female");
	}
}

class MyComboDepart extends JComboBox {
	public MyComboDepart() {
		addItem("Services");
		addItem("Complain");
		addItem("Other");
	}
}

class MyComboRole extends JComboBox {
	public MyComboRole() {
		addItem("Admin");
		addItem("Employee");
	}
}
