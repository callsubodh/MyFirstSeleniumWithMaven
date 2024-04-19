package MyFirstTestNGPackage;

import org.openqa.selenium.WebDriver;
import PageObjects.Guru99LoginPageObject;
import Utility.BrowserFactory;

public class Guru99LoginPageTest {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserFactory bf = new BrowserFactory(driver);
		bf.startApplication("chrome", "https://demo.guru99.com/test/login.html");
		System.out.println("Title of the page is: " + driver.getTitle());
		
		Guru99LoginPageObject loginPageObj = new Guru99LoginPageObject(driver);
		loginPageObj.txtEmailAddress.sendKeys("admin@admin.com");
		loginPageObj.lnkForgotPwd.sendKeys("password");

	}

}
