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

class ExplicitWaitDemo {
	WebDriver driver ;
	String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://tw.yahoo.com" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
		
	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl) ;
		WebElement login = driver.findElement(By.id("uh-profile")) ;
		login.click();
		//driver.findElement(By.id("login-username")).sendKeys("nlnlQAQ"); 
		//EXPLICIT WAIT -> WebDriverWait wait = new WebDriverWait(WebDriver, wait time in seconds) ;
		WebDriverWait wait = new WebDriverWait(driver,3) ;
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))) ; 
		emailField.sendKeys("bbbb87YA");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	
}
