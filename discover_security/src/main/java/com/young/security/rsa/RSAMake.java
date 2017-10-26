package com.young.security.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.young.security.utils.Base64;

public class RSAMake {

	RSAPrivateKey privateKey;
	RSAPublicKey publicKey;

	public static void main(String[] args) {
		RSAMake key=new RSAMake(1024);
		System.out.println(key.getPrivate());
		System.out.println(key.getPublicKey());

	}
	public RSAMake(int length) {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(length);
			// 生成一个密钥对，保存在keyPair中
			KeyPair keyPair = keyPairGen.generateKeyPair();
			// 得到私钥
			privateKey = (RSAPrivateKey) keyPair.getPrivate();

			publicKey = (RSAPublicKey) keyPair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPrivate() {

		if (privateKey != null) {
			String code = Base64.encode(privateKey.getEncoded());
			return code;

		} else {
			return null;
		}
	}

	public String getPublicKey() {

		if (publicKey != null) {
			String code = Base64.encode(publicKey.getEncoded());
			return code;
		} else {
			return null;
		}
	}
}
