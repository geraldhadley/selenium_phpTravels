package com.selenium.automation;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BaseUI extends Driver {
	
	// Using POM for getting path
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[1]")
	WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[2]")
	WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[3]")
	WebElement businessName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[3]")
	WebElement busName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[4]")
	WebElement emailId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[1]/ul/li[3]/div/span")
	WebElement product;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[1]/ul/li[3]/div/div")
	List<WebElement> listProduct;
	
	//function for link
	public void openLink(String url) throws Exception  {
		driver.get(PropertiesFile.readCon("url"));
	}

	//function to enter first name
	public void enterFirstName() {
		firstName.click();
		firstName.sendKeys(Excel.userData[0]);

	}

	//function to enter last name
	public void enterLastName() {
		lastName.click();
		lastName.sendKeys(Excel.userData[1]);

	}

	//function to enter email address
	public void enterEmailName() {
		emailId.click();
		emailId.sendKeys(Excel.userData[2]);

	}

	//function to enter business name
	public void enterBusName() {
		busName.click();
		busName.sendKeys(Excel.userData[3]);
	}

	//function to list down different products in the list
	public void getListProduct() {
		product.click();
		for (WebElement h1 : listProduct) {
			System.out.println(h1.getText());
		}
	}

}
