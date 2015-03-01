package utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class WebSecurity {
	
	public final static WebSecurity webSecurity = new WebSecurity();
	
	private static SecretKey key;
	private static Cipher ecipher;
	private static Cipher dcipher;

	
	private WebSecurity()
	{
		try {
			key = KeyGenerator.getInstance("DES").generateKey();
			ecipher = Cipher.getInstance("DES");
			dcipher = Cipher.getInstance("DES");
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * function to encrypting text 
	 * @param input - normal text
	 * @return encrypted text
	 */
	public String encript(String input)
	{
		try {
			byte[] utf8 = input.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);
			enc = BASE64EncoderStream.encode(enc);
			return new String(enc);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * function to decrypting text
	 * @param input - encrypted text
	 * @return - normal text
	 */
	public String decript(String input)
	{
		try {
			byte[] dec = BASE64DecoderStream.decode(input.getBytes());
			byte[] utf8 = dcipher.doFinal(dec);
			return new String(utf8, "UTF8");
		} catch (Exception e) {
		  	e.printStackTrace();
		}
		return null;
	}
}
