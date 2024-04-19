package com.web.test.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.test.pages.LoginPage;
import com.web.test.utility.BrowserFactory;

public class DataProviderDemo {

	public WebDriver driver;
	int age=2;
	
	@Test(dataProvider = "wordpressData")
	public void loginToApplication(String username, String password, int age) {
		
		driver=BrowserFactory.startApp("firefox", "https://ui.cogmento.com");
		
		LoginPage loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		loginPageObj.loginToCRM(username, password);
		System.out.println("Age of the user is: "+ age);
	}
	
	
	@DataProvider(name="wordpressData")
	public Object[][] passData(){
		
		Object[][] data = new Object[3][3];
		
		data[0][0] = "uone";
		data[0][1] = "passone";
		data[0][2]= 15;
		data[1][0] = "utwo";
		data[1][1] = "passtwo";
		data[1][2]= 16;
		data[2][0] = "uthree";
		data[2][1] = "passthree";
		data[2][2]= 17;
		
		return data;
	}
	
	@AfterMethod()
	public void closeApp() {
		System.out.println("Age of the user inside closeApp is: "+ age);
		BrowserFactory.quitBrowser(driver);

	}
	

}
