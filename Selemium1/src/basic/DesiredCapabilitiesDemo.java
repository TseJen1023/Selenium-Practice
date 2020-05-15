package basic;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver","/home/yang/Desktop/Selenium/geckodriver") ;
		WebDriver driver ;
		String baseUrl = "https//www.google.com" ;
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.MAC);
		driver = new FirefoxDriver(caps);
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

}
