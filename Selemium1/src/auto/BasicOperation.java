package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BasicOperation {
	WebDriver driver ;
	String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://www.agoda.com/zh-tw/esunonly" ; 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}
		
	@Test
	void test() {
		//fail("Not yet implemented");
		driver.get(baseUrl);
		driver.findElement(By.id("sign-in-btn")).click() ;
		System.out.println("press the login button -> done") ;
		
		driver.findElement(By.xpath("//form[@class='EmailSignInPanel']//input[@name='email']")).clear();
		driver.findElement(By.xpath("//form[@class='EmailSignInPanel']//input[@name='password']")).clear();
		System.out.println("clear done") ;
		driver.findElement(By.xpath("//form[@class='EmailSignInPanel']//input[@name='email']")).sendKeys("123@gmail.com");
		driver.findElement(By.xpath("//form[@class='EmailSignInPanel']//input[@name='password']")).sendKeys("Aa456");
		System.out.println("account and password -> done") ;
	}
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	

}
