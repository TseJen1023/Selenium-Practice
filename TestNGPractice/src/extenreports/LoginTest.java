package extenreports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Screenshot;


public class LoginTest {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;

	@BeforeClass
	public void beforeClass() {
	    System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		baseUrl = "https://mail.qq.com";
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify if login successfully");
		driver = new ChromeDriver();
		hp = new HomePage(driver,test);
		test.log(LogStatus.INFO, "Browser started...");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web Application Opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		driver.switchTo().frame("login_frame");
		hp.login("515904568", "a56d456as4d");

		Thread.sleep(3000);
		boolean result = hp.isWelcomeTextPresent();

		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified Login Successfully");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshot.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verified Login failed",imagePath);
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
}