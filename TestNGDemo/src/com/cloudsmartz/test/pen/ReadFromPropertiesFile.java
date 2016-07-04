package com.cloudsmartz.test.pen;

import java.io.InputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

	Properties properties = null;

	ReadFromPropertiesFile() {
		try {
			InputStream is = ReadFromPropertiesFile.class.getClassLoader()
					.getResourceAsStream("config.properties");
			properties = new Properties();
			properties.load(is);
		} catch (Exception e) {
			System.out.println("aaaa " + e);
		}
	}

	public String getPropertyValue(String property) {
		try {
			return properties.getProperty(property);
		} catch (Exception e) {
			System.out.println("getURL:" + e);
		}
		return "";
	}

}
