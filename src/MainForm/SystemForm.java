package MainForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class SystemForm {

	public JFrame ElevationSystemFrame;
	public static ConnectionSQL conn;
	static boolean statusLog;
	private JSplitPane jSplitPane;
	public static JPanel[] myTables = new JPanel[10];
	public JPanel[] myPanelAdd = new JPanel[10];
	private JScrollPane[] mySps = new JScrollPane[10];
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mFile = new JMenu("File");
	static String uname;
	static int accountRole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm lg = new LoginForm();
					lg.setVisible(true);
					if (statusLog == true) {
						lg.dispose();
						SystemForm window = new SystemForm(uname, accountRole);
						window.ElevationSystemFrame.setVisible(true);

						window.ElevationSystemFrame.validate();
						window.ElevationSystemFrame.repaint();
					} else if (statusLog == false) {
						lg.setVisible(true);
						SystemForm window = new SystemForm(uname, accountRole);
						window.ElevationSystemFrame.setVisible(false);
					}

				} catch (Exception e) {

					System.out.println(e.getStackTrace());
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public SystemForm(String uname, int accountRole) {
//		myArea.setTabSize(0);
//		myArea.setPreferredSize(new Dimension(22, 1));

		ElevationSystemFrame = new JFrame();
		ElevationSystemFrame.setBounds(100, 100, 1800, 800);
		Container cp = ElevationSystemFrame.getContentPane();
		myTables[0] = new JPanel(new BorderLayout());
		myTables[1] = new JPanel(new BorderLayout());
		myTables[2] = new JPanel(new BorderLayout());
		myTables[3] = new JPanel(new BorderLayout());
		myTables[4] = new JPanel(new BorderLayout());
		myTables[5] = new JPanel(new BorderLayout());
		myTables[6] = new JPanel(new BorderLayout());
		myTables[7] = new JPanel(new BorderLayout());
		myTables[8] = new JPanel(new BorderLayout());
		myTables[0].add(new AccountView());
		myTables[1].add(new ClientView());
		myTables[2].add(new ProductView());
		myTables[3].add(new OrderView());
		myTables[4].add(new DepartmentView());
		myTables[5].add(new ComplainView());
		myTables[6].add(new StatusComplainView());
		myTables[7].add(new StatusOrderView());
		myTables[8].add(new RoleView());

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
				ElevationSystemFrame.revalidate();
				ElevationSystemFrame.repaint();
			}
		});
//
		jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, null);
		cp.add(myToolbar, BorderLayout.NORTH);
		cp.add(jSplitPane);

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
		lbHello = new JLabel("Hello,  ");
		lbaccountName = new JLabel();
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
					AddNewAccount aat = new AddNewAccount(root);
					aat.setVisible(true);
					SystemForm.myTables[0].removeAll();
					SystemForm.myTables[0].validate();
					SystemForm.myTables[0].repaint();
					SystemForm.myTables[0].add(new AccountView());
					SystemForm.myTables[0].validate();
					SystemForm.myTables[0].repaint();
					break;
				case 1:
					AddNewClient act = new AddNewClient(root);
					act.setVisible(true);
					SystemForm.myTables[1].removeAll();
					SystemForm.myTables[1].validate();
					SystemForm.myTables[1].repaint();
					SystemForm.myTables[1].add(new ClientView());
					SystemForm.myTables[1].validate();
					SystemForm.myTables[1].repaint();
					break;
				case 2:
					AddNewProduct apt = new AddNewProduct(root);
					apt.setVisible(true);
					SystemForm.myTables[2].removeAll();
					SystemForm.myTables[2].validate();
					SystemForm.myTables[2].repaint();
					SystemForm.myTables[2].add(new ProductView());
					SystemForm.myTables[2].validate();
					SystemForm.myTables[2].repaint();
					break;

				case 3:
					AddNewOrder aor = new AddNewOrder(root);
					aor.setVisible(true);
					SystemForm.myTables[3].removeAll();
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					SystemForm.myTables[3].add(new OrderView());
					SystemForm.myTables[3].validate();
					SystemForm.myTables[3].repaint();
					break;
				case 4:
					AddNewDepartment adt = new AddNewDepartment(root);

					adt.setVisible(true);
					SystemForm.myTables[4].removeAll();
					SystemForm.myTables[4].validate();
					SystemForm.myTables[4].repaint();
					SystemForm.myTables[4].add(new DepartmentView());
					SystemForm.myTables[4].validate();
					SystemForm.myTables[4].repaint();

					break;
				case 5:
					AddNewComplain adcom = new AddNewComplain(root);
					adcom.setVisible(true);
					SystemForm.myTables[5].removeAll();
					SystemForm.myTables[5].validate();
					SystemForm.myTables[5].repaint();
					SystemForm.myTables[5].add(new ComplainView());
					SystemForm.myTables[5].validate();
					SystemForm.myTables[5].repaint();
					break;
				case 6:
					AddNewStatusComplain adsc = new AddNewStatusComplain(root);
					adsc.setVisible(true);
					SystemForm.myTables[6].removeAll();
					SystemForm.myTables[6].validate();
					SystemForm.myTables[6].repaint();
					SystemForm.myTables[6].add(new StatusComplainView());
					SystemForm.myTables[6].validate();
					SystemForm.myTables[6].repaint();
					break;
				case 7:
					AddNewStatusOrder adso = new AddNewStatusOrder(root);
					adso.setVisible(true);
					SystemForm.myTables[7].removeAll();
					SystemForm.myTables[7].validate();
					SystemForm.myTables[7].repaint();
					SystemForm.myTables[7].add(new StatusOrderView());
					SystemForm.myTables[7].validate();
					SystemForm.myTables[7].repaint();
					break;
				case 8:
					AddNewRole anr = new AddNewRole(root);
					anr.setVisible(true);
					SystemForm.myTables[8].removeAll();
					SystemForm.myTables[8].validate();
					SystemForm.myTables[8].repaint();
					SystemForm.myTables[8].add(new RoleView());
					SystemForm.myTables[8].validate();
					SystemForm.myTables[8].repaint();
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
	private JLabel lbHello;
	private JLabel lbaccountName;
}
