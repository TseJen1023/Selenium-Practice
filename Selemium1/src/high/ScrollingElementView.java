package high;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ScrollingElementView {

	private WebDriver driver ;
	private String baseUrl ;
	private JavascriptExecutor js ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		//change driver type
		js = (JavascriptExecutor)driver ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 	
	}
	@Test
	public void testJavascriptExecution() throws Exception{
		js.executeScript("window.location = 'https://tw.buy.yahoo.com/' ;") ;
		Thread.sleep(2000);
		
		//scrolling down
		js.executeScript("window.scrollBy(0,5000);") ;
		System.out.println("done1") ;
		Thread.sleep(2000);
		//scrollong up
		js.executeScript("window.scrollBy(0,-5000);") ;
		System.out.println("done2") ;
		Thread.sleep(2000);
		
		//scrolling to we want
		WebElement element = driver.findElement(By.xpath("//*[@class='YouMayLike__youMayLike___2zK1Q']")) ;
		js.executeScript("argument[0].scrollIntoView(true) ;", element) ;
		System.out.println("done3") ;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-200);") ;
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}

	

}
