package testclasses;

import org.testng.annotations.Test;

import base.BaseTestSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Class2 extends BaseTestSuite {
	
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass2 -> BeforeClass");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass2 -> AfterClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass2 -> beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass2 -> afterMethod");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\n TestNG_TestClass2 -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\n TestNG_TestClass2 -> testMethod2");
	}

}
