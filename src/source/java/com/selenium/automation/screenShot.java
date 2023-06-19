package com.selenium.automation;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//function for taking screenshot
public class screenShot extends BaseUI {
	public static String screenShot1(WebDriver driver) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath1 = System.getProperty("user.dir") + "\\screenshot\\screenshot_"+ DateUtils.getTimeStamp() +".png";
		FileHandler.copy(srcFile, new File(screenshotPath1));
		return screenshotPath1;
	}

}
