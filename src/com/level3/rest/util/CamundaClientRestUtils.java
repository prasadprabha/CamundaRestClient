package com.level3.rest.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

public class CamundaClientRestUtils {
	
	public static byte[] getBytes(String path) {

		FileInputStream fileInputStream=null;
        File file = new File(path);
        byte[] bFile = new byte[(int) file.length()];

        try {
		    fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return bFile;
	}
	
	public static HttpHeaders getHeadersWithCredentials(String username,String password) {
		String plainCreds = "willie:p@ssword";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}

}
