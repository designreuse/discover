package com.young.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.young.security.utils.Base64;


public class Apps {


	public static void main(String[] args) throws NoSuchAlgorithmException,
			InvalidKeySpecException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		// TODO Auto-generated method stub

		String x = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDe0vQcgnUqEOsdNe5OIkYdTRVL"
				+ "JLCYNSca7+vIMF1PeFM84M3tL8I+pbrd0K1iRCQ9mk0aKsMaUkhrX7ZeCIziZcm0"
				+ "tS364/dQ4eQBAm98M4pEj9Ijuwmhl4LbHDXJe/nh1wd7+ycDB9L2tkKJAybB0fP8"
				+ "6cZTKvNXB46wo3lJzwIDAQAB";

		try {
			RSAPublicKey pkey = getPublicKey(x);

			EncrypRSA rsa = new EncrypRSA();
			byte[] b = rsa.encrypt(pkey, "xxx".getBytes());
			System.out.println(b);

			String pri = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAN7S9ByCdSoQ6x01"
					+ "7k4iRh1NFUsksJg1Jxrv68gwXU94Uzzgze0vwj6lut3QrWJEJD2aTRoqwxpSSGtf"
					+ "tl4IjOJlybS1Lfrj91Dh5AECb3wzikSP0iO7CaGXgtscNcl7+eHXB3v7JwMH0va2"
					+ "QokDJsHR8/zpxlMq81cHjrCjeUnPAgMBAAECgYEA3lg6Zsh3CYbgVcGfDjB9Lnfg"
					+ "q57s6LUBVIvcB2LbeZVj2fepBOkHN2RA116H5OqCD0aNcXMCRJ2eziYv4B1AFjwf"
					+ "nvhnx8ZuJhLTr8ae6zX+AxpZsRslOe0emoJwYoH8U3nFU6CeuXsLiTwMvKgqyQy3"
					+ "uFD7vWR82haAFFdZD8ECQQD/upc1PFDPISBHRJ/22qJOU73DK+Rl2aJ1TimTlnll"
					+ "QO0w/5oNqZO843+Sl3LbLZBuZdw+KeyFmPhmS/56cb8XAkEA3w9ulEIF2M9waIo6"
					+ "4GaKvQNRsz+PuE/ffo6rHBENV9m9HZBzNv9IM8nKQYlzDd96G9Ig0v3hlFrUTkMj"
					+ "j54+CQJATbiZ6BYSwUDiHIbgzxeXqJKO49hdLA8+7sP4ouBiuMFI1VF5splNS2Uh"
					+ "Cp54y+BHOyY+D66SMfBR3lVOXExhtQJAdTge3Dp16CHa6JT7q8E3V2zPGmtkk28l"
					+ "+9Pth6pOYMRD5a1rXpN41f5NE3OvyrKN8ODT7w0L5nJ070vI/EgkQQJAO/uNumHj"
					+ "KMLKLabQKzjgOFOxB3zDv1jWt4ZR0d9itSoebBv/TgZt/6SaOEMYVDW0xMofJaZL"
					+ "E0LJ5lmURiV1eQ==";

			RSAPrivateKey p = getPrivateKey(pri);
			byte[] y = rsa.decrypt(p, b);
			System.out.println(new String(y));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static RSAPrivateKey getPrivateKey(String x)
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
