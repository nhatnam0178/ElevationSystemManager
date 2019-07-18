package Models.CRUD;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.ClientDAO;

public class EditClient extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtCompany;

	static int idEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClient frame = new EditClient(idEdit);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param idEdit
	 */
	public EditClient(int idEdit) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(85, 38, 232, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(85, 69, 232, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(85, 100, 232, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtCompany = new JTextField();
		txtCompany.setBounds(85, 131, 231, 20);
		contentPane.add(txtCompany);
		txtCompany.setColumns(10);

		//
		ClientDAO cliDao = new ClientDAO();
		ResultSet rs = cliDao.findbyId(idEdit);

		try {
			while (rs.next()) {
				entities.Client cliItem = new entities.Client();
				cliItem.setId(rs.getInt("ID"));
				cliItem.setname(rs.getString("NAME"));
				cliItem.setaddress(rs.getString("ADDRESS"));
				cliItem.setphone(rs.getString("PHONE"));
				cliItem.setcompany_name(rs.getString("COMPANY_NAME"));
				//
				txtName.setText(cliItem.getname());
				txtPhone.setText(cliItem.getphone());
				txtAddress.setText(cliItem.getaddress());
				txtCompany.setText(cliItem.getcompany_name());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblInputNewInfo = new JLabel("EDIT CLIENT");
		lblInputNewInfo.setBounds(108, 11, 171, 14);
		contentPane.add(lblInputNewInfo);

		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(10, 40, 67, 14);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("PHONE: ");
		lblNewLabel.setBounds(10, 72, 83, 14);
		contentPane.add(lblNewLabel);

		JLabel lblName_1 = new JLabel("ADDRESS: ");
		lblName_1.setBounds(10, 103, 65, 14);
		contentPane.add(lblName_1);

		JLabel lblNewLabel_1 = new JLabel("COMPANY: ");
		lblNewLabel_1.setBounds(10, 134, 67, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(239, 198, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String address = txtAddress.getText();
				String company_name = txtCompany.getText();
				if (cliDao.editClient(name, phone, address, company_name, idEdit) == true) {
					dispose();
				}
			}
		});
		btnOk.setBounds(140, 198, 89, 23);
		contentPane.add(btnOk);

	}

}