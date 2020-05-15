package iFrame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SwitchAlert {
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
	void test1() throws InterruptedException {
		//alert
		driver.findElement(By.id("name")).sendKeys("nlnlOUO");
		driver.findElement(By.id("alertbtn")).click(); 
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert() ;
		alert.accept() ;
		
	}
	
	@Test
	void test2() throws InterruptedException {
		driver.get(baseUrl);
		//confirm
		driver.findElement(By.id("name")).sendKeys("nlnlOUO");
		driver.findElement(By.id("confirmbtn")).click(); 
		Thread.sleep(3000);
		
		Alert confirm = driver.switchTo().alert() ;
		confirm.dismiss(); //confirm.accept() 
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
