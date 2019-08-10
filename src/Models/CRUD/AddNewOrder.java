package Models.CRUD;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Config.ConnectionSQL;
import DAO.OrdersDAO;
import MainForm.SystemForm;
import Models.Views.OrderView;
import entities.Account;
import entities.Accounts;
import entities.Client;
import entities.Clients;
import entities.Status_Order;
import entities.Status_Orders;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddNewOrder extends JDialog {

	private JPanel contentPane;
	private JTextField textTotalPrice;
	private JTextField textDateOrder;
	private JTextField textDateInstall;
	private JTextField textDateComplete;
	Accounts accs = new Accounts();
	Clients clis = new Clients();
	Status_Orders stOr = new Status_Orders();
	static int idPut;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddNewOrder frame = new AddNewOrder();
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
	public AddNewOrder(JFrame root) {
		setTitle("ADD NEW ORDER");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 352, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputNewOrder = new JLabel("INPUT NEW ORDER");
		lblInputNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInputNewOrder.setBounds(113, 11, 181, 19);
		contentPane.add(lblInputNewOrder);

		JLabel lblNewLabel = new JLabel("Client_Name:");
		lblNewLabel.setBounds(10, 45, 99, 14);
		contentPane.add(lblNewLabel);

		JComboBox comboBoxClient = new JComboBox();

		comboBoxClient.setBounds(140, 42, 181, 20);

		// LoadData
		String strQuery = "SELECT * FROM CLIENT";
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				entities.Client itemCli = new Client();
				itemCli.setId(rs.getInt("ID"));
				itemCli.setname(rs.getString("NAME"));

				clis.add(itemCli);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Client item : clis) {
			comboBoxClient.addItem(item.getname());
		}
		contentPane.add(comboBoxClient);

		JLabel lblAccountid = new JLabel("Account_ID:");
		lblAccountid.setBounds(10, 83, 99, 14);
		contentPane.add(lblAccountid);

		String strQr = "SELECT * FROM ACCOUNT";
		//
		rs = ConnectionSQL.Query(strQr);
		try {
			while (rs.next()) {
				entities.Account accItem = new entities.Account();
				accItem.setId(rs.getInt("ID"));
				accItem.setname(rs.getString("NAME"));
				accs.add(accItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JComboBox comboAccountID = new JComboBox();
		comboAccountID.setBounds(140, 80, 181, 20);

		// Load ACcountID
		for (Account item : accs) {

			comboAccountID.addItem(item.getname());

		}
		contentPane.add(comboAccountID);

		JLabel lblTotalprice = new JLabel("Total_Price:");
		lblTotalprice.setBounds(10, 121, 99, 14);
		contentPane.add(lblTotalprice);

		textTotalPrice = new JTextField();
		textTotalPrice.setBounds(140, 118, 181, 20);
		contentPane.add(textTotalPrice);
		textTotalPrice.setColumns(10);

		JLabel lblDateorder = new JLabel("Date_Order:");
		lblDateorder.setBounds(10, 160, 123, 14);
		contentPane.add(lblDateorder);

		textDateOrder = new JTextField();
		textDateOrder.setBounds(140, 157, 87, 20);
		contentPane.add(textDateOrder);
		textDateOrder.setColumns(10);

		JLabel lblDateinstalled = new JLabel("Date_Installed:");
		lblDateinstalled.setBounds(10, 197, 99, 14);
		contentPane.add(lblDateinstalled);

		textDateInstall = new JTextField();
		textDateInstall.setBounds(140, 194, 87, 20);
		contentPane.add(textDateInstall);
		textDateInstall.setColumns(10);

		JLabel lblDatecomplete = new JLabel("Date_Complete:");
		lblDatecomplete.setBounds(10, 234, 99, 14);
		contentPane.add(lblDatecomplete);

		textDateComplete = new JTextField();
		textDateComplete.setBounds(140, 231, 87, 20);
		contentPane.add(textDateComplete);
		textDateComplete.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 275, 46, 14);
		contentPane.add(lblStatus);

		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(140, 272, 181, 20);
		String str = "SELECT * FROM STATUS_ORDER";
		rs = ConnectionSQL.Query(str);

		try {
			while (rs.next()) {
				entities.Status_Order dep = new Status_Order();
				dep.setid(rs.getInt("ID"));
				dep.setname(rs.getString("NAME"));

				stOr.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Status_Order item : stOr) {
			comboBoxStatus.addItem(item.getname());
		}
		contentPane.add(comboBoxStatus);
		JButton btnGetdateOrder = new JButton("GetDate");
		btnGetdateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl = new Calendar(textDateOrder);
				cl.setVisible(true);
			}
		});
		btnGetdateOrder.setBounds(232, 156, 89, 23);
		contentPane.add(btnGetdateOrder);

		JButton btnGetdateInstall = new JButton("GetDate");
		btnGetdateInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl2 = new Calendar(textDateInstall);
				cl2.setVisible(true);
			}
		});
		btnGetdateInstall.setBounds(232, 193, 89, 23);
		contentPane.add(btnGetdateInstall);

		JButton btnGetdateComplete = new JButton("GetDate");
		btnGetdateComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cl3 = new Calendar(textDateComplete);
				cl3.setVisible(true);
			}
		});
		btnGetdateComplete.setBounds(232, 230, 89, 23);
		contentPane.add(btnGetdateComplete);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(237, 328, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.OrdersDAO orDAO = new OrdersDAO();
				// ClientID
				int client_Id = 0;
				Object a = comboBoxClient.getSelectedItem();
				for (Client ite : clis) {
					if (a.equals(ite.getname())) {
						client_Id = ite.getId();

					}
				}
				// AccountID
				int account_ID = 0;
				Object ac = comboAccountID.getSelectedItem();
				for (Account ite : accs) {
					if (ac.equals(ite.getname())) {
						account_ID = ite.getId();

					}
				}
				// StatusOrderID
				int status_ID = 0;
				Object or = comboBoxStatus.getSelectedItem();
				for (Status_Order ite : stOr) {
					if (or.equals(ite.getname())) {
						status_ID = ite.getid();

					}
				}
				try {
//					orDAO.insertOrders(client_Id, account_ID, Integer.parseInt(textTotalPrice.getText()),
//							String.valueOf(textDateOrder.getText()), String.valueOf(textDateInstall.getText()),
//							String.valueOf(textDateComplete.getText()), status_ID);
					String str = "insert into orders values(?,?,?,?,?,?,?)";
					String[] parameters = { String.valueOf(client_Id), String.valueOf(account_ID),
							String.valueOf(textTotalPrice.getText()), String.valueOf(textDateOrder.getText()),
							String.valueOf(textDateInstall.getText()),String.valueOf(textDateComplete.getText()),String.valueOf(status_ID) };
					idPut = orDAO.GetInsertId(str, parameters);
					AddNewOrderDetail adn = new AddNewOrderDetail(idPut);
					adn.setVisible(true);
					OrderView aor = new OrderView();
					aor.setVisible(true);
					SystemForm.myTables[3].removeAll();
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					SystemForm.myTables[3].add(new OrderView());
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					dispose();
				} catch (Exception e2) {
					System.err.println(e2.getStackTrace());
				}
			}
		});
		btnOk.setBounds(138, 328, 89, 23);
		contentPane.add(btnOk);

	}

}
