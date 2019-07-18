package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DepartmentDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewDepartment extends JDialog{

	private JPanel contentPane;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddNewDepartment frame = new AddNewDepartment();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddNewDepartment(JFrame root) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 305, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewDepartment = new JLabel("INPUT NEW DEPARTMENT");
		lblInputNewDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewDepartment.setBounds(76, 11, 211, 14);
		contentPane.add(lblInputNewDepartment);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 39, 46, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(66, 36, 204, 20);
		contentPane.add(textName);
		textName.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(181, 79, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				try {
					DAO.DepartmentDAO depDao = new DepartmentDAO();
					depDao.insertDepartment(name);
					setVisible(false);
					dispose();
					
				} catch (Exception e2) {
					System.out.println(e2.getStackTrace());
				}

			}
		});
		btnOk.setBounds(76, 79, 89, 23);
		contentPane.add(btnOk);
	}

}
