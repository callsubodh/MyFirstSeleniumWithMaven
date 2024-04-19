package com.web.test.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public static void captureScreen(WebDriver driver, String sshotName) {
		
		String sspath = System.getProperty("user.dir")+"/Screenshots/"+sshotName+"_"+CurrentDateFormat.getDate()+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File(sspath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
	//The below method is used in Extent Reports where we need to return a screenshot path
	public static String captureScreenWithPath(WebDriver driver, String sshotName) {

		String sspath = System.getProperty("user.dir")+"/Screenshots/"+sshotName+"_"+CurrentDateFormat.getDate()+".png";

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(sspath));
		} catch (Exception e) {
			e.getMessage();
		}
		return sspath;	
	}

}
