package com.cloudsmartz.test.pen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Test {

	ReadFromPropertiesFile rdp = new ReadFromPropertiesFile();

	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
	}

	public String postRequestForToken(String url, String username,
			String password, String grantType) {
		StringBuffer strBuff = new StringBuffer();
		try {
			if (url.contains(" ")) {
				strBuff.append("Space Not Allowed in URL\n");
			} 
			if (!url
					.equals(rdp.getPropertyValue("URL"))) {
				strBuff.append("URL not acceptable..Check your URL\n");
			} 
			if (!username.equals(rdp.getPropertyValue("username"))) {
				strBuff.append("Username not acceptable\n");
			} 
			if (!password.equals( rdp.getPropertyValue("password"))) {
				strBuff.append("Password not acceptable\n");
			} 
			if (!grantType.equals( rdp.getPropertyValue("grantType"))) {
				strBuff.append("Grant Type not acceptable\n");
			}
			if (strBuff.capacity() == 16) {
				HttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(url);
				List<NameValuePair> nameValuePairs = new ArrayList();
				nameValuePairs
						.add(new BasicNameValuePair("username", username));
				nameValuePairs
						.add(new BasicNameValuePair("password", password));
				nameValuePairs.add(new BasicNameValuePair("grant_type",
						grantType));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = client.execute(post);
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					// System.out.println(line);
					strBuff.append(line);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in  postRequestForToken():  " + e);
		}
		return strBuff.toString();
	}
}