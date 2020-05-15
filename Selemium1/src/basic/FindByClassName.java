package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver();
		String baseUrl = "https://www.books.com.tw/?loc=tw_logo_001";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		//too many same class, cannot run. 
		driver.findElement(By.className("btn  regular-button  popup-button popup-login")).click();
		//driver.findElement(By.className("leaf")).click();
		
		
	}

}

