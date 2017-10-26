package com.ada.user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

import java.util.Calendar;

public class UserUtils {

	private static String base64key = "ekVxD03S0ddY9MKH+4dWMtY3ol4Lbk73aXRAb2ygHwE4ZshtAIOuOeiqqBz4 N27G6oqF5h9eVMLw3V4//27O3g==";

	public static Long getMember(String token) {
		Long result = null;
		try {
			Jws<Claims> c = Jwts.parser().setSigningKey(base64key).parseClaimsJws(token);
			result = Long.parseLong(c.getBody().getSubject());
		} catch (Exception e) {
		}
		return result;

	}
	public static Long getApp(String token) {
		Long result = null;
		try {
			if (token==null){
				throw new TokenInvalidException();
			}
			Jws<Claims> c = Jwts.parser().setSigningKey(base64key).parseClaimsJws(token);
			result = Long.parseLong(c.getBody().getSubject());
		} catch (Exception e) {
			throw new TokenInvalidException();
		}
		return result;

	}
	public static String getToken(Long member) {
		String result = "";
		try {
			result = Jwts.builder().setSubject("" + member).signWith(SignatureAlgorithm.HS512, base64key)
					.compressWith(CompressionCodecs.GZIP).compact();
		} catch (Exception e) {
		}
		return result;

	}
	public static String getAppToken(Long member) {
		String result = "";
		try {
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.YEAR,1);
			result = Jwts.builder().setSubject("" + member).signWith(SignatureAlgorithm.HS512, base64key).setExpiration(calendar.getTime())
					.compressWith(CompressionCodecs.GZIP).compact();
		} catch (Exception e) {
		}
		return result;

	}
	public static String refreshAppToken(String token) {
		String result = "";
		try {
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.YEAR,1);
			Long member=getApp(token);
			result = Jwts.builder().setSubject("" + member).signWith(SignatureAlgorithm.HS512, base64key).setExpiration(calendar.getTime())
					.compressWith(CompressionCodecs.GZIP).compact();
		} catch (Exception e) {
			throw new RefreshException();
		}
		return result;

	}
	public static class RefreshException extends RuntimeException{

	}
	public static class TokenInvalidException extends RuntimeException{

	}
}
