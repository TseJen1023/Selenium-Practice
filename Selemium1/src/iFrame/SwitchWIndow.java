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

class SwitchWindow{
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://learn.letskodeit.com/p/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
	}
	
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		/* cannot get the window we want
		WebElement openWindow = driver.findElement(By.id("openwindow")) ;
		openWindow.click() ;
		WebElement searchBox = driver.findElement(By.id("search-courses")) ;
		searchBox.sendKeys("nlnlOUO");
		*/
		
		//get the main window
		String parentHandle = driver.getWindowHandle() ;
		System.out.println("Main window is " + parentHandle) ;
		
		//search for button of "open new window" 
		WebElement openWindow = driver.findElement(By.id("openwindow")) ;
		openWindow.click() ;
		
		//get the whole window handles, list all
		Set<String> handles = driver.getWindowHandles() ;
		System.out.println("List the all windows now: ") ;
		for(String handle : handles) {
			System.out.println(handle) ;
		}
		
		//switch window handle, and do search.
		for(String handle : handles) {
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle) ;
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses")) ;
				searchBox.sendKeys("nlnlOUO");
				Thread.sleep(3000) ;
				driver.close() ; //only close the current handle
				break ;
			}
		}
		
		//switch to parent handle
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Success"); 
	}
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}


}
