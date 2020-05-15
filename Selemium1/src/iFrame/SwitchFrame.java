package iFrame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SwitchFrame {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://jqueryui.com/datepicker" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
	}
	
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		
		driver.switchTo().frame(0) ; //by number, also can by id, by name
		WebElement datepicker = driver.findElement(By.id("datepicker")) ;
		datepicker.click();
		System.out.println("datepicker done") ;
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent() ;
		driver.findElement(By.xpath("//input[@class='ds-input']")).sendKeys("nlnlOUO"); ;
	}
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(10000) ;
		driver.quit();
	}


}
