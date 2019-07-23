package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditRole extends JDialog {
	static int idGet;
	private JTextField txtName;

	/**
	 * Create the dialog.
	 */
	public EditRole(int idGet) {
		setBounds(100, 100, 323, 110);
		getContentPane().setLayout(null);
		
		JLabel lblRoleName = new JLabel("Role Name:");
		lblRoleName.setBounds(10, 11, 76, 14);
		getContentPane().add(lblRoleName);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOk.setBounds(79, 37, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancel.setBounds(204, 37, 89, 23);
		getContentPane().add(btnCancel);
		
		txtName = new JTextField();
		txtName.setBounds(79, 8, 214, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
	}
}
