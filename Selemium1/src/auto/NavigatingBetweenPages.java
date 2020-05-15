package auto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class NavigatingBetweenPages {
	
	WebDriver driver ;
	String baseUrl ;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://tw.yahoo.com" ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}
	
	@Test
	void test() throws InterruptedException {
		//get the title of baseUrl now
		driver.get(baseUrl);
		String title = driver.getTitle() ;
		System.out.println("page title is " + title ) ;
		
		//navigate to login page
		String currentUrl = driver.getCurrentUrl() ;
		System.out.println("current url is " + currentUrl) ;
		String ulrToNavigate = "https://login.yahoo.com/config/login?.src=twfp&.lang=zh-Hant-TW&.intl=tw&.done=https://tw.yahoo.com/" ;
		driver.navigate().to(ulrToNavigate);
		System.out.println("navigate to login page") ;
		
		//back to the yahoo home page
		Thread.sleep(3000);
		driver.navigate().back() ;
		System.out.println("back to yahoo home page") ;
		
		//go to the login page
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("forward to login page") ;
		
		//back to the yahoo home page
		Thread.sleep(3000);
		driver.navigate().back() ;
		System.out.println("back to yahoo home page again") ;
		
		//refresh the page
		currentUrl = driver.getCurrentUrl() ;
		System.out.println("current url is " + currentUrl) ;
		driver.navigate().refresh();
		System.out.println("refresh the page") ;
		driver.get(currentUrl) ;
		System.out.println("get currentUrl") ;
		System.out.println("current url is " + currentUrl) ;
		
		String pageSource = driver.getPageSource() ;
		System.out.println(pageSource) ;
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
