package com.web.test.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WriteIntoExcel {
	
	@Test
	public void writeIntoExcel() throws Exception {
	
		String excelPath="C:\\Users\\Subodh\\eclipse-workspace\\SeleniumTutorials\\MyFirstSeleniumWithMaven\\src\\main\\resources\\Login_Credentials.xlsx";
		File src = new File(excelPath);
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);		
		
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		
		sheet1.getRow(1).createCell(1).setCellValue("Status");		
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
		
		Reporter.log("This is similar to sysout except if it will also be reported in logs file.", true);
		
		String userDirectory_value = System.getProperty("user.dir");
		
		Reporter.log("UserDirectory value is "+ userDirectory_value, true);
		
		Reporter.log("Environment value is: "+ System.getenv("Java_Home"), true);

}
}

