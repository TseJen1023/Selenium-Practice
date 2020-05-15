package pomtestcase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageclasses.SearchPageFactory;

class FrameworkTestCase {
	WebDriver driver ;
	String baseUrl ;
	SearchPageFactory searchPage ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;

		driver = new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		baseUrl = "https://www.expedia.com.tw/flights" ;
		
		searchPage = new SearchPageFactory(driver) ;
		driver.get(baseUrl);
	}

	@Test
	void test() throws Exception  {
		searchPage.clickFlightTab() ;
		searchPage.setStartCity("Taipei");
		searchPage.setDestinationCity("Tokyo");
		searchPage.setDepartureDate("2020/9/8");
		searchPage.clickSearchButton(); 
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
