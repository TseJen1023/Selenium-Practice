package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.google.com" ;
		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		driver = new ChromeDriver() ;
		driver.get(baseUrl);
	}

}
