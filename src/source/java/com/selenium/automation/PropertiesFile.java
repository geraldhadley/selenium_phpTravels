package com.selenium.automation;

import java.io.FileInputStream;
import java.util.Properties;

//class for configuring properties file
public class PropertiesFile {

	public static String readCon(String prop_name) throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(ip);
		return prop.getProperty(prop_name);
	}
}
