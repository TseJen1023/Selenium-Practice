package actionsbuttons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class KeyPressDemo3 {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://learn.letskodeit.com/p/practice" ;
	}
	//must confirm is javascript alert
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		Actions action = new Actions(driver) ;
		//keyDown -> keyUp -> perform
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
