package listenerspackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

	public static void main(String[] args) {
		String baseUrl = "https://forum.gamer.com.tw/";
	    System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ;
		WebDriver driver = new ChromeDriver();;
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		
		HandlesEvents he = new HandlesEvents();
		eDriver.register(he);
		
		eDriver.get(baseUrl);
		eDriver.findElement(By.xpath("//a[text()='我要登入']")).click();
	}
}