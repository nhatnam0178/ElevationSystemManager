package Models.Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Config.ConnectionSQL;
import DAO.ClientDAO;
import DAO.OrderDetailDAO;
import MainForm.SystemForm;
import Models.CRUD.EditDepartment;
import Models.CRUD.EditNameStatusOrder;
import entities.Status_Order;
import entities.Status_Orders;

public class StatusOrderView extends JPanel {
	Status_Orders stOr = new Status_Orders();
	static int idGet;

	/**
	 * Create the panel.
	 */
	public StatusOrderView() {
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

		JLabel lbstt = new JLabel("STT");
		panelHeader.add(lbstt);

		JLabel lbNam = new JLabel("NAME");
		panelHeader.add(lbNam);

		JLabel lbAc = new JLabel("ACTION");
		panelHeader.add(lbAc);
		JPanel panelData = new JPanel();
		scrollPane.setViewportView(panelData);
		panelData.setLayout(new GridLayout(stOr.size() + 10, 1));

		String str = "SELECT * FROM STATUS_ORDER";
		ResultSet rs = ConnectionSQL.Query(str);

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
		int stt = 1;
		for (Status_Order item : stOr) {
			JPanel pnlItem = new JPanel();
			pnlItem.setLayout(new GridLayout(1, 0));
			pnlItem.setPreferredSize(new Dimension(10, 10));

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
					idGet = item.getid();
					EditNameStatusOrder edDepart = new EditNameStatusOrder(idGet);
					edDepart.setVisible(true);

				}
			});
			//
			JButton deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DAO.StatusOrder stDao = new DAO.StatusOrder();
					int result = JOptionPane.showConfirmDialog(panelGird,
							"Delete Account : " + " ' " + item.getid() + " ' " + " , " + " Are You Sure?",
							"Delete a Account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							stDao.delStatusOrder(item.getid());
							StatusOrderView act = new StatusOrderView();
							act.setVisible(true);
							SystemForm.myTables[7].removeAll();
							SystemForm.myTables[7].validate();
							SystemForm.myTables[7].repaint();
							SystemForm.myTables[7].add(new StatusOrderView());
							SystemForm.myTables[7].validate();
							SystemForm.myTables[7].repaint();
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

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void revalidate() {
		// TODO Auto-generated method stub
		super.revalidate();
	}
}
