package com.web.test.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo {

	@AfterTest
	public void testAfterTest() {

		System.out.println("--This is After Test--");
	}

	@AfterClass
	public void testAfterClass() {

		System.out.println("--This is After Class--");
	}

	@BeforeMethod
	public void testBeforeMethod() {

		System.out.println("--This is Before Method--");
	}

	@AfterMethod
	public void testAfterMethod() {

		System.out.println("--This is After Method--");
	}

	@Test
	public void testOne() {

		System.out.println("--This is TestOne--");
	}

	@Test
	public void testTwo() {

		System.out.println("--This is TestTwo--");
	}

	@Test
	public void testThree() {

		System.out.println("--This is TestThree--");
	}
	@BeforeTest
	public void testBeforeTest() {

		System.out.println("--This is Before Test--");
	}

	@BeforeClass
	public void testBeforeClass() {

		System.out.println("--This is Before Class--");
	}
		
	@AfterSuite
	public void testAfterSuite() {

		System.out.println("--This is After Suite--");
	}
	
	@BeforeSuite
	public void testBeforeSuite() {

		System.out.println("--This is Before Suite--");
	}
}
