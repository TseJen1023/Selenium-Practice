package high;

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

import waittypes.WaitTypes;

class AutoComplete {
	private WebDriver driver ;
	private String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://www.expedia.com.tw" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
		
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl) ;
		String searchText = "京都站\n" + 
				            "京都, 京都 (府), 日本\n" + 
				            "車站" ;
		String partialText = "京" ;
		WebElement text = driver.findElement(By.id("hotel-destination-hp-hotel")) ;
		text.sendKeys(partialText);
		System.out.println("partial text send complete") ;
		WebElement element = driver.findElement(By.id("typeaheadDataPlain")) ;
		List<WebElement> results = element.findElements(By.tagName("li")) ;
		
		int size = results.size() ;
		System.out.println("size of results is " + size) ;
		//list the all text in box
		for(int i = 0 ; i < size ; i++) {
			System.out.println(results.get(i).getText()) ;
			System.out.println("*******************") ;
		}
		Thread.sleep(3000);
		//search and click the text we want
		for(WebElement result: results) {
			if(result.getText().equals(searchText)) {
				System.out.println("searchText is found: " + result.getText()) ;
				result.click();
				break ;
			}
		}
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
}