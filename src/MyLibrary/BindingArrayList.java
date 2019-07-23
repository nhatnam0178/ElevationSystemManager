package MyLibrary;

import java.util.ArrayList;

public class BindingArrayList {

	/**
	 * Convert ArrayList to an Object[]
	 * 
	 * @param arr List Object
	 * @return Object[]
	 * @author Giang
	 */
	public Object[] ToObject(ArrayList<Object> arr) {
		Object[] obj = new Object[arr.size()];
		int index = 0;
		for (Object object : arr) {
			obj[index] = object;
			index++;
		}
		return obj;
	}

	/**
	 * Convert ArrayList to a String[]
	 * 
	 * @param arr List String
	 * @return String[]
	 * @author Giang
	 */
	public String[] ToString(ArrayList<String> arr) {
		String[] str = new String[arr.size()];
		int index = 0;
		for (String object : arr) {
			str[index] = object;
			index++;
		}
		return str;
	}

	/**
	 * Convert ArrayList to an Object[][]
	 * 
	 * @param arr List Object[]
	 * @return Object[][]
	 * @author Giang
	 */
	public Object[][] ToNObject(ArrayList<Object[]> arr, int column) {
		Object[][] obj = new Object[arr.size()][column];
		int index = 0;
		for (Object[] objects : arr) {
			for (int i = 0; i < objects.length; i++) {
				obj[index][i] = objects[i];
			}
		}
		return obj;
	}

	/**
	 * Convert List Object to String[]
	 * 
	 * @param arr List object need convert to String[]
	 * @return String[]
	 * @author Giang
	 */
	public String[] ObjectToString(ArrayList<Object> arr) {
		String[] str = new String[arr.size()];
		int index = 0;
		for (Object obj : arr) {
			str[index] = String.valueOf(obj);
			index++;
		}
		return str;
	}
}
