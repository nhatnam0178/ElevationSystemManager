package MainForm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AccountDAO;
import entities.Accounts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm extends JDialog {
	private JTextField txtusername;
	private JPasswordField passwordField;
	public static JLabel lblError = new JLabel();
	private JLabel lblMessageUser, lblMessagePass;
	Accounts accs = new Accounts();

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
		lblLoginToElevation.setBounds(94, 11, 245, 19);
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
				if (txtusername.getText().trim().equals("")) {
					lblMessageUser.setText("Username not empty");
				} else if (passwordField.getText().trim().equals("")) {
					lblMessagePass.setText("Password not empty");

				} else {
					try {

					} catch (Exception e2) {
						System.err.println(e2.getStackTrace());
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

		JLabel lblMessageUser = new JLabel();
		lblMessageUser.setForeground(Color.RED);
		lblMessageUser.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMessageUser.setBounds(128, 51, 148, 14);
		getContentPane().add(lblMessageUser);

		JLabel lblMessagePass = new JLabel();
		lblMessagePass.setForeground(Color.RED);
		lblMessagePass.setBackground(Color.WHITE);
		lblMessagePass.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMessagePass.setBounds(128, 97, 175, 14);
		getContentPane().add(lblMessagePass);

		JButton btnClearlogin = new JButton("ClearLogin");
		btnClearlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtusername.setText("");
				passwordField.setText("");
			}
		});
		btnClearlogin.setBounds(10, 174, 89, 23);
		getContentPane().add(btnClearlogin);
	}
}
