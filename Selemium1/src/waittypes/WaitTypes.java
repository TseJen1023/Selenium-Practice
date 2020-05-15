package waittypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	WebDriver driver;

	public WaitTypes(WebDriver driver) {
		// this.driver is the driver above, and the right driver is sent by the function
		this.driver = driver;
	}

	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		
		try {
			System.out.println("wait for " + timeout + " seconds") ;
			WebDriverWait wait = new WebDriverWait(driver,3) ;
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) ; 
			System.out.println("elemet exists") ;
		} catch (Exception e) {
			System.out.println("element does not exist");
		}
		
		return element;
	}
	
	public WebElement clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		
		try {
			System.out.println("wait for at least " + timeout + " seconds then you can click") ;
			WebDriverWait wait = new WebDriverWait(driver,3) ;
			element = wait.until(ExpectedConditions.elementToBeClickable(locator)) ; 
			element.click();
			System.out.println("click on the web page") ;
		} catch (Exception e) {
			System.out.println("element does not exist");
		}
		
		return element;
	}

}
