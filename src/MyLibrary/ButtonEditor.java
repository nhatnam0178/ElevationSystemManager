package MyLibrary;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor {

	protected JButton btn;
	private String text;

	/**
	 * Edit for a JTextfield to Button
	 * 
	 * @param txt JTextfield
	 * @author Giang
	 */
	public ButtonEditor(JTextField txt) {
		super(txt);
		// TODO Auto-generated constructor stub
		btn = new JButton();
		btn.setOpaque(true);
	}
}