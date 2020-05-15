package testclasses;

import org.testng.annotations.Test;

import applicationcode.ClassToBeTested;

public class TestAnnotation {
//according to alphabet order to run the testcase, as below a < t, 1 < 3
  @Test
  public void test1() {
	  ClassToBeTested test = new ClassToBeTested() ;
	  int result = test.addNum(7, 18) ;
	  System.out.println("this is a test1: " + result) ;
  }
  
  @Test
  public void atest2() {
	  ClassToBeTested test = new ClassToBeTested() ;
	  int result = test.addNum(0, 100) ;
	  System.out.println("this is a test2: " + result) ;
  }
  
  @Test
  public void test3() {
	  ClassToBeTested test = new ClassToBeTested() ;
	  int result = test.addNum(-7, 18) ;
	  System.out.println("this is a test3: " + result) ;
  }
}
