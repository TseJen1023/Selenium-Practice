package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_BeforeClassAnnotation {
  @BeforeClass
  public void beforeClass() {
	  //at the begin
	  System.out.println("BeforeClass") ;
  }
  @AfterClass
  public void afterClass() {
	  //at the end
	  System.out.println("AfterClass") ;
  }  
  
  @BeforeMethod
  public void beforeMethod() {
	  //before every testMethod
	  System.out.println("BeforeMethod") ;
  }
  @AfterMethod
  public void afterMethod() {
	  //after every testMethod
	  System.out.println("AfterMethod") ;
  }
	
	
  @Test
  public void testMethod1() {
	  System.out.println("testMethod1") ;
  }
  @Test
  public void testMethod2() {
	  System.out.println("testMethod2") ;
  }
  

  

}
