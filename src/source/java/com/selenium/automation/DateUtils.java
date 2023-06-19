package com.selenium.automation;

import java.util.Date;

//class to get dynamic date and time
public class DateUtils {

	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
