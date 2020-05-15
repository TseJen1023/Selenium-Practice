package get;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class GenericMethodsDemo {
	private WebDriver driver ;
	private String baseUrl ;
	private GenericMethods gm ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		driver = new ChromeDriver() ;
		gm = new GenericMethods(driver) ;
		baseUrl = "http://letskodeit.teachable.com/pages/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}

	@Test
	void test() {
		driver.get(baseUrl);
		WebElement element = gm.getElement("name", "id") ;
		element.sendKeys("CheckSendBox");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}

}
