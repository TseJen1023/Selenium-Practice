package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver {

	public static void main(String[] args) {
		// http://selenium-release.storage.googleapis.com/index.html
		String baseUrl = "http://www.baidu.com";
		WebDriver driver;
		
        System.setProperty("webdriver.ie.driver", "/home/yang/Desktop/Selenium/IEDriverServer");
		driver = new InternetExplorerDriver();
		driver.get(baseUrl);
	
	
	}

}