package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null ;
	//https://www.expedia.com.tw/
	/*
	 * return starter frame element
	 * @param driver 
	 * @return 
	 */
	public static WebElement starterTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='clear-btn-input gcw-storeable text gcw-origin gcw-required gcw-distinct-locations ']")) ;
		return element ;
	}
	
	public static void fillStarterTextBox(WebDriver driver, String starter) {
		element = starterTextBox(driver) ;
		element.sendKeys(starter) ;
	}
	
	/*
	 * return destination frame element
	 * @param driver 
	 * @return 
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='clear-btn-input gcw-storeable text gcw-destination gcw-required gcw-distinct-locations ']")) ;
		return element ;
	}
	
	public static void fillDestinationTextBox(WebDriver driver, String destination) {
		element = destinationTextBox(driver) ;
		element.sendKeys(destination) ;
	}
	
	/*
	 * return start date frame element
	 * @param driver 
	 * @return 
	 */
	public static WebElement startDateTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='flight-departing-flp']")) ;
		return element ;
	}
	
	public static void fillStarterDateTextBox(WebDriver driver, String dateStart) {
		element = startDateTextBox(driver) ;
		element.sendKeys(dateStart) ;
	}
	
	/*
	 * return back date frame element
	 * @param driver 
	 * @return 
	 */
	public static WebElement arriveDateTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='flight-returning-flp']")) ;
		return element ;
	}
	
	public static void fillArriveDateTextBox(WebDriver driver, String arriveStart) {
		element = arriveDateTextBox(driver) ;
		element.sendKeys(arriveStart) ;
	}
	
	/*
	 * return search button frame element
	 * @param driver 
	 * @return 
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='gcw-flights-form-flp']/div[9]/label/button")) ;
		return element ;
	}
	
	/*
	 * click search button
	 * @param driver 
	 */
	public static void clickSearchButton(WebDriver driver) {
		element = searchButton(driver) ;
		element.click();
	}
	
}
