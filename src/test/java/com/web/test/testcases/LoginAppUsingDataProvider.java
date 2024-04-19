package com.web.test.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.test.pages.LoginPage;
import com.web.test.utility.BrowserFactory;
import com.web.test.utility.Config;

public class LoginAppUsingDataProvider {

	public WebDriver driver;
	
	Config cfg = new Config();
	
	@Test(dataProvider = "wordpressData")
	public void loginToApplication(String username, String password) {
		
		//BrowserFactory.startApp(driver, "firefox", "https://register.freecrm.com/register/");		
		BrowserFactory.startApp("firefox", cfg.getURL());
		
		LoginPage loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		loginPageObj.loginToCRM(username, password);
	}
	
	
	@DataProvider(name="wordpressData")
	public Object[][] passData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "uone";
		data[0][1] = "passone";
		data[1][0] = "utwo";
		data[1][1] = "passtwo";
		data[2][0] = "uthree";
		data[2][1] = "passthree";
		
		return data;
	}
	
	@AfterTest
	public void closeApp() {
		
		BrowserFactory.quitBrowser(driver);
	}
	

}
