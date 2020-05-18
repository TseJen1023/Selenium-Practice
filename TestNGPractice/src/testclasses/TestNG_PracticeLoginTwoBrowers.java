package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestNG_PracticeLoginTwoBrowers {
	WebDriver driver ;
	String baseUrl ;
	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		baseUrl = "https://tw.yahoo.com/" ;
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/yang/Desktop/Selenium/geckodriver") ;
			driver = new FirefoxDriver() ;
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
			driver = new ChromeDriver() ;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		driver.get(baseUrl);
	}

	@Test
	public void Test() {
		//  //a[@id='uh-profile']
		WebElement elementLogin = driver.findElement(By.id("uh-profile")) ;
		elementLogin.click();
		WebElement loginText = driver.findElement(By.name("username")) ;
		loginText.sendKeys("nlnlOUO");
		WebElement loginCheck = driver.findElement(By.id("login-signin")) ;
		loginCheck.click();
		
	}
  
	@AfterClass
	public void afterClass() {
	}

}
