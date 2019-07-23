package MyLibrary;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

	/**
	 * class constructor
	 * 
	 * @author Giang
	 */
	public ButtonRenderer() {
		// Button properties
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object object, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText((object == null) ? "" : object.toString());
		return this;
	}
}