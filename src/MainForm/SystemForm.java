package MainForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Config.ConnectionSQL;
import Models.CRUD.AddNewAccount;
import Models.CRUD.AddNewClient;
import Models.CRUD.AddNewComplain;
import Models.CRUD.AddNewDepartment;
import Models.CRUD.AddNewProduct;
import Models.CRUD.AddNewRole;
import Models.CRUD.AddNewOrder;
import Models.CRUD.AddNewStatusComplain;
import Models.CRUD.AddNewStatusOrder;
import Models.Views.AccountView;
import Models.Views.ClientView;
import Models.Views.ComplainView;
import Models.Views.DepartmentView;
import Models.Views.OrderView;
import Models.Views.ProductView;
import Models.Views.RoleView;
import Models.Views.StatusComplainView;
import Models.Views.StatusOrderView;

import javax.swing.JSplitPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class SystemForm {

	private JFrame ElevationSystemFrame;
	public static ConnectionSQL conn;
//	public static JTextArea myArea = new JTextArea(1, 1);
//	private JScrollPane myControlArea = new JScrollPane(myArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
//			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private JSplitPane jSplitPane;
	private JPanel[] myTables = new JPanel[10];
	private JPanel[] myPanelAdd = new JPanel[10];
	private JScrollPane[] mySps = new JScrollPane[10];
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mFile = new JMenu("File");
	public static JLabel lblError = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemForm window = new SystemForm();
					window.ElevationSystemFrame.setVisible(true);
					window.ElevationSystemFrame.validate();
					window.ElevationSystemFrame.validate();
					window.ElevationSystemFrame.repaint();
					
				} catch (Exception e) {
//					SystemForm.myArea.append(e.toString());
					System.out.println(e.getStackTrace());
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public SystemForm() {
//		myArea.setTabSize(0);
//		myArea.setPreferredSize(new Dimension(22, 1));

		ElevationSystemFrame = new JFrame();
		ElevationSystemFrame.setBounds(100, 100, 1280, 720);
		Container cp = ElevationSystemFrame.getContentPane();
		myTables[0] = new AccountView();
		myTables[1] = new ClientView();
		myTables[2] = new ProductView();
		myTables[3] = new OrderView();
		myTables[4] = new DepartmentView();
		myTables[5] = new ComplainView();
		myTables[6] = new StatusComplainView();
		myTables[7] = new StatusOrderView();
		myTables[8] = new RoleView();

//
		cp.add(menuBar, BorderLayout.NORTH);

		menuBar.add(mFile);

		mySps[0] = new JScrollPane(myTables[0], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[1] = new JScrollPane(myTables[1], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[2] = new JScrollPane(myTables[2], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[3] = new JScrollPane(myTables[3], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[4] = new JScrollPane(myTables[4], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[5] = new JScrollPane(myTables[5], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[6] = new JScrollPane(myTables[6], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[7] = new JScrollPane(myTables[7], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySps[8] = new JScrollPane(myTables[8], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//
		JToolBar myToolbar = new myToolbar(tabbedPane, ElevationSystemFrame, conn);

		tabbedPane.addTab("Account", mySps[0]);
		tabbedPane.addTab("Client", mySps[1]);
		tabbedPane.addTab("Product Elevation", mySps[2]);
		tabbedPane.addTab("Order View", mySps[3]);
		tabbedPane.addTab("Department", mySps[4]);
		tabbedPane.addTab("Complain", mySps[5]);
		tabbedPane.addTab("Status Complain", mySps[6]);
		tabbedPane.addTab("Status Order", mySps[7]);
		tabbedPane.addTab("Role Account", mySps[8]);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					myTables[0].setVisible(true);
					break;
				case 1:
					myTables[1].setVisible(true);
					break;
				case 2:
					myTables[2].setVisible(true);
					break;
				case 3:
					myTables[3].setVisible(true);
					break;
				case 4:
					myTables[4].setVisible(true);
					break;
				case 5:
					myTables[5].setVisible(true);
					break;
				case 6:
					myTables[6].setVisible(true);
					break;
				case 7:
					myTables[7].setVisible(true);
					break;
				case 8:
					myTables[8].setVisible(true);
					break;
				default:
					break;
				}
			}
		});
//
		jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane,null);
		cp.add(myToolbar, BorderLayout.NORTH);
		cp.add(jSplitPane);
		lblError.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblError.setBackground(Color.CYAN);
		lblError.setAlignmentX(1.0f);
		lblError.setAlignmentY(1.0f);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		ElevationSystemFrame.getContentPane().add(lblError, BorderLayout.SOUTH);

		ElevationSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ElevationSystemFrame.setTitle("ELEVATION SYSTEM MANAGER");
		ElevationSystemFrame.getContentPane().setVisible(true);
		ElevationSystemFrame.revalidate();
		ElevationSystemFrame.repaint();
	}

}

class myToolbar extends JToolBar {
	public myToolbar(final JTabbedPane tabbed, final JFrame root, final ConnectionSQL conn) {
		JPanel[] myPanels = new JPanel[10];
		// setLayout(null);
		Icon SearchImag = new ImageIcon("../ElevationSystemManager/src/icons/search.png");
		Icon reportImag = new ImageIcon("../ElevationSystemManager/src/icons/report.png");
		Icon addImag = new ImageIcon("../ElevationSystemManager/src/icons/create.png");

		addBtn = new JButton("ADD", addImag);

		searchBtn = new JButton("SEARCH", SearchImag);

		reportBtn = new JButton("Report", reportImag);

		addBtn.setAlignmentY(CENTER_ALIGNMENT);
		searchBtn.setAlignmentY(CENTER_ALIGNMENT);
		reportBtn.setAlignmentY(CENTER_ALIGNMENT);
		add(addBtn);
		add(reportBtn);
		add(searchBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (tabbed.getSelectedIndex()) {
				case 0:
					(new AddNewAccount()).setVisible(true);
					break;
				case 1:
					(new AddNewClient()).setVisible(true);
					break;
				case 2:
					(new AddNewProduct()).setVisible(true);
					break;
				case 3:
					(new AddNewOrder()).setVisible(true);
					break;
				case 4:
					(new AddNewDepartment()).setVisible(true);
					break;
				case 5:
					(new AddNewComplain()).setVisible(true);
					break;
				case 6:
					(new AddNewStatusComplain()).setVisible(true);
					break;
				case 7:
					(new AddNewStatusOrder()).setVisible(true);
					break;
				case 8:
					(new AddNewRole()).setVisible(true);
					break;
				default:
					break;
				}

			}
		});
	}

	private JButton searchBtn;
	private JButton reportBtn;
	private JButton addBtn;
}
