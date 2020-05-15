package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import get.ElementList;

class IsElementPresentDemo {
	private WebDriver driver ;
	private String baseUrl ;
	private IsElementPresent ep ;
	private IsElementPresent2 ep2;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		driver = new ChromeDriver() ;
		ep = new IsElementPresent(driver) ;
		ep2= new IsElementPresent2(driver);
		baseUrl = "http://letskodeit.teachable.com/pages/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}
	
	@Test
	void test() {
		driver.get(baseUrl);
		boolean existResult = ep.isElementListPresent("name", "id") ;
		System.out.println("Does the element exist? " + existResult) ;
		
		boolean existResult2 = ep2.isElementListPresent2("name", "id") ;
		System.out.println("Does the element exist? " + existResult2) ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
