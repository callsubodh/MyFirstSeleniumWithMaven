package com.web.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		//this.driver = driver;
	}

	 @FindBy(xpath="//*[@name='email']") WebElement emailId;	 
	 @FindBy(name="password") WebElement pwd;	 
	 @FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]") WebElement loginBtn;
	 
	 public void loginToCRM(String emailAdd, String pass) {
		 emailId.sendKeys(emailAdd);
		 pwd.sendKeys(pass);
		 loginBtn.click();	 
	 
	 }
}
