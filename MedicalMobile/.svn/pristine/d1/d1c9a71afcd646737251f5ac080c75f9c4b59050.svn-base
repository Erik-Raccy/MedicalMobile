package com.se3a04.medicalmobile;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class Encryption {

	public byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    public byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }
    
    //generates key
   public byte[] generateKey() throws Exception{
    byte[] keyStart = "this is a key".getBytes();
	
	KeyGenerator kgen = KeyGenerator.getInstance("AES");
	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	
	sr.setSeed(keyStart);
	kgen.init(128, sr); // 192 and 256 bits may not be available
	SecretKey skey = kgen.generateKey();
    
	byte[] key = skey.getEncoded();    
    return key;
    		}
   
   /*HOW TO TURN BYTE ARRAY TO STRING
    * 
    * byte [] stuff = "blahhhhh".getBytes();
    * String s= new String(stuff);
    * 
    * */
    
}
