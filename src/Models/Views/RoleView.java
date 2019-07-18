package Models.Views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import Config.ConnectionSQL;
import DAO.OrderDetailDAO;
import Models.CRUD.EditDepartment;
import entities.Role;
import entities.Roles;
import entities.Status_Order;
import entities.Status_Orders;

public class RoleView extends JPanel {
	Roles rls = new Roles();
	static int idGet;

	/**
	 * Create the panel.
	 */
	public RoleView() {
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
		panelData.setLayout(new GridLayout(rls.size() + 15, 1));

		String str = "SELECT * FROM ROLE";
		ResultSet rs = ConnectionSQL.Query(str);

		try {
			while (rs.next()) {
				entities.Role dep = new Role();
				dep.setId(rs.getInt("ID"));
				dep.setname(rs.getString("NAME"));

				rls.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stt = 1;
		for (Role item : rls) {
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
					DAO.OrderDetailDAO detai = new OrderDetailDAO();
					int idGet = item.getId();
					OrderDetail or = new OrderDetail(idGet);
					or.setVisible(true);
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