package Models;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.RoleDAO;
import entities.Role;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewRole extends JFrame {
	RoleDAO rl;

	private JPanel contentPane;
	private JTextField txtRole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewRole frame = new AddNewRole();
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
	public AddNewRole() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRoleName = new JLabel("Role Name: ");
		lblRoleName.setBounds(7, 45, 66, 20);
		contentPane.add(lblRoleName);

		txtRole = new JTextField();
		txtRole.setBounds(83, 45, 223, 20);
		contentPane.add(txtRole);
		txtRole.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtRole.getText();
				try {
					rl = new RoleDAO();
					rl.insertRole(name);
					dispose();
				} catch (Exception e) {
					e.getStackTrace();
				}

			}
		});
		btnOk.setBounds(115, 76, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(217, 76, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAddNewRole = new JLabel("ADD NEW ROLE ACCOUNT");
		lblAddNewRole.setBounds(115, 11, 135, 14);
		contentPane.add(lblAddNewRole);
	}
}
