package com.web.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.web.test.pages.LoginCRMPage;
import com.web.test.utility.BaseClass;
import com.web.test.utility.DetectWebElement;

public class GetBrowserValFromSysEnv2 extends BaseClass {

	@Test(groups={"Regression"})	
	public void firstTest() {
		
		logger = report.createTest("Login to CRM Page");
		LoginCRMPage loginPage = PageFactory.initElements(driver, LoginCRMPage.class);
		
		//Reading property values from a properties file
		loginPage.loginToCRM(propread.getEmailAddress(), propread.getPassword());
		logger.info("Entered the login credentials and logged in successfully.");
		
		String sysName = propread.getPropertiesData("full_name");
		
		Assert.assertEquals(sysName, "Subodh Koka");
		Assert.assertNotNull(sysName, "Email field is not empty");
		logger.pass("Logged in successfully...");

	}

}

