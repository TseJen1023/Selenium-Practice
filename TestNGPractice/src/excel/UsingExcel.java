package excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.Constants;
import excel.ExcelUtility;

public class UsingExcel {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		//iframe
		driver.switchTo().frame("x-URS-iframe");
		//excel location
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
	}

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
		return testData;
	}

	@Test(dataProvider = "loginData")
	public void testUsingExcel(String username, String password) throws Exception {
		WebElement element = driver.findElement(By.xpath("//input[@data-placeholder='蚘眊梛瘍麼忒儂瘍']"));
		element.clear();
		element.sendKeys(username);
		driver.findElement(By.xpath("//input[@data-placeholder='躇鎢']")).sendKeys(password);
		driver.findElement(By.id("dologin")).click();
		Thread.sleep(2000);

		boolean result =driver.findElements(By.xpath("//div[text()='梛瘍麼躇鎢渣昫']")).size()!=0;
		Assert.assertTrue(result);
	}

	@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
	}
}