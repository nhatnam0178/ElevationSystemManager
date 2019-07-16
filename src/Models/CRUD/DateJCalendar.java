package Models.CRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateJCalendar extends AbstractFormatter {
	private String dataPattern = "dd/MM/yyyy";
	private SimpleDateFormat format1 = new SimpleDateFormat(dataPattern);

	@Override
	public Object stringToValue(String text) throws ParseException {
		// TODO Auto-generated method stub
		return format1.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		// TODO Auto-generated method stub
		if (value != null) {
			Calendar cal = (Calendar) value;
			return format1.format(cal.getTime());
		}

		return "";
	}

}
