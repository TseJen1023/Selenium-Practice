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
import org.openqa.selenium.support.ui.Select;

class DropDownSelect {

	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "http://letskodeit.teachable.com/pages/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		System.out.println("Setup done") ;
	}
	
	@Test
	void testDropdown() throws Exception {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect")) ;
		Select sel = new Select(element) ;
		
		Thread.sleep(2000);
		System.out.println("Select BMW by value") ;
		sel.selectByValue("bmw");
		
		Thread.sleep(2000);
		System.out.println("Select Benz by index") ;
		sel.selectByIndex(1);
		
		Thread.sleep(2000);
		System.out.println("Select Honda by visible text") ;
		sel.selectByVisibleText("Honda");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options") ;
		List<WebElement> options = sel.getOptions() ;
		int size = options.size();
		for(int i = 0 ; i < size ; i++) {
			String optionText = options.get(i).getText() ;
			System.out.println(optionText) ;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
