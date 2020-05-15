package testclasses;

import org.testng.annotations.Test;

import base.BaseTestSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Class1 extends BaseTestSuite{
	
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass1 -> BeforeClass");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass1 -> AfterClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass1 -> beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass1 -> afterMethod");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\n TestNG_TestClass1 -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\n TestNG_TestClass1 -> testMethod2");
	}
}