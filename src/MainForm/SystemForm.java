package MainForm;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Config.ConnectionSQL;
import Models.AccountTableAfter;
import Models.AccountView;
import Models.QueryTableModel;
import Models.RoleTable;

import javax.swing.JSplitPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.Dimension;

public class SystemForm {

	private JFrame ElevationSystemFrame;
	public static ConnectionSQL conn;
	public static JTextArea myArea = new JTextArea(1, 1);
	private JScrollPane myControlArea = new JScrollPane(myArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private JSplitPane jSplitPane;
	private JPanel[] myTables = new JPanel[10];
	private JScrollPane[] mySps = new JScrollPane[10];
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mFile = new JMenu("File");
//	public myStart start = new myStart();
	QueryTableModel qtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemForm window = new SystemForm();
					window.ElevationSystemFrame.setVisible(true);
				} catch (Exception e) {
					SystemForm.myArea.append(e.toString());
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public SystemForm() {
		myArea.setTabSize(1);
		myArea.setPreferredSize(new Dimension(22, 1));
		myArea.setMinimumSize(new Dimension(22, 1));
		myArea.setMaximumSize(new Dimension(22, 1));
		ElevationSystemFrame = new JFrame();
		ElevationSystemFrame.setBounds(100, 100, 1280, 720);
		Container cp = ElevationSystemFrame.getContentPane();
		myTables[0] = new AccountView();
		myTables[1] = new AccountView();
		myTables[2] = null;
		myTables[3] = null;
		myTables[4] = null;
		myTables[5] = null;
		myTables[6] = null;
		myTables[7] = null;
		myTables[8] = null;
		myTables[9] = new RoleTable();
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
		mySps[9] = new JScrollPane(myTables[9], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//
		JToolBar myToolbar = new myToolbar(tabbedPane, ElevationSystemFrame, conn);

		tabbedPane.addTab("Account", mySps[0]);
		tabbedPane.addTab("Client", mySps[1]);
		tabbedPane.addTab("Product Elevation", mySps[2]);
		tabbedPane.addTab("Order View", mySps[3]);
		tabbedPane.addTab("Order Detail", mySps[4]);
		tabbedPane.addTab("Department", mySps[5]);
		tabbedPane.addTab("Complain", mySps[6]);
		tabbedPane.addTab("Status Complain", mySps[7]);
		tabbedPane.addTab("Status Order", mySps[8]);
		tabbedPane.addTab("Role Account", mySps[9]);

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
				case 9:
					((RoleTable) (myTables[9])).ChangeModel();
				default:
					break;
				}
			}
		});
//
		jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, myControlArea);
		cp.add(myToolbar, BorderLayout.NORTH);
		cp.add(jSplitPane);

		ElevationSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ElevationSystemFrame.setTitle("ELEVATION SYSTEM MANAGER");
		ElevationSystemFrame.getContentPane().setVisible(true);
		ElevationSystemFrame.revalidate();
	}

}

class myToolbar extends JToolBar {
	public myToolbar(final JTabbedPane tabbed, final JFrame root, final ConnectionSQL conn) {
		// setLayout(null);
		Icon SearchImag = new ImageIcon("../ElevationSystemManager/src/icons/search.png");
		Icon reportImag = new ImageIcon("../ElevationSystemManager/src/icons/report.png");

		searchBtn = new JButton("SEARCH", SearchImag);

		reportBtn = new JButton("Report", reportImag);

		searchBtn.setAlignmentY(CENTER_ALIGNMENT);

		reportBtn.setAlignmentY(CENTER_ALIGNMENT);

		add(reportBtn);
		add(searchBtn);

//		searchBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				switch (tabbed.getSelectedIndex()) {
//				case 0:
//					break;
//				case 1:
//					break;
//				case 2:
//					break;
//				case 3:
//					break;
//				case 4:
//					break;
//
//				default:
//					break;
//				}
//			}
//		});

	}

	private JButton addBtn;
	private JButton searchBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private JButton viewDetailBtn;
	private JButton reportBtn;
}

class myStart extends JDialog {
	myStart() {

		setUndecorated(true);
		// setIgnoreRepaint(true);
		setResizable(false);
		setSize(150, 150);
		setLocation(400, 300);

	}

	Image Imgstart = new ImageIcon("../ElevationSystemManager/src/icons/logo.png").getImage();

	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(Imgstart, 0, 0, this);
	}
}