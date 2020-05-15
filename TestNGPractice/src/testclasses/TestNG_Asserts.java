package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationcode.ClassToBeTested;

public class TestNG_Asserts {
  @Test
  public void testAddNum() {
	  System.out.println("\ntest two number's sum") ;
	  ClassToBeTested test = new ClassToBeTested() ;
	  int result = test.addNum(8, 7) ;
	  Assert.assertEquals(result, 15);
	  System.out.println("\n* success! test complete") ;
  }
  
  @Test
  public void testAddString() {
	  System.out.println("\ntest two string's contact") ;
	  String expectedString = "nlnl OUQ" ;
	  ClassToBeTested test = new ClassToBeTested() ;
	  String result = test.addString("nlnl", "OUO") ;
	  Assert.assertEquals(result, expectedString);
	  System.out.println("\n* success! test complete") ;
	  
  }
  
  @Test
  public void testArrays() {
	  System.out.println("\ntest two Arrays") ;
	  int[] expectedArray = {1,2,3} ;
	  ClassToBeTested test = new ClassToBeTested() ;
	  int[] result = test.getArray() ;
	  Assert.assertEquals(result, expectedArray);
	  System.out.println("\n* success! test complete") ;
  }
}
