package com.web.test.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SetExcelData {
	
	@Test
	public void readExcel() throws Exception {
	
		File src = new File("C:\\Users\\Subodh\\eclipse-workspace\\SeleniumTutorials\\MyFirstSeleniumWithMaven\\src\\main\\resources\\Login_Credentials.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);		
		
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		
		String username = sheet1.getRow(1).getCell(0).getStringCellValue();
		
		System.out.println("Username is: "+username);
		
		wb.close();

}
}

