package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementState {

	WebDriver driver ;
	String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://www.google.com" ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() {
		WebElement element = driver.findElement(By.xpath("//*[@id='tsf']//input[@class='gLFyf gsfi']")) ;
		System.out.println("is enabled? " + element.isEnabled()) ;
		element.sendKeys("NLNL");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000) ;
		driver.quit();
		System.out.println("test end") ;
	}

	

}
