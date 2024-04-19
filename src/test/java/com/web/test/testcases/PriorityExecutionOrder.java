package com.web.test.testcases;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriorityExecutionOrder {

	@Parameters("varone")
	@Test(priority=2, groups= {"Smoke"})
	public void test1(String enterVar) {
		System.out.println("Starting execution of TEST1: "+enterVar);
	}
	@Test(priority=4, groups= {"Smoke", "Regression"})
	public void test2() {
		System.out.println("Starting execution of TEST2");
	}
	@Test(priority=1, groups= {"Regression", "UAT"})
	public void test3() {
		System.out.println("Starting execution of TEST3");
	}

	@Test(priority=5)
	public void test4() {
		System.out.println("Starting execution of TEST4");
	}
	@Test(priority=0)
	public void test5() {
		System.out.println("Starting execution of TEST5");
	}
	@Test(priority=3)
	public void test6() {
		System.out.println("Starting execution of TEST6");
	}
	@Test(priority=7, groups= {"Regression"})
	public void test7() {
		System.out.println("Starting execution of TEST7");
	}
	@Test(priority=8, groups= {"UAT"})
	public void test8() {
		System.out.println("Starting execution of TEST8");
	}

}
