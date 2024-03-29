package Models.CRUD;

import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.AccountDAO;
import MainForm.SystemForm;
import Models.Views.AccountView;

public class EditAccount extends JDialog {
	public static int roleId;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private MyComboBoxs cbGender = new MyComboBoxs();
	private MyComboRoles cbRole = new MyComboRoles();
	private MyComboDeparts cbDepartment = new MyComboDeparts();
	private JTextField txtEmail;
	static int idEdit;

	/**
	 * Create the frame.
	 * 
	 * @param idEdit
	 */
	public EditAccount(int idEdit) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 344, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
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

		MyComboRoles cbRole = new MyComboRoles();
		cbRole.setEditable(false);
		cbRole.setBounds(87, 287, 147, 20);

		contentPane.add(cbRole);

		MyComboDeparts cbDepartment = new MyComboDeparts();
		cbDepartment.setBounds(87, 324, 147, 20);
		cbDepartment.setEditable(true);

		contentPane.add(cbDepartment);

		MyComboBoxs cbGender = new MyComboBoxs();
		cbGender.setBounds(87, 142, 147, 20);
		contentPane.add(cbGender);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 255, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(87, 252, 232, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		//
		AccountDAO accDao = new AccountDAO();
		ResultSet rs = accDao.findbyId(idEdit);

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

				txtUsername.setText(accItem.getusername());
				txtPassword.setText(accItem.getpassword());
				txtName.setText(accItem.getname());
				txtPhone.setText(accItem.getphone());

				txtEmail.setText(accItem.getemail());
				txtAddress.setText(accItem.getaddress());
				if (accItem.getgender() == true) {
					cbGender.setSelectedItem("Male");
				} else {
					cbGender.setSelectedItem("Female");
				}
				if (accItem.getrole_id() == 1) {
					cbRole.setSelectedIndex(0);
				} else {
					cbRole.setSelectedIndex(1);
				}
				if (accItem.getdepartment_id() == 1) {
					cbDepartment.setSelectedIndex(0);
				} else {
					cbDepartment.setSelectedIndex(1);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				setVisible(false);
			}
		});
		btnCancel.setBounds(230, 387, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
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
				if (cbDepartment.equals("Order")) {
					department_id = 1;
				} else if (cbDepartment.equals("Services")) {
					department_id = 2;
				} else {
					department_id = 3;
				}
				try {
					AccountDAO acc = new AccountDAO();
					acc.editAccount(password, name, gender, email, phone, address, role_id, department_id,
							String.valueOf(idEdit), username);
					AccountView act = new AccountView();
					act.setVisible(true);
					SystemForm.myTables[0].removeAll();
					SystemForm.myTables[0].validate();
					SystemForm.myTables[0].repaint();
					SystemForm.myTables[0].add(new AccountView());
					SystemForm.myTables[0].validate();
					SystemForm.myTables[0].repaint();
					dispose();
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

			}
		});
		btnOk.setBounds(131, 387, 89, 23);
		contentPane.add(btnOk);

	}

}

class MyComboBoxs extends JComboBox {
	/**
	 * 
	 */

	public MyComboBoxs() {
		addItem("Male");
		addItem("Female");
	}
}

class MyComboDeparts extends JComboBox {
	/**
	 * 
	 */

	public MyComboDeparts() {
		addItem("Services");
		addItem("Complain");
		addItem("Other");
	}
}

class MyComboRoles extends JComboBox {
	/**
	 * 
	 */

	public MyComboRoles() {
		addItem("Admin");
		addItem("Employee");
	}
}
