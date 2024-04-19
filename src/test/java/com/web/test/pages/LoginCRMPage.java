package com.web.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCRMPage {

//	public WebDriver driver;	

	public LoginCRMPage(WebDriver driver){

//		both the below options can be used
		PageFactory.initElements(driver, this);
//		this.driver = driver;
	}

	@FindBy(name="email") WebElement emailId;
	@FindBy(name="password") WebElement pwd;
//	WebElement pwd = driver.findElement(By.name("password"));

	public void loginToCRM(String emailAdd, String pass) {
		emailId.sendKeys(emailAdd);
		pwd.sendKeys(pass);

	}
}
