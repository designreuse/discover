package com.tongna;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;

import java.io.File;
import java.io.InputStream;

public class UploadUtils {

	public UploadUtils(String bucket,String domain) {
		this.bucket = bucket;
		this.domain=domain;
	}

	private String  bucket;

	private String domain;

	public  boolean updload(String key, InputStream input) {

		boolean result = true;
		try {
			BosClient client = createClient();

			// 以文件形式上传Object

			PutObjectResponse response = client.putObject(bucket, key, input);
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public  boolean updload(String key, File input) {

		boolean result = true;
		try {
			BosClient client = createClient();

			// 以文件形式上传Object

			PutObjectResponse response = client.putObject(bucket, key, input);
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public  boolean updload(String key, byte[] input) {

		boolean result = true;
		try {
			BosClient client = createClient();

			// 以文件形式上传Object
			PutObjectResponse response = client.putObject(bucket, key, input);
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public  boolean updload(PutObjectRequest request) {

		boolean result = true;
		try {
			BosClient client = createClient();

			// 以文件形式上传Object
			PutObjectResponse response = client.putObject(request);
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	/**
	 * @return
	 */
	private  BosClient createClient() {

		ClientFactory client=new ClientFactory();
		return client.create(domain);
	}
}
