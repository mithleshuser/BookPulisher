package com.bookpublisher.app.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncryptUtils {
	
	public static String encodeUrl(String url) throws Exception {
		String encodeUrl = URLEncoder.encode(url, "UTF-8");
		return encodeUrl;
	}
	
	public static String decodeUrl(String encodeUrl) throws Exception {
		String decodeUrl = URLDecoder.decode(encodeUrl, "UTF-8");
		return decodeUrl;
	}

	public static String getRandomPassword() {
		int noOfCAPSAlpha = 1;
		int noOfDigits = 1;
		int noOfSplChars = 1;
		int minLen = 8;
		int maxLen = 12;
		char[] pswd = RandomPasswordGenerator.generatePswd(minLen, maxLen, noOfCAPSAlpha, noOfDigits, noOfSplChars);
	
		/*		for (int i = 0; i < 10; i++) {
			char[] pswd = RandomPasswordGenerator.generatePswd(minLen, maxLen, noOfCAPSAlpha, noOfDigits, noOfSplChars);
			System.out.println("Len = " + pswd.length + ", " + new String(pswd));
		}*/
		return  new String(pswd);
	}
}

/*
 * public static void main(String[] args) throws Exception {
 * 
 * String crunchifyValue1 = "http://localhost:9090/J2EELogin/changyourpwd.jsp";
 * String ecodedValue1 = URLEncoder.encode(crunchifyValue1, "UTF-8"); String
 * decodedValue1 = URLDecoder.decode(ecodedValue1, "UTF-8"); System.out.println(
 * "crunchifyValue1 after encoding => " + ecodedValue1); System.out.println(
 * "crunchifyValue1 after decoding (Original Value): => " + decodedValue1);
 * 
 * String crunchifyValue2 = "http://localhost:9090/J2EELogin/changyourpwd.jsp";
 * String encodedValue2 = URLEncoder.encode(crunchifyValue2, "UTF-8"); String
 * decodedValue2 = URLDecoder.decode(encodedValue2, "UTF-8");
 * System.out.println("\ncrunchifyValue2 after encoding => " + encodedValue2);
 * System.out.println("crunchifyValue2 after decoding (Original Value) => " +
 * decodedValue2);
 * 
 * }
 */
