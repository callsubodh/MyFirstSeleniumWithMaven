package com.web.test.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class FutureDates {

		@Test(description="This is for Future Date")
		public void testFutureDate() {
			getDate();
		}
		
		
		public static String getDate() {		
			
			Date dte = new Date();			
			DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
			
			Calendar currDate = Calendar.getInstance();
			currDate.setTime(dte);
			currDate.add(Calendar.DATE, 5);
			
			String output_date = df.format(currDate.getTime());
			System.out.println(output_date);
			
			return output_date; 
			
		}

}
