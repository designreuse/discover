package com.young.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String id() {
		String result = "";
		result = UUID.randomUUID().toString();
		return result;
	}
}
