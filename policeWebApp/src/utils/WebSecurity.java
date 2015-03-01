package utils;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class WebSecurity {
	
	public final static WebSecurity webSecurity = new WebSecurity();
	
    private final static String password = "root";
    private final static String SALT2 = "web police app";
    private final static String criptType = "AES";
	
	private static SecretKeySpec key;
	private static Cipher ecipher;
	private static Cipher dcipher;

	
	private WebSecurity()
	{
		try {
			byte[] keyString = (SALT2 + password).getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			keyString = sha.digest(keyString);
			keyString = Arrays.copyOf(keyString, 16);
			key = new SecretKeySpec(keyString, criptType);
			ecipher = Cipher.getInstance(criptType);
			dcipher = Cipher.getInstance(criptType);
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
