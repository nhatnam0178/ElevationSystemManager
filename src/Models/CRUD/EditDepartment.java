package Models.CRUD;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.DepartmentDAO;
import DAO.ProductElevationDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EditDepartment extends JPanel {
	private JTextField txtName;
	static int idGet;

	/**
	 * Create the panel.
	 */
	public EditDepartment(int idGet) {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(null);

		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setBounds(32, 92, 120, 25);
		panelGird.add(lblDepartmentName);

		txtName = new JTextField();
		txtName.setBounds(162, 92, 200, 25);

		panelGird.add(txtName);
		txtName.setColumns(10);
		DAO.ProductElevationDAO proDao = new ProductElevationDAO();

		String aName;
		aName = proDao.findbyIdReturnName(idGet, "sp_findName_Department_by_id");
		txtName.setText(aName);
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOk.setBounds(198, 170, 89, 23);
		panelGird.add(btnOk);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(297, 170, 89, 23);
		panelGird.add(btnNewButton);

		JLabel lblInputNewName = new JLabel("Input New Name for Deprtment");
		lblInputNewName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInputNewName.setBounds(101, 11, 285, 32);
		panelGird.add(lblInputNewName);

	}

}
