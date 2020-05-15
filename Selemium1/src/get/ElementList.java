package get;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementList {
	WebDriver driver ;
	
	public ElementList(WebDriver driver) {
		this.driver = driver ;
	}
	
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase() ;
		if(type.equals("id")) {
			System.out.println("use id to find element " + locator) ;
			return this.driver.findElements(By.id(locator)) ;
		}else if(type.equals("xpath")) {
			System.out.println("use xpath to find element " + locator) ;
			return this.driver.findElements(By.xpath(locator)) ;
		}else {
			System.out.println("locator does not support") ;
			return null ;
		}
	}
}