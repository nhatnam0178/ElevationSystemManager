package Models.Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Config.ConnectionSQL;
import DAO.AccountDAO;
import MainForm.SystemForm;
import entities.Complain;
import entities.Complains;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplainView extends JPanel {
	Complains comps = new Complains();

	/**
	 * Create the panel.
	 */
	public ComplainView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();
		panelGird.add(scrollPane);
		//
		JPanel pnlHeader = new JPanel();

		JLabel lblOrderIDj = new JLabel("ORDER_ID");
		JLabel lblAccountIDj = new JLabel("ACCOUNT_ID");
		JLabel lblCHARGEABLEj = new JLabel("IS_CHARGEABLE");
		JLabel lblPROBLEMj = new JLabel("PROBLEM");
		JLabel lblDATE_COMPLAINj = new JLabel("DATE_COMPLAIN");
		JLabel lblSTATUS_IDj = new JLabel("STATUS_ID");
		JLabel lblTECHNICIAN_PERSONj = new JLabel("TECHNICIAN_PERSON");

		JLabel lblAction = new JLabel("ACTION");

		pnlHeader.setLayout(new GridLayout(1, 1));

		pnlHeader.add(lblOrderIDj);
		pnlHeader.add(lblAccountIDj);
		pnlHeader.add(lblCHARGEABLEj);
		pnlHeader.add(lblPROBLEMj);
		pnlHeader.add(lblSTATUS_IDj);
		pnlHeader.add(lblDATE_COMPLAINj);
		pnlHeader.add(lblTECHNICIAN_PERSONj);
		pnlHeader.add(lblAction);

		pnlHeader.add(lblAction);
		//
		scrollPane.setColumnHeaderView(pnlHeader);

		JPanel panelData = new JPanel();
		panelData.setLayout(new GridLayout(comps.size() + 10, 1));
		scrollPane.setViewportView(panelData);
////////
		String strQuery = "SELECT * FROM COMPLAIN";
		//
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				Complain comp = new Complain();
				comp.setorder_id(rs.getInt("ORDER_ID"));
				comp.setaccount_id(rs.getInt("ACCOUNT_ID"));
				comp.setis_chargeable(rs.getBoolean("IS_CHARGEABLE"));
				comp.setproblem(rs.getString("PROBLEM"));
				comp.setdate_complain(rs.getDate("DATE_COMPLAIN"));
				comp.setstatus_id(rs.getInt("STATUS_ID"));
				comp.settechnician_person(rs.getString("TECHNICIAN_PERSON"));
				comps.add(comp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		for (Complain item : comps) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout(1, 1));

			JLabel lblOrderID = new JLabel();
			lblOrderID.setText(String.valueOf(item.getorder_id()));
			panelItem.add(lblOrderID);

			JLabel lblAccountID = new JLabel();
			lblAccountID.setText(String.valueOf(item.getaccount_id()));
			panelItem.add(lblAccountID);

			JLabel lblCHARGEABLE = new JLabel();
			lblCHARGEABLE.setText(String.valueOf(item.getis_chargeable()));
			panelItem.add(lblCHARGEABLE);

			JLabel lblPROBLEM = new JLabel();
			lblPROBLEM.setText(item.getproblem());
			panelItem.add(lblPROBLEM);

			JLabel lblSTATUS_ID = new JLabel();
			lblSTATUS_ID.setText(String.valueOf(item.getstatus_id()));
			panelItem.add(lblSTATUS_ID);

			JLabel lblDATE_COMPLAIN = new JLabel();
			lblDATE_COMPLAIN.setText(item.getdate_complain().toString());
			panelItem.add(lblDATE_COMPLAIN);

			JLabel lblTECHNICIAN_PERSON = new JLabel();
			lblTECHNICIAN_PERSON.setText(item.gettechnician_person());
			panelItem.add(lblTECHNICIAN_PERSON);

			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("Edit     ");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					idEdit = account.getId();
//					EditAccount edc = new EditAccount(idEdit);
//					edc.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

				}
			});

			acPanel.add(editBtn);
			acPanel.add(deleteBtn);

			panelItem.add(acPanel);
			//
			panelData.add(panelItem);
		}

	}

}
