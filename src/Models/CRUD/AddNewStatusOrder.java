package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.StatusComplainDAO;
import DAO.StatusOrder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewStatusOrder extends JDialog {

	private JPanel contentPane;
	private JTextField textName;

	/**
	 * Create the frame.
	 */
	public AddNewStatusOrder(JFrame root) {
		setTitle("ADD STATUS ORDER");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 323, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewStatus = new JLabel("INPUT NEW STATUS ORDER");
		lblInputNewStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewStatus.setBounds(73, 11, 238, 25);
		contentPane.add(lblInputNewStatus);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 49, 46, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(59, 47, 224, 20);
		contentPane.add(textName);
		textName.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(194, 92, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				try {
					DAO.StatusOrder compDao = new StatusOrder();
					compDao.insertStatusOrder(name);
					setVisible(false);
				} catch (Exception e2) {
					System.out.println(e2.getStackTrace());
				}

			}
		});
		btnOk.setBounds(95, 92, 89, 23);
		contentPane.add(btnOk);
	}

}
