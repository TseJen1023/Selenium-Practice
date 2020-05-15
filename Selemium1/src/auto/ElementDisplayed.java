package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementDisplayed {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		driver = new ChromeDriver() ;
		baseUrl = "http://letskodeit.teachable.com/pages/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
		//System.out.println("setUp() done") ;
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement textBox = driver.findElement(By.id("displayed-text")) ;
		System.out.println("Is visible now? " + textBox.isDisplayed()) ;
		
		Thread.sleep(2000);
		WebElement hideButton = driver.findElement(By.id("hide-textbox")) ;
		hideButton.click();
		System.out.println("hide button click") ;
		System.out.println("Is visible now? " + textBox.isDisplayed()) ;
		
		Thread.sleep(2000);
		WebElement showButton = driver.findElement(By.id("show-textbox")) ;
		showButton.click();
		System.out.println("show button click") ;
		System.out.println("Is visible now? " + textBox.isDisplayed()) ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}

	

}
