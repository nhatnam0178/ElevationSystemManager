package Models.CRUD;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.DepartmentDAO;
import DAO.ProductElevationDAO;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

public class EditDepartment extends JDialog {
	private JTextField txtName;
	static int idGet;

	/**
	 * Create the panel.
	 */
	public EditDepartment(int idGet) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 373, 197);
		getContentPane().setLayout(null);
		DAO.ProductElevationDAO proDao = new ProductElevationDAO();

		String aName;
		aName = proDao.findbyIdReturnName(idGet, "sp_findName_Department_by_id");

		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setBounds(10, 52, 120, 25);
		getContentPane().add(lblDepartmentName);

		txtName = new JTextField();
		txtName.setBounds(129, 49, 200, 25);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(aName);
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(110, 111, 89, 23);
		getContentPane().add(btnOk);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(234, 110, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblInputNewName = new JLabel("Input New Name for Deprtment");
		lblInputNewName.setBounds(62, 11, 285, 32);
		getContentPane().add(lblInputNewName);
		lblInputNewName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.DepartmentDAO dep = new DepartmentDAO();
				try {
					dep.editDepartment(idGet, String.valueOf(txtName.getText()));
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

	}

}
