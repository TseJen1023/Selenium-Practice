package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import applicationcode.ClassToBeTested;

public class TestNGSoftAsserts {
	@Test
	  public void testAddNum() {
		  SoftAssert soft = new SoftAssert() ;
		  System.out.println("\nsoft test two number's sum") ;
		  ClassToBeTested test = new ClassToBeTested() ;
		  int result = test.addNum(8, 7) ;
		  soft.assertEquals(result, 1);
		  System.out.println("* Assert 1 done") ;
		  soft.assertEquals(result, 15);
		  System.out.println("* Assert 2 done") ;
		  soft.assertAll(); //check error exists
		  
		  /*
		  Assert.assertEquals(result, 1) ; //fail
		  System.out.println("* Assert 1 done") ;
		  Assert.assertEquals(result, 15); //it will not work
		  System.out.println("* Assert 2 done") ;
		  */
		  
	  }
}
