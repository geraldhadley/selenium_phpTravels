package com.selenium.automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;


//calling drivers
	public static WebDriver openBrowser(String browserName) throws Exception {
		//chrome browser
		if(PropertiesFile.readCon("browserName").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		}
		//firefox browser
		else if(PropertiesFile.readCon("browserName").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
			
		}
		//msEdge browser
		else if(PropertiesFile.readCon("browserName").equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver();
		    driver = new EdgeDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		return driver;
		
	}
	
	
}
