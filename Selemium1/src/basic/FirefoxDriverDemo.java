package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {
	public static void main(String[] args) {
		//value is the path of gecko.driver
		System.setProperty("webdriver.gecko.driver","/home/yang/Desktop/Selenium/geckodriver") ;
		WebDriver driver = new FirefoxDriver() ;
		String baseUrl = "https://www.google.com" ;
		driver.get(baseUrl); 
	}

}
