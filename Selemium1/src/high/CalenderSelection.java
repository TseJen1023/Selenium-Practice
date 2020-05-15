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

class CalenderSelection {
	WebDriver driver ;
	String baseUrl ;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver() ;
		baseUrl = "https://www.agoda.com/zh-tw/esunonly" ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize(); 
	}
	
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		
		WebElement elementCheckin = driver.findElement(By.id("olsb-checkIn")) ;
		elementCheckin.click(); 
		System.out.println("check-in date click -> done") ;
		Thread.sleep(3000) ;
		
		WebElement elementInDateSelected = driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//*[@data-month = '4']//*[text()='18']")) ;
		elementInDateSelected.click();
		System.out.println("check-in date detail -> done") ;
		/*
		WebElement elementCheckout = driver.findElement(By.id("olsb-checkOut")) ;
		elementCheckout.click(); 
		System.out.println("check-out date click -> done") ;
		Thread.sleep(3000) ;
		
		WebElement elementOutDateSelected = driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//*[@data-month = '4']//*[text()='30']")) ;
		elementOutDateSelected.click();
		System.out.println("check-out date detail -> done") ;
		Thread.sleep(3000) ;
		
		WebElement searchCheck = driver.findElement(By.id("oneline-searchbox")) ;
		searchCheck.click();
		System.out.println("Search -> done") ;
		Thread.sleep(3000) ;
		*/
	}
	
	@Test
	void test2()throws InterruptedException {
		driver.get(baseUrl);
		
		WebElement elementCheckin = driver.findElement(By.id("olsb-checkOut")) ;
		elementCheckin.click(); 
		System.out.println("check-out date click -> done") ;
		Thread.sleep(3000) ;
		
		WebElement elementCheckOutMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-group ui-datepicker-group-last']//*[@class='ui-datepicker-calendar']")) ;
		List<WebElement> ValidDates = elementCheckOutMonth.findElements(By.xpath("//span[@class='ui-state-default ui-state-active']")) ;
		for(WebElement date : ValidDates) {
			if(date.getText().equals("10")) {
				date.click() ;
				break ;
			}
		}
		System.out.println("check-out date detail -> done") ;
		
		
	} 

	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000) ;
		driver.quit();
	}
}
