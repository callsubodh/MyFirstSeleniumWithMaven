package com.web.test.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelData {

	XSSFWorkbook wb;
	
	public ExcelData(String excelPath) {

		try {
			File src = new File(excelPath);			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}		
		
	}
	
	public String getExcelStringValues(String shName) {		
		
		String sh = wb.getSheet(shName).getRow(0).getCell(1).getStringCellValue();
		
		Reporter.log("String value is "+sh, true);
		
		return sh;
	}
	
	public double getExcelNumericValues(String shName) {		
		
		double sh = wb.getSheet(shName).getRow(0).getCell(1).getNumericCellValue();
		
		Reporter.log("Numeric value is "+sh, true);
		
		return sh;
	}

}
