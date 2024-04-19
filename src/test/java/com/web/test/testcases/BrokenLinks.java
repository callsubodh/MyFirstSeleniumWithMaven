package com.web.test.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.helper.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.web.test.utility.BaseClass;
import com.web.test.utility.GetChromeSwitches;
import com.web.test.utility.PropertiesReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public WebDriver driver;	
	PropertiesReader propread = new PropertiesReader();
	String browser = propread.getBrowserVal();

	@Test
	public void getBrokenLinks() throws InterruptedException {


		if(browser.equalsIgnoreCase("chrome")) {
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*", "headless");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "--enable-automation"));
			options.addArguments("start-fullscreen");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");*/
			
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver(GetChromeSwitches.browserChromeOptions());

		}else
		{
			System.out.println("Browser not supported");
			//Reporter.log("Browser "+browser+" not supported");
			System.exit(0);
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		//get the url from the Properties File
		driver.get(propread.getAppURL());	

		List<WebElement> ele_link = driver.findElements(By.tagName("a"));

		for(WebElement ele: ele_link) {

//			System.out.println("Urls in the page:" +ele.getAttribute("href"));
			String url = ele.getAttribute("href");
			verifyUrl(url);

		}

		Thread.sleep(3000);
		driver.quit();
	}

	public void verifyUrl(String linkUrl) {

		try {
			URL url = new URL(linkUrl);		
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(3000);
			conn.connect();

			if(conn.getResponseCode()==200) {
				Thread.sleep(1000);
				System.out.println(linkUrl +" - "+ conn.getResponseMessage());

			}else if(conn.getResponseCode()== conn.HTTP_NOT_FOUND) {	
				System.out.println(linkUrl +" - "+conn.getResponseMessage() +" - "+ conn.HTTP_NOT_FOUND);

			}else if(conn.getResponseCode() == conn.HTTP_BAD_GATEWAY) {
				System.out.println(conn.getResponseCode() +" - "+ conn.getResponseMessage() +" - "+ conn.HTTP_BAD_GATEWAY);
			}else {
				System.out.println("URL is not valid.");
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} 

	}

}
