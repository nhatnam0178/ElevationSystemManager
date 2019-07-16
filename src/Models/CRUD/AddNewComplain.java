package Models.CRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewComplain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewComplain frame = new AddNewComplain();
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
	public AddNewComplain() {
		setTitle("ADD NEW COMPLAIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputNewComplain = new JLabel("INPUT NEW COMPLAIN");
		lblInputNewComplain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewComplain.setBounds(125, 11, 203, 14);
		contentPane.add(lblInputNewComplain);
		
		JLabel lblOrderid = new JLabel("Order_ID:");
		lblOrderid.setBounds(10, 45, 91, 14);
		contentPane.add(lblOrderid);
		
		JLabel lblAccountid = new JLabel("Account_ID:");
		lblAccountid.setBounds(10, 80, 91, 14);
		contentPane.add(lblAccountid);
		
		JLabel lblNewLabel = new JLabel("IS_Chargeable:");
		lblNewLabel.setBounds(10, 115, 91, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(111, 112, 85, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(111, 42, 217, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(111, 77, 217, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblProblem = new JLabel("Problem:");
		lblProblem.setBounds(10, 153, 91, 14);
		contentPane.add(lblProblem);
		
		textField = new JTextField();
		textField.setBounds(111, 150, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date_Complain:");
		lblNewLabel_1.setBounds(10, 188, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 185, 217, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 229, 91, 14);
		contentPane.add(lblStatus);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(111, 226, 217, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblTechnicalperson = new JLabel("Technical_Person:");
		lblTechnicalperson.setBounds(10, 270, 100, 14);
		contentPane.add(lblTechnicalperson);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 267, 217, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(250, 325, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(151, 325, 89, 23);
		contentPane.add(btnOk);
	}
}
