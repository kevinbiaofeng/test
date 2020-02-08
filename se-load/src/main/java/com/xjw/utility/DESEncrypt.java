package com.xjw.utility;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class DESEncrypt {
	String key;

	public DESEncrypt() {
	}

	public DESEncrypt(String key) {
		this.key = key;
	}

	public byte[] desEncrypt(byte[] plainText) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key, sr);
		byte data[] = plainText;
		byte encryptedData[] = cipher.doFinal(data);
		return encryptedData;
	}

	public byte[] desDecrypt(byte[] encryptText) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key, sr);
		byte encryptedData[] = encryptText;
		byte decryptedData[] = cipher.doFinal(encryptedData);
		return decryptedData;
	}

	public String encrypt(String input) throws Exception {
		return base64Encode(desEncrypt(input.getBytes()))
				.replaceAll("\\s*", "");
	}

	public String decrypt(String input) throws Exception {
		byte[] result = base64Decode(input);
		return new String(desDecrypt(result));
	}

	public String base64Encode(byte[] s) {
		if (s == null)
			return null;
		
		return Base64.getEncoder().encodeToString(s);
	}

	public byte[] base64Decode(String s) throws IOException {
		if (s == null) {
			return null;
		}
		
		return Base64.getDecoder().decode(s);
	}

	public static void main(String args[]) {
		try {
			DESEncrypt d = new DESEncrypt("Selnwk1j2");
			//{"userId":"251" ,"gameType": 1}
			//String p = d.encrypt("{\"userId\":\"261\" ,\"gameType\": 1}");
			String p = d.encrypt("{\"userId\":\"251\" ,\"gameType\": 1}");
			System.out.println("DES密文:" + p);
			System.out.println("MD5密文:" + MD5Util.md5Encode(p + "NJDNFJR#@B1W74j323**lDdee2"));
			
//			String p2 = d.encrypt("{\"userId\":\"261\" ,\"gameType\": 1, \"credit\":100, \"type\":\"IN\"}");
			String p2 = d.encrypt("{\"userId\":\"251\" ,\"gameType\": 1 ,\"credit\": \"100\" ,\"type\": \"IN\"}");;
			System.out.println("DES密文:" + p2);
			System.out.println(URLEncoder.encode(URLEncoder.encode(p2, "UTF-8"), "UTF-8"));
			System.out.println("MD5密文:" + MD5Util.md5Encode(p2 + "NJDNFJR#@B1W74j323**lDdee2"));
			
			String p3 = d.encrypt("{\"userId\":\"261\" ,\"gameType\": 1, \"game\": 6}");
			System.out.println("DES密文:" + p3);
			System.out.println("MD5密文:" + MD5Util.md5Encode(p3 + "NJDNFJR#@B1W74j323**lDdee2"));
			//http://192.168.0.131/apis/game/ag/QZtudk2JGhtwG7O+Cx3nPI8+im8R7hehoHRTOCeJxCw=/25065bef0aea036a1cfa504b7c13e28d/forwardGame.json
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    //http://gi.hailanbet.com:81/forwardGame.do?params=EZ5WpnWMPjaF5+f7X92+VbgcnWjdiBoVAGOkunegz51+1PLRcq+/mDeI86qHB3StyTyVE93xkY6PU2YKe0FMnIKUubtOf2f/EOC1V9UH1LoW9leDhKnG482KoOOwsuhH4OWp2d3O0R9u/U0LtCZJYXoQvSaQCgNRZPgLKqSDySXtUOS9T/vaCL3y/F/j5oNZwnB4GdqNl+w1O3bn5rrca6w2var9z4twLFvGXxeizq0JIdfJZFxinA==&key=1b5ec7553b85c56a62bfdb6d568041a2
	//http://gi.hailanbet.com:81/forwardGame.do?params=EZ5WpnWMPjaF5+f7X92+VbgcnWjdiBoVAGOkunegz51+1PLRcq+/mDeI86qHB3StyTyVE93xkY6PU2YKe0FMnIKUubtOf2f/EOC1V9UH1LoW9leDhKnG482KoOOwsuhH4OWp2d3O0R9u/U0LtCZJYQJNm0JuXgT7ZPgLKqSDySXtUOS9T/vaCL3y/F/j5oNZwnB4GdqNl+w1O3bn5rrca6w2var9z4twLFvGXxeizq0JIdfJZFxinA==&key=b414b0f12bbe65954bad2d22561c7fd7
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
