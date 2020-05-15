package testclasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import applicationcode.TestData ;

public class TestNG_DataProviders {
	/*
	@DataProvider(name="inputs")
	public Object[][] getData(){
		return new Object[][]{
			{"Apple","red"},
			{"WaterMelon","green"},
			{"Orange","yellow"}
		};
	}
	*/
	@Test(dataProvider="inputs",dataProviderClass=TestData.class) 
	public void testMethod1(String input1, String input2) {
		System.out.println("Input 1: " + input1);
		System.out.println("Input 2: " + input2);
	}
}