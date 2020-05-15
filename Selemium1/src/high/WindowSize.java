package high;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WindowSize {

	private WebDriver driver ;
	private String baseUrl ;
	private JavascriptExecutor js ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		//change driver type
		js = (JavascriptExecutor)driver ;
		
		baseUrl = "https://tw.yahoo.com" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		//driver.manage().window().maximize(); 	
	}
	@Test
	public void testJavascriptExecution() throws Exception{
		driver.get(baseUrl) ;
		//open google page
		js.executeScript("window.location = 'https://tw.yahoo.com' ;") ;
		Thread.sleep(3000) ;
		//Size of window
		long height = (long)js.executeScript("return window.innerHeight ;") ;
		long width  = (long)js.executeScript("return window.innerWidth ;" ) ;
		
		System.out.println("window's height is " + height + ", and width is " + width) ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}

	

}
