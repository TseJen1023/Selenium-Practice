package waittypes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExplicitWaitWithUtilityDemo {
	private WebDriver driver ;
	private String baseUrl ;
	private WaitTypes wait ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://tw.yahoo.com" ;
		wait = new WaitTypes(driver) ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
		
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl) ;
		WebElement login = driver.findElement(By.id("uh-profile")) ;
		login.click();
		WebElement emailField = wait.waitForElement(By.id("login-username"), 2) ;
		emailField.sendKeys("bbbb87YA");
		wait.clickWhenReady(By.id("login-signin"), 3) ;
		System.out.println("done") ;
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
	}
}