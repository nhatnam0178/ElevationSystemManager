package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DepartmentDAO;
import DAO.StatusComplainDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewStatusComplain extends JFrame {

	private JPanel contentPane;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewStatusComplain frame = new AddNewStatusComplain();
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
	public AddNewStatusComplain() {
		setTitle("ADD STATUS COMPLAIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewStatus = new JLabel("INPUT NEW STATUS COMPLAIN");
		lblInputNewStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewStatus.setBounds(67, 11, 262, 19);
		contentPane.add(lblInputNewStatus);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 48, 46, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(55, 45, 241, 20);
		contentPane.add(textName);
		textName.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(219, 95, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				try {
					DAO.StatusComplainDAO compDao = new StatusComplainDAO();
					compDao.insertStatusComplain(name);
					setVisible(false);
				} catch (Exception e2) {
					System.out.println(e2.getStackTrace());
				}

			}
		});
		btnOk.setBounds(120, 95, 89, 23);
		contentPane.add(btnOk);
	}

}
