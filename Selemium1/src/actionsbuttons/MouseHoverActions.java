package actionsbuttons;

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
import org.openqa.selenium.interactions.Actions;

class MouseHoverActions {
	WebDriver driver ;
	String baseUrl = "https://learn.letskodeit.com/p/practice" ;
	JavascriptExecutor jss ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://learn.letskodeit.com/p/practice" ;
		
	}

	@Test
	void test()throws Exception  {
		driver.get(baseUrl);
		jss.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
		WebElement mainElement = driver.findElement(By.xpath("//button[@id='mousehover']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform(); //.perform to hover mouse
		WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']")) ;
		action.moveToElement(subElement).click().perform(); ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}

	

}
