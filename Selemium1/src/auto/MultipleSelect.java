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

class MultipleSelect {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		driver = new ChromeDriver() ;
		baseUrl = "http://letskodeit.teachable.com/pages/practice" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	void test() throws InterruptedException {
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by value") ;
		sel.selectByValue("apple");
		Thread.sleep(2000);
		System.out.println("De-select Apple by value") ;
		sel.deselectByValue("apple");
		
		
		Thread.sleep(2000);
		System.out.println("Select Orange by index") ;
		sel.selectByIndex(1);
		
		Thread.sleep(2000);
		System.out.println("Select Peach by visible text") ;
		sel.selectByVisibleText("Peach");
		
		Thread.sleep(2000);
		System.out.println("Print all selected options") ;
		List <WebElement> selectOptions = sel.getAllSelectedOptions() ;
		for(WebElement option : selectOptions) {
			System.out.println(option.getText()) ;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("done") ;
	}

	

}
