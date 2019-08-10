package Models.Views;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;

import Config.ConnectionSQL;
import Models.CRUD.EditStatusComplain;
import entities.Complain;
import entities.Complains;
import entities.Status_Complain;
import entities.Status_Complains;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplainView extends JPanel {
	Complains comps = new Complains();
	entities.Status_Complains stComp = new Status_Complains();
	static int idGet;

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
		JLabel lbSTT = new JLabel();
		JLabel lblOrderEmpty = new JLabel();
		JLabel lblOrderIDj = new JLabel("ORDER_ID");
		JLabel lblAccountIDj = new JLabel("ACCOUNT_ID");
		JLabel lblCHARGEABLEj = new JLabel("IS_CHARGEABLE");
		JLabel lblPROBLEMj = new JLabel("PROBLEM");
		JLabel lblDATE_COMPLAINj = new JLabel("DATE_COMPLAIN");
		JLabel lblSTATUS_IDj = new JLabel("STATUS_COMPLAIN");
		JLabel lblTECHNICIAN_PERSONj = new JLabel("TECHNICIAN_PERSON");

		JLabel lblAction = new JLabel("ACTION");

		pnlHeader.setLayout(new GridLayout(1, 1));
		pnlHeader.add(lbSTT);
		pnlHeader.add(lblOrderEmpty);
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
//
		String str1 = "SELECT * FROM STATUS_COMPLAIN";
		ResultSet rs1 = ConnectionSQL.Query(str1);

		try {
			while (rs1.next()) {
				entities.Status_Complain dep = new entities.Status_Complain();
				dep.setId(rs1.getInt("ID"));
				dep.setname(rs1.getString("NAME"));

				stComp.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String strQuery = "SELECT * FROM COMPLAIN";
		//
		ResultSet rs = ConnectionSQL.Query(strQuery);
		try {
			while (rs.next()) {
				Complain comp = new Complain();
				comp.setId(rs.getInt("ID"));
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
		int stt = 1;
		for (Complain item : comps) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout(1, 1));
			JLabel lblOrderID1 = new JLabel();
			panelItem.add(lblOrderID1);
			JLabel lbSTTj = new JLabel(String.valueOf(stt));
			panelItem.add(lbSTTj);
			if (stt % 2 == 0) {
				panelItem.setBackground(Color.WHITE);
			} else {
				panelItem.setBackground(Color.CYAN);

			}

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

			JLabel lblSTATUS_COMPLAIN = new JLabel();
			panelItem.add(lblSTATUS_COMPLAIN);
			for (Status_Complain it : stComp) {
				if (item.getstatus_id() == it.getId()) {
					lblSTATUS_COMPLAIN.setText(it.getname());
				}
			}

			JLabel lblDATE_COMPLAIN = new JLabel();
			lblDATE_COMPLAIN.setText(item.getdate_complain().toString());
			panelItem.add(lblDATE_COMPLAIN);

			JLabel lblTECHNICIAN_PERSON = new JLabel();
			lblTECHNICIAN_PERSON.setText(item.gettechnician_person());
			panelItem.add(lblTECHNICIAN_PERSON);

			// add new Panel Action
			JPanel acPanel = new JPanel();

			JButton editBtn = new JButton("Edit Status");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idGet = item.getId();
					EditStatusComplain edc = new EditStatusComplain(idGet);
					edc.setVisible(true);
				}
			});
			stt++;
			acPanel.add(editBtn);
			panelItem.add(acPanel);
			//
			panelData.add(panelItem);
		}

	}

}
