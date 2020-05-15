package applicationcode;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="inputs")
	public Object[][] getData(){
		return new Object[][]{
			{"Apple","red"},
			{"WaterMelon","green"},
			{"Orange","yellow"}
		};
	}

}
