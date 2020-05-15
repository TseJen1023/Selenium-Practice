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

class KeyPressDemo2 {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://learn.letskodeit.com/p/practice" ;
		driver.get(baseUrl);
	}
	//must confirm is javascript alert
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		//multiple keys input
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL+"a") ;
		//Thread.sleep(2000);
		
		//multiple keys input
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL,"a")) ;
		//Thread.sleep(2000);
		
		String selectAll = Keys.chord(Keys.CONTROL,"a") ;
		driver.findElement(By.id("openwindow")).sendKeys(selectAll) ;
		Thread.sleep(2000);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
