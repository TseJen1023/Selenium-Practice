package actionsbuttons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class KeyPressDemo1 {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://login.yahoo.com/config/login?.src=twfp&.lang=zh-Hant-TW&.intl=tw&.done=https://tw.yahoo.com/" ;
		driver.get(baseUrl);
	}
	//must confirm is javascript alert
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("login-username")).sendKeys("gcobs61905");
		Thread.sleep(2000);
		
		//press ENTER to login
		driver.findElement(By.id("login-signin")).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("login-username")).sendKeys(Keys.TAB);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
