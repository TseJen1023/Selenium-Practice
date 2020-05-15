package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementsList {
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
		// set a list set
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]")) ;
		//List<WebElement> radioButtons = driver.findElements(By.name("cars")) ;
		System.out.println("elements found") ;
		
		boolean isCheck = false ;
		int size = radioButtons.size() ;
		System.out.println("size of set is " + size ) ;
		for(int i = 0 ; i < size ; i++) {
			isCheck = radioButtons.get(i).isSelected() ;
			if(!isCheck) {
				radioButtons.get(i).click() ;
				Thread.sleep(2000);
			}
			System.out.println("loop " + i + " is done.") ;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("test is over") ;
		Thread.sleep(2000);
		driver.quit();
	}

	

}
