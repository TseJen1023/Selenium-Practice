package pomtestcase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageclasses.SearchPage;

class PageObjectModel {
	// /home/yang/Desktop/javacode/Selemium1/src/pageclasses/SearchPage.java
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://www.expedia.com.tw/Flights" ;
	}

	@Test
	void test() {
		driver.get(baseUrl);
		SearchPage.fillStarterTextBox(driver, "Taipei");
		SearchPage.fillDestinationTextBox(driver, "Osaka");
		SearchPage.fillStarterDateTextBox(driver, "2020/05/15");
		SearchPage.arriveDateTextBox(driver).clear();
		SearchPage.fillArriveDateTextBox(driver, "2020/05/20");
		
		
		
		SearchPage.clickSearchButton(driver);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		//Thread.sleep(2000);
		//driver.quit();
	}

	

}
