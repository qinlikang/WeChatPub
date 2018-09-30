package com.coder.wechat.pub;

import java.security.MessageDigest;

public final class SHA1 {
	private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}; 
	
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder builder = new StringBuilder(len * 2);
		for (int i = 0; i < len; ++i) {
			builder.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			builder.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return builder.toString();
	}
	
	public static String encode(String str) {
		if (str == null) {
			return null;
		}
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}