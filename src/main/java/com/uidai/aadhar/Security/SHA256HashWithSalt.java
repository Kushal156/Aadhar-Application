package com.uidai.aadhar.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class SHA256HashWithSalt {

	public static String generateSHA256HashWithSalt(String saltKey, String accessCode) throws NoSuchAlgorithmException {

		String dataToHash = saltKey + accessCode;

		MessageDigest digest = MessageDigest.getInstance("SHA-256");

		byte[] hashBytes = digest.digest(dataToHash.getBytes());

		StringBuilder hexString = new StringBuilder();

		for (byte b : hashBytes) {
//			hexString.append(String.format(" x", b));
			 hexString.append(String.format("%02x", b));
		}
		return hexString.toString();
	}
}
