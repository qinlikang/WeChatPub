package com.coder.wechat.pub;

import java.util.Arrays;

public class CheckUtil {
	private static final String token = "51coderinfoLincoln";
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] str = new String[] { token, timestamp, nonce };
		Arrays.sort(str);
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length; ++i) {
			buffer.append(str[i]);
		}
		String temp = SHA1.encode(buffer.toString());
		return signature.equals(temp);
	}
}
