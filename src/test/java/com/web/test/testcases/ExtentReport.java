package com.web.test.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	ExtentSparkReporter reporter;
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	public void getReport() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.out.println("Using Chrome");
		driver = new ChromeDriver();
	
	//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.google.com");
	
	String title = driver.getTitle();
	
	Reporter.log(title, true);
	
	reporter = new ExtentSparkReporter("./test_output/report.html");
	report = new ExtentReports();
	report.attachReporter(reporter);

	
	logger = report.createTest("This is my first Extent Report Test")
			.log(Status.INFO, "This is my first log info in extent report");
	
	if(title.equalsIgnoreCase("Google")) {
		
		Assert.assertEquals(title, "Google");
		Reporter.log("Inside Assert if", true);
		
		logger.log(Status.PASS, "Assert passed");
	
	}else {
		
		logger.log(Status.FAIL, "Assert Failed");
		Reporter.log("Inside Assert else: "+title, true);

	}
	report.flush();
	driver.quit();
}
}
