package com.young.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.young.security.utils.Base64;


public class ClientRSA {

	String privatekey  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDe0vQcgnUqEOsdNe5OIkYdTRVL"
					+ "JLCYNSca7+vIMF1PeFM84M3tL8I+pbrd0K1iRCQ9mk0aKsMaUkhrX7ZeCIziZcm0"
					+ "tS364/dQ4eQBAm98M4pEj9Ijuwmhl4LbHDXJe/nh1wd7+ycDB9L2tkKJAybB0fP8"
					+ "6cZTKvNXB46wo3lJzwIDAQAB";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientRSA rsa = new ClientRSA();
		System.out.println(rsa.encode("xx"));
	}

	public String encode(String r) {
		String reslut = "";
		try {
			RSAPublicKey p = getPublicKey(privatekey);
			byte[] y;
			y = encrypt(p, r.getBytes());
			reslut = Base64.encode(y);

		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;

	}

	public String decoder(String r) {
		String reslut = "";

		try {
			RSAPublicKey p = getPublicKey(privatekey);
			byte[] y;
			y = decrypt(p, Base64.decode(r));
			reslut=new String(y);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;

	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (publicKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] encrypt(RSAPrivateKey publicKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (publicKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] decrypt(RSAPrivateKey privateKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (privateKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}
	/**
	 * 解密
	 * 
	 * @param privateKey
	 * @param srcBytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private byte[] decrypt(RSAPublicKey privateKey, byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (privateKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}
	private static RSAPrivateKey getPrivateKey(String x)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			IOException {

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
				Base64.decode(x));
		RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory
				.generatePrivate(priPKCS8);
		return privateKey;
	}

	public static RSAPublicKey getPublicKey(String x)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			IOException {

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec priPKCS8 = new X509EncodedKeySpec(
				Base64.decode(x));
		RSAPublicKey privateKey = (RSAPublicKey) keyFactory
				.generatePublic(priPKCS8);
		return privateKey;
	}
}
