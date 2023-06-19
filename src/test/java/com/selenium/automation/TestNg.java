package com.selenium.automation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNg extends BaseUI {
	Excel ex = new Excel();
	public static ExtentReports report;
	public static ExtentTest logger;
	

	@BeforeSuite
	public void openBrowser() throws Exception {
		//to generate html report
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\htmlReports\\report"+ DateUtils.getTimeStamp() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		Driver.openBrowser("browserName");
		BaseUI test_scenario = PageFactory.initElements(driver, BaseUI.class);
		test_scenario.openLink("url");

	}

	@Test
	//calling functions 
	public void test() throws Exception {
		Excel.readExcelData("ExcelData.xlsx");
		Excel.getExcelPath();
		BaseUI test_scenario1 = PageFactory.initElements(driver, BaseUI.class);
		logger = report.createTest("First Name");
		try {
			logger.info("Enter First Name");
			test_scenario1.enterFirstName();
			logger.pass("Test case passed",MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}catch (Exception e) {
			logger.fail("Test case Failed "+e,MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}
		
		logger = report.createTest("Last Name");
		try {
			logger.info("Enter Last Name");	
			test_scenario1.enterLastName();
			logger.pass("Test case passed",MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}catch (Exception e) {
			logger.fail("Test case Failed "+e,MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}
		
		logger = report.createTest("Business Name");
		try {
			logger.info("Enter Business Name");	
			test_scenario1.enterBusName();
			logger.pass("Test case passed",MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}catch (Exception e) {
			logger.fail("Test case Failed "+e,MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}
		
		logger = report.createTest("Email Address");
		try {
			logger.info("Enter Email Address");	
		test_scenario1.enterEmailName();
		logger.pass("Test case passed",MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}catch (Exception e) {
			logger.fail("Test case Failed "+e,MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}
		
		logger = report.createTest("Product List");
		try {
			logger.info("Get Product List");			
		test_scenario1.getListProduct();
		
		logger.pass("Test case passed",MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}catch (Exception e) {
			logger.fail("Test case Failed "+e,MediaEntityBuilder.createScreenCaptureFromPath(screenShot.screenShot1(driver)).build());
		}
		screenShot.screenShot1(driver);
		
	}

	@AfterMethod
	// function to close browser
	public void closeBrowser() { 
		report.flush();
		driver.quit();
	}
}


