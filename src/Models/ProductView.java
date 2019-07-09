package Models;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class ProductView extends JFrame {
	public ProductView() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.NORTH);

		JPanel panelHeader = new JPanel();
		getContentPane().add(panelHeader, BorderLayout.SOUTH);
		panelHeader.setLayout(new GridLayout(1, 0, 0, 0));
		scrollPane.setColumnHeaderView(panelHeader);
		JLabel lblStt = new JLabel("STT");
		panelHeader.add(lblStt);

		JLabel lblName = new JLabel("Name");
		panelHeader.add(lblName);

		JLabel lblNewLabel = new JLabel("Price");
		panelHeader.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Type");
		panelHeader.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date_of_Order");
		panelHeader.add(lblNewLabel_2);

		JLabel lblWarranty = new JLabel("Warranty");
		panelHeader.add(lblWarranty);

		JLabel lblWarrantyexpiredate = new JLabel("Warranty_expire_date");
		panelHeader.add(lblWarrantyexpiredate);

		JPanel panelData = new JPanel();
		getContentPane().add(panelData, BorderLayout.WEST);
		panelData.setLayout(new GridLayout(1, 0, 0, 0));

	}

}
