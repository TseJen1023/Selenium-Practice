package actionsbuttons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class DragAndDropActions {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://jqueryui.com/droppable/" ;
		driver.get(baseUrl);
	}
	//must confirm is javascript alert
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		//switch to iFrame
		driver.switchTo().frame(0) ;
		WebElement fromElement = driver.findElement(By.id("draggable")) ;
		WebElement toElement   = driver.findElement(By.id("droppable")) ;
		
		Actions action = new Actions(driver) ;
		//drag and drop
		//action.dragAndDrop(fromElement, toElement).build().perform(); 
		//click and hold, move to element, release, build and perform
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform(); 
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}



}
