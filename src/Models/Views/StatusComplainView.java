package Models.Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import MainForm.SystemForm;
import Models.CRUD.EditDepartment;
import Models.CRUD.EditNameStatusComplain;
import Models.CRUD.EditStatusComplain;
import entities.Department;
import entities.Departments;
import entities.Status_Complain;
import entities.Status_Complains;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusComplainView extends JPanel {
	entities.Status_Complains stComp = new Status_Complains();
	static int idGet;

	/**
	 * Create the panel.
	 */
	public StatusComplainView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();
		panelGird.add(scrollPane);

		JPanel panelHeader = new JPanel();

		panelHeader.setLayout(new GridLayout(1, 1));
		JLabel lbstt1 = new JLabel("");
		panelHeader.add(lbstt1);
		JLabel lbstt = new JLabel("STT");
		panelHeader.add(lbstt);

		JLabel lbNam = new JLabel("NAME");
		panelHeader.add(lbNam);

		JLabel lbAc = new JLabel("ACTION");
		panelHeader.add(lbAc);
		scrollPane.setColumnHeaderView(panelHeader);
		scrollPane.add(panelHeader);
		JPanel panelData = new JPanel();
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(stComp.size() + 13, 1));

		String str = "SELECT * FROM STATUS_COMPLAIN";
		ResultSet rs = ConnectionSQL.Query(str);

		try {
			while (rs.next()) {
				entities.Status_Complain dep = new Status_Complain();
				dep.setId(rs.getInt("ID"));
				dep.setname(rs.getString("NAME"));

				stComp.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stt = 1;
		for (Status_Complain item : stComp) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0));
			pnlItem.setPreferredSize(new Dimension(20, 10));

			JLabel lbSTT1j = new JLabel("");
			pnlItem.add(lbSTT1j);
			JLabel lbSTT = new JLabel();
			lbSTT.setText(String.valueOf(stt));
			pnlItem.add(lbSTT);
			JLabel lbName = new JLabel();
			lbName.setText(item.getname());
			pnlItem.add(lbName);
			// add new Panel Action
			JPanel acPanel = new JPanel();
			acPanel.setLayout(new GridLayout(1, 1));
			JButton editBtn = new JButton("Edit");
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idGet = item.getId();
					EditNameStatusComplain edc = new EditNameStatusComplain(idGet);
					edc.setVisible(true);
				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.StatusComplainDAO stDao = new DAO.StatusComplainDAO();
					int result = JOptionPane.showConfirmDialog(panelGird,
							"Delete Account : " + " ' " + item.getId() + " ' " + " , " + " Are You Sure?",
							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							stDao.delStatusComplain(item.getId());
							StatusComplainView act = new StatusComplainView();
							act.setVisible(true);
							SystemForm.myTables[6].removeAll();
							SystemForm.myTables[6].validate();
							SystemForm.myTables[6].repaint();
							SystemForm.myTables[6].add(new StatusComplainView());
							SystemForm.myTables[6].validate();
							SystemForm.myTables[6].repaint();
						} catch (Exception e) {
							System.err.println(e.getStackTrace());
						}

					} else if (result == JOptionPane.NO_OPTION) {
						revalidate();
					}

				}
			});

			stt++;
			acPanel.add(editBtn);
			acPanel.add(deleteBtn);
			pnlItem.add(acPanel);
			panelData.add(pnlItem);
		}

	}

}
