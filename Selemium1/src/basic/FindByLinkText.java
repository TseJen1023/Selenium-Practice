package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByLinkText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver();
		String baseUrl = "https://tw.yahoo.com";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		driver.findElement(By.partialLinkText("新聞")).click();
	}

}
