package actionsbuttons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class SliderActions {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://jqueryui.com/slider/" ;
		driver.get(baseUrl);
	}
	//must confirm is javascript alert
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.switchTo().frame(0) ;
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span")) ;
		
		Actions action = new Actions(driver) ;
		action.dragAndDropBy(element, 100, 0).perform(); 
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
