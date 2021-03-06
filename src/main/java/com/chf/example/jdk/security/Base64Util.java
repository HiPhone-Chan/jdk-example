package com.chf.example.jdk.security;

import java.util.Base64;

public class Base64Util {

	private Base64Util() {
	}

	public static byte[] decryptBASE64(byte[] src) {
		return Base64.getDecoder().decode(src);
	}

	public static String decryptBASE64(String src) {
		return new String(Base64.getDecoder().decode(src));
	}

	public static byte[] encryptBASE64(byte[] key) {
		return Base64.getEncoder().encode(key);
	}

	public static String encryptBASE64(String key) {
		return new String(Base64.getEncoder().encode(key.getBytes()));
	}

	public static void main(String[] args) {
		System.out.println(Base64Util.encryptBASE64("123asda"));
		System.out.println(Base64Util.decryptBASE64("MTIzYXNkYQ=="));
	}
}
