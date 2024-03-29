package Models.Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;

import Config.ConnectionSQL;
import DAO.DepartmentDAO;
import DAO.OrderDetailDAO;
import MainForm.SystemForm;
import Models.CRUD.EditDepartment;
import entities.Department;
import entities.Departments;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class DepartmentView extends JPanel {
	entities.Departments deps = new Departments();
	static int idGet;

	/**
	 * Create the panel.
	 */
	public DepartmentView() {
		setLayout(new BorderLayout(0, 0));
		JPanel panelGird = new JPanel();
		add(panelGird);
		panelGird.setLayout(new GridLayout(1, 1));

		JScrollPane scrollPane = new JScrollPane();
		panelGird.add(scrollPane);

		JPanel panelHeader = new JPanel();
		scrollPane.setColumnHeaderView(panelHeader);
		scrollPane.add(panelHeader);
		panelHeader.setLayout(new GridLayout(1, 1));

		JLabel lbstt1 = new JLabel("");
		panelHeader.add(lbstt1);

		JLabel lbstt = new JLabel("STT");
		panelHeader.add(lbstt);

		JLabel lbNam = new JLabel("NAME");
		panelHeader.add(lbNam);

		JLabel lbAc = new JLabel("ACTION");
		panelHeader.add(lbAc);
		JPanel panelData = new JPanel();
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(deps.size()+13, 1));

		String str = "SELECT * FROM DEPARTMENT";
		ResultSet rs = ConnectionSQL.Query(str);

		try {
			while (rs.next()) {
				entities.Department dep = new Department();
				dep.setId(rs.getInt("ID"));
				dep.setname(rs.getString("NAME"));

				deps.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stt = 1;
		for (Department item : deps) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0));
			pnlItem.setPreferredSize(new Dimension(10, 10));

			JLabel lbSTT1 = new JLabel();
			pnlItem.add(lbSTT1);

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
					EditDepartment edDepart = new EditDepartment(idGet);
					edDepart.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.DepartmentDAO depDao = new DepartmentDAO();
					int result = JOptionPane.showConfirmDialog(panelGird,
							"Delete Client : " + " ' " + item.getname() + " ' " + " , " + " Are You Sure?",
							"Delete a Client?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						int idGet = item.getId();
						try {
							depDao.delDepartment(idGet);
							DepartmentView adt = new DepartmentView();
							adt.setVisible(true);
							SystemForm.myTables[4].removeAll();
							SystemForm.myTables[4].validate();
							SystemForm.myTables[4].repaint();
							SystemForm.myTables[4].add(new DepartmentView());
							SystemForm.myTables[4].validate();
							SystemForm.myTables[4].repaint();

						} catch (Exception e) {
							// TODO: handle exception
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
		validate();
		repaint();
	}

}
