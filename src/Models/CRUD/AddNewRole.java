package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.RoleDAO;
import entities.Role;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewRole extends JDialog {
	RoleDAO rl;

	private JPanel contentPane;
	private JTextField txtRole;

	/**
	 * Create the frame.
	 */
	public AddNewRole(JFrame root) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 332, 176);
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
		btnOk.setBounds(118, 103, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(217, 103, 89, 23);
		contentPane.add(btnCancel);

		JLabel lblAddNewRole = new JLabel("ADD NEW ROLE ACCOUNT");
		lblAddNewRole.setBounds(115, 11, 135, 14);
		contentPane.add(lblAddNewRole);
	}
}
