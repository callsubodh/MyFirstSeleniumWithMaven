package com.web.test.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.web.test.testcases.UsingListeners;

public class Listeners2 implements ITestListener {
	
	public static WebDriver driver;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("Test case succeeded "+result.getName(), true);
		Reporter.log("Class Name value is: "+result.getClass().toString(), true);
		
		CaptureScreenshot.captureScreen(driver, result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		Reporter.log("Test case failed "+result.getName(), true);
		//CaptureScreenshot.captureScreen(driver, result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("Test case skipped "+result.getName(), true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
