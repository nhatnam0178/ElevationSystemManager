package Models.CRUD;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.DepartmentDAO;
import DAO.ProductElevationDAO;
import MainForm.SystemForm;
import Models.Views.DepartmentView;
import Models.Views.StatusComplainView;
import Models.Views.StatusOrderView;
import entities.Status_Order;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

public class EditNameStatusOrder extends JDialog {
	private JTextField txtName;
	static int idGet;

	/**
	 * Create the panel.
	 */
	public EditNameStatusOrder(int idGet) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 373, 197);
		getContentPane().setLayout(null);
		DAO.ProductElevationDAO proDao = new ProductElevationDAO();

		String aName;
		aName = proDao.findbyIdReturnName(idGet, "sp_findName_STATUS_ORDERNAME_by_id");

		JLabel lblDepartmentName = new JLabel("Status Name:");
		lblDepartmentName.setBounds(10, 52, 120, 25);
		getContentPane().add(lblDepartmentName);

		txtName = new JTextField();
		txtName.setBounds(129, 49, 200, 25);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(aName);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(234, 110, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblInputNewName = new JLabel("Input Name for Status Order");
		lblInputNewName.setBounds(62, 11, 285, 32);
		getContentPane().add(lblInputNewName);
		lblInputNewName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(110, 111, 89, 23);
		getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.StatusOrder dep = new DAO.StatusOrder();

				try {
					dep.editStatusOrder(idGet, String.valueOf(txtName.getText()));
					StatusOrderView ads = new StatusOrderView();
					ads.setVisible(true);
					SystemForm.myTables[7].removeAll();
					SystemForm.myTables[7].validate();
					SystemForm.myTables[7].repaint();
					SystemForm.myTables[7].add(new StatusOrderView());
					SystemForm.myTables[7].validate();
					SystemForm.myTables[7].repaint();

					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

	}

}
