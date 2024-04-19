package com.web.test.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class CurrentDateAddition {

	public static String getDate() {		

		Date dte = new Date();		
		DateFormat df = new SimpleDateFormat("dd");

		//System.out.println("Date value is: "+dte);			
		System.out.println(df.format(dte));

		return df.format(dte);
	}

	public static String addToCurrentDate() {		

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date dte = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dte); // Set today's date
		c.add(Calendar.DATE, 5); // Adding 5 days
		c.add(Calendar.MONTH, 5); // Adding 5 months
		c.add(Calendar.YEAR, -2); // Subtracting 2 years
		String output = sdf.format(c.getTime());
		System.out.println(output);

		return output;
	}
/*
	public static void main(String[] args) {
		getDate();
		System.out.println("Without storing the date value in variable: "+addToCurrentDate());
		String updatedDate = addToCurrentDate();
		System.out.println("The updated date is: "+updatedDate);
	}*/

}
