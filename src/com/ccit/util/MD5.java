package com.ccit.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String md5(String value) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(value.getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String str = hash.toString(16);
		return str;
	}

}
