package MyLibrary;

import java.util.regex.Pattern;

public class MyPattern {
	private static Pattern pattern;

	private final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{5,20}$";
	private final String PASSWORD_PATTERN = "^[a-zA-Z_0-9]{8,20}$";

	public static void Validate(String valid) {
		pattern = Pattern.compile(valid);
	}

	/**
	 * Check a String if it get the condition return true else return false
	 * 
	 * @param str      String need to check
	 * @param _pattern pattern
	 * @return boolean
	 * @author Giang
	 */
	public boolean Check(String str, String _pattern) {
		Validate(_pattern);
		return pattern.matcher(str).matches();
	}

	public boolean PasswordCheck(String str) {
		return Check(str, PASSWORD_PATTERN);
	}

	public boolean UsernameCheck(String str) {
		return Check(str, USERNAME_PATTERN);
	}
}
