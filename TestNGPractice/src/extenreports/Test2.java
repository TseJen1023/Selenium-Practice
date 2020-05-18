package extenreports;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Test2 {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Test2-->Class verification");
	}
	
	@Test
	public void testMethod() {
		test.log(LogStatus.INFO, "Test2--> Test Method started...");
		test.log(LogStatus.INFO, "Test2--> Test Method continuing...");
		test.log(LogStatus.INFO, "Test2--> Test Method end...");
		
	}

	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush(); //刷新
		
	}
}