package MainForm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.AccountDAO;
import DAO.LoginDAO;
import entities.Accounts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm extends JDialog {
	private JTextField txtusername;
	private JPasswordField passwordField;
	Accounts accs = new Accounts();
	static boolean statusLog;
	static String uname;
	static int accountRole;

	/**
	 * Create the dialog.
	 */
	public LoginForm() {
		setTitle("LOGIN SYSTEM");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 382, 247);
		getContentPane().setLayout(null);

		JLabel lblLoginToElevation = new JLabel("LOGIN TO ELEVATION MANAGER");
		lblLoginToElevation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoginToElevation.setBounds(80, 21, 245, 19);
		getContentPane().add(lblLoginToElevation);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(27, 69, 91, 14);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 119, 91, 14);
		getContentPane().add(lblPassword);

		txtusername = new JTextField();
		txtusername.setBounds(128, 66, 211, 20);
		getContentPane().add(txtusername);
		txtusername.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uname = txtusername.getText();
				String upass = String.valueOf(passwordField.getPassword());
				if ((uname.equals("")) || (upass.equals(""))) {
					JOptionPane.showMessageDialog(LoginForm.this, "Username or Password not Empty", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DAO.LoginDAO lgDao = new LoginDAO();
					String[] signin = { uname, upass };
					Object[] obj = lgDao.CheckLogin("sp_GetLogin", signin, 1);
					if (Integer.valueOf(String.valueOf(obj[0])) > 0) {
						statusLog = true;
						AccountDAO accDao = new AccountDAO();
						ResultSet rs = accDao.findAccountByUsername(uname);
						try {
							while (rs.next()) {
								entities.Account accItem = new entities.Account();
								accItem.setId(rs.getInt("ID"));
								accItem.setusername(rs.getString("USERNAME"));
								accItem.setpassword(rs.getString("PASSWORD"));
								accItem.setname(rs.getString("NAME"));
								accItem.setrole_id(rs.getInt("ROLE_ID"));

								accountRole = accItem.getrole_id();
							}
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						dispose();
					} else {
						JOptionPane.showMessageDialog(LoginForm.this, "Username or Password Invalid", "Error",
								JOptionPane.ERROR_MESSAGE);
						statusLog = false;
						dispose();
					}
				}
			}
		});
		btnLogin.setBounds(151, 163, 89, 23);

		getContentPane().add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(250, 163, 89, 23);
		getContentPane().add(btnCancel);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 116, 211, 20);
		getContentPane().add(passwordField);

	}
}
