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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.ScreenShot ;

public class TestNG_ScreenShot {
	WebDriver driver ;
	  String baseUrl ;
	  ExtentReports report ;
	  ExtentTest test ;
	  @BeforeClass
	  public void beforeClass() {
		  baseUrl = "https://ecvip.pchome.com.tw/login/v3/login.htm?rurl=https%3A%2F%2Fecvip.pchome.com.tw%2Fweb%2Forder%2Fall" ;
		  System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		  
		  report = new ExtentReports("/home/yang/Desktop/Selenium/Report/logintext.html") ; //directory
		  test = report.startTest("Verify login success or not.") ;
		  
		  driver = new ChromeDriver() ;
		  test.log(LogStatus.INFO, "Browser started");
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
		  test.log(LogStatus.INFO, "Browser maximize");
		  driver.manage().window().maximize();
		  test.log(LogStatus.INFO, "Web Application open");
		  driver.get(baseUrl);
	  }

	  @Test
	  public void Test() throws InterruptedException {
		  WebElement loginAcc = driver.findElement(By.id("loginAcc")) ;
		  loginAcc.sendKeys("gcobs61905@gmail.com");	  
		  //loginAcc.sendKeys("Put Account here");
		  test.log(LogStatus.INFO, "Enter user name");
		  WebElement loginPwd = driver.findElement(By.id("loginPwd")) ;
		  loginPwd.sendKeys("Put Password here") ;
		  test.log(LogStatus.INFO, "Enter password");
		  WebElement clickLogin = driver.findElement(By.id("btnLogin")) ;
		  clickLogin.click(); 
		  test.log(LogStatus.INFO, "Click login button");
		  
		  Thread.sleep(3000);
		  
		  WebElement welcomeText = null ;
		  try {
			  welcomeText = driver.findElement(By.xpath("//*[@id='login_info']")) ;
		  }catch(NoSuchElementException e) {
			  System.out.println(e.getMessage()) ;
		  }
		  //CHECK welcomeText exist or not
		  Assert.assertTrue(welcomeText !=null);
		  test.log(LogStatus.PASS, "login success");
	  }
	  
	  @AfterMethod
	  public void tearDown(ITestResult testResult) throws IOException{
		  if(testResult.getStatus() == ITestResult.FAILURE) {
			  ScreenShot.takeScreenShot(driver, testResult.getName()) ;
		  }
		  driver.quit();
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
		  report.endTest(test);
		  report.flush();
	  }

	}
