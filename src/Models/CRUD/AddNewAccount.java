package Models.CRUD;

import javax.swing.JPanel;

import DAO.AccountDAO;
import MainForm.SystemForm;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

public class AddNewAccount extends JDialog {

	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private MyComboBox cbGender = new MyComboBox();
	private MyComboRole cbRole = new MyComboRole();
	private MyComboDepart cbDepartment = new MyComboDepart();
	private JTextField txtEmail;

//	/**
//	 * Create the frame.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddNewAccount frame = new AddNewAccount();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public AddNewAccount(JFrame root) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 150, 363, 451);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelGird = new JPanel();
		panelGird.setBounds(0, 0, 347, 412);
		getContentPane().add(panelGird);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(174, 378, 71, 23);
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
					AccountDAO ad = new AccountDAO();
					ad.insertAccount(username, password, name, gender, email, phone, address, role_id, department_id);

					dispose();
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(255, 378, 84, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		MyComboBox cbGender_1 = new MyComboBox();
		cbGender_1.setBounds(100, 159, 223, 20);

		JLabel lblNewLabel_3 = new JLabel("Address: ");
		lblNewLabel_3.setBounds(23, 248, 64, 14);

		JLabel lblName_1 = new JLabel("Name: ");
		lblName_1.setBounds(23, 131, 46, 14);

		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setBounds(23, 100, 64, 14);

		txtAddress = new JTextField();
		txtAddress.setBounds(100, 245, 223, 20);
		txtAddress.setColumns(10);

		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(23, 273, 64, 20);

		JLabel lblNewLabel_4 = new JLabel("Department: ");
		lblNewLabel_4.setBounds(23, 307, 78, 14);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(23, 193, 46, 14);

		JLabel lblNewLabel_2 = new JLabel("Phone: ");
		lblNewLabel_2.setBounds(23, 218, 46, 14);

		MyComboDepart cbDepartment_1 = new MyComboDepart();
		cbDepartment_1.setBounds(100, 304, 223, 20);

		txtEmail = new JTextField();
		txtEmail.setBounds(100, 190, 223, 20);
		txtEmail.setColumns(10);

		JLabel lblName = new JLabel("Username:");
		lblName.setBounds(23, 69, 64, 14);

		txtPassword = new JTextField();
		txtPassword.setBounds(100, 97, 223, 20);
		txtPassword.setColumns(10);

		MyComboRole cbRole_1 = new MyComboRole();
		cbRole_1.setBounds(100, 276, 223, 20);

		txtUsername = new JTextField();
		txtUsername.setBounds(100, 66, 223, 20);
		txtUsername.setColumns(10);
		JLabel lblInputNewInfo = new JLabel("INPUT NEW INFO ACCOUNT");
		lblInputNewInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInputNewInfo.setBounds(81, 11, 242, 40);

		txtPhone = new JTextField();
		txtPhone.setBounds(100, 215, 223, 20);
		txtPhone.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(100, 128, 223, 20);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Gender: ");
		lblNewLabel_1.setBounds(23, 162, 56, 14);
		panelGird.setLayout(null);
		panelGird.add(cbGender_1);
		panelGird.add(btnCancel);
		panelGird.add(lblNewLabel_3);
		panelGird.add(lblName_1);
		panelGird.add(lblNewLabel);
		panelGird.add(txtAddress);
		panelGird.add(lblRole);
		panelGird.add(lblNewLabel_4);
		panelGird.add(lblEmail);
		panelGird.add(lblNewLabel_2);
		panelGird.add(cbDepartment_1);
		panelGird.add(txtEmail);
		panelGird.add(btnOk);
		panelGird.add(lblName);
		panelGird.add(txtPassword);
		panelGird.add(cbRole_1);
		panelGird.add(txtUsername);
		panelGird.add(lblInputNewInfo);
		panelGird.add(txtPhone);
		panelGird.add(txtName);
		panelGird.add(lblNewLabel_1);
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
