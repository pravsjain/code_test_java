package com.internationalsos.doctorpatientapp.secure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5EncryptAlgo {

	public static String cryptWithMD5(String pass) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] passBytes = pass.getBytes();
		md.reset();
		byte[] digested = md.digest(passBytes);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digested.length; i++) {
			sb.append(Integer.toString((digested[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
