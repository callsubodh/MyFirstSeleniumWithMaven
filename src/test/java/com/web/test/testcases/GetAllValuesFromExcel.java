package com.web.test.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetAllValuesFromExcel {
	
	
			@Test
			public void getExcelValues() {
			String src = "C:\\Users\\Subodh\\eclipse-workspace\\SeleniumTutorials\\MyFirstSeleniumWithMaven\\src\\main\\resources\\Login_Credentials.xlsx";
			
			try {
			File f = new File(src);
			
			FileInputStream fis = new FileInputStream(f);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sh = wb.getSheetAt(0);
			
			int rowCount = sh.getLastRowNum();
			
			System.out.println("Row Count is: "+rowCount);
			
			for(int i=0; i<=rowCount;i++) {
				
				System.out.print(sh.getRow(i).getCell(0).getStringCellValue() + " ");
				System.out.println(sh.getRow(i).getCell(1).getStringCellValue());
				
				
			}
			
			}catch(Exception e) {
				
				e.getMessage();
			}
					
	}
	

}
