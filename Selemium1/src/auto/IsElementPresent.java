package auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IsElementPresent {
	WebDriver driver ;
	public IsElementPresent(WebDriver driver){
		this.driver = driver ;
	}
	
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase() ;
		if (type.equals("id")) {
			System.out.println("find by id: " + locator);
			return this.driver.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("find by xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		} else if (type.equals("name")) {
			System.out.println("find by name: " + locator);
			return this.driver.findElement(By.name(locator));
		} else if (type.equals("css")) {
			System.out.println("find by css: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			System.out.println("find by classname: " + locator);
			return this.driver.findElement(By.className(locator));
		} else if (type.equals("tagname")) {
			System.out.println("find by tagname: " + locator);
			return this.driver.findElement(By.tagName(locator));
		} else if (type.equals("linktext")) {
			System.out.println("find by linktext: " + locator);
			return this.driver.findElement(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			System.out.println("find by partiallinktext: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		} else {
			System.out.println("others");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type){
		type = type.toLowerCase() ;
		if (type.equals("id")) {
			System.out.println("find by id: " + locator);
			return this.driver.findElements(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("find by xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));
		} else if (type.equals("name")) {
			System.out.println("find by name: " + locator);
			return this.driver.findElements(By.name(locator));
		} else if (type.equals("css")) {
			System.out.println("find by css: " + locator);
			return this.driver.findElements(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			System.out.println("find by classname: " + locator);
			return this.driver.findElements(By.className(locator));
		} else if (type.equals("tagname")) {
			System.out.println("find by tagname: " + locator);
			return this.driver.findElements(By.tagName(locator));
		} else if (type.equals("linktext")) {
			System.out.println("find by linktext: " + locator);
			return this.driver.findElements(By.linkText(locator));
		} else if (type.equals("partiallinktext")) {
			System.out.println("find by partiallinktext: " + locator);
			return this.driver.findElements(By.partialLinkText(locator));
		} else {
			System.out.println("others");
			return null;
		}
	}
	
	public boolean isElementListPresent(String locator, String type) {
		List<WebElement> elementList = getElementList(locator, type) ;
		int size = elementList.size() ;
		if(size > 0) return true ;
		else return false ;
	}
	
}
