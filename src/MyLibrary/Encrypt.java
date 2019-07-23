package MyLibrary;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encrypt {
	/**
	 * Encrypt by Base64
	 * 
	 * @param str String
	 * @return String
	 * @author Giang
	 */
	public String encode(String str) {
		return (Base64.getEncoder().encodeToString(str.getBytes()));
	}

	/**
	 * Encrypt by MD5
	 * 
	 * @param str String
	 * @return String
	 * @author Giang
	 */
	public String md5(String str) {
		MessageDigest mdEnc;
		try {
			mdEnc = MessageDigest.getInstance("MD5");
			mdEnc.update(str.getBytes(), 0, str.length());
			String md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
			return md5;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Decrypt Base64
	 * 
	 * @param str String
	 * @return String
	 * @author Giang
	 */
	public String decode(String str) {
		byte[] decode = Base64.getDecoder().decode(str);
		String check = new String(decode);
		return check;
	}
}
