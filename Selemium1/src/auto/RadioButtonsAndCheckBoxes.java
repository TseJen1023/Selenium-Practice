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

class RadioButtonsAndCheckBoxes {
	WebDriver driver ;
	String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		driver.manage().window().maximize() ;
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio")) ; 
		bmwRadioButton.click() ;
		System.out.println("bmwRadioButton done") ;
		//Thread.sleep(2000) ;
		
		WebElement benzCheckButton = driver.findElement(By.id("benzcheck")) ; 
		benzCheckButton.click() ;
		System.out.println("benzCheckButton done") ;
		//Thread.sleep(2000) ;
		
		System.out.println("Is bmw radio button selected? " + bmwRadioButton.isSelected()) ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		//Thread.sleep(5000) ;
		//driver.quit();
	}

	

}
