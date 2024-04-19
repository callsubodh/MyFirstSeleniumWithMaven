package com.web.test.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot_StandAlone {
	
	/*public static void captureScreen(WebDriver driver, String sshotName) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+sshotName+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}*/
	
	public void captureScreenshot(WebDriver driver) throws Exception {

		//driver = BrowserFactory.startApp(driver, "chrome", "http://www.facebook.com");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);	

		FileUtils.copyFile(src, new File("./Screenshots/"+this.getClass()+"_"+Thread.currentThread().getStackTrace()[1].getMethodName()+"_"+CurrentDateFormat.getDate()+".png"));

	}

}
