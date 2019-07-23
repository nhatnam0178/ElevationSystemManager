package Config;

public class Parameters {
	/**
	 * Get number of para you want to insert
	 * 
	 * @param para an Array of parameters String[]
	 * @return String
	 * @author Giang
	 */
	public String getpara(Object[] para) {
		String str = "";
		boolean start = true;
		for (int i = 0; i < para.length; i++) {
			if (start) {
				str += "?";
				start = false;
			} else {
				str += ",?";
			}
		}
		return str;
	}

	public String getpara(Object[] para, int add) {
		String str = "";
		boolean start = true;
		for (int i = 0; i < para.length + add; i++) {
			if (start) {
				str += "?";
				start = false;
			} else {
				str += ",?";
			}
		}
		return str;
	}
}
