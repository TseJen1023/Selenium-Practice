package testclasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_ReportsAndLogs {
	
	@BeforeClass
	public void setUp() {
		Reporter.log("TestNG_ReportsAndLogs -> setUp", true);
	}
	
	@AfterClass
	public void cleanUp() {
		Reporter.log("estNG_ReportsAndLogs -> cleanUp", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> beforeMethod", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> aftermethods", true);
	}
	
	@Test
	public void testMethod1() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod1", true);
	}
	
	@Test
	public void testMethod2() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod2", true);
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods={ "testMethod2" })
	public void testMethod3() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod3", true);
	}
}