package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy ;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver ;
	
	@FindBy(id="flight-type-one-way-label-flp")
	WebElement flightTab ;
	@FindBy(id="flight-type-roundtrip-label-flp")
	WebElement roundTrip ;
	@FindBy(id="flight-type-multi-dest-label-flp")
	WebElement multipleDestination ;
	@FindBy(xpath="//input[@class='clear-btn-input gcw-storeable text gcw-origin gcw-required gcw-distinct-locations ']")
	WebElement starter ;
	@FindBy(xpath="//input[@class='clear-btn-input gcw-storeable text gcw-destination gcw-required gcw-distinct-locations ']")
	WebElement destination ;
	@FindBy(id="flight-departing-single-flp")
	WebElement departure ;
	@FindBy(xpath="//*[@id='gcw-flights-form-flp']//button[@class='btn-primary btn-action gcw-submit']")
	WebElement clickSearch ;
	
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this); //initialize the elements above(@FInd)
	}
	
	public void clickFlightTab() {
		flightTab.click();
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	public void clickMultipleDestination() {
		multipleDestination.click();
	}
	
	public void clickSearchTrip() {
		clickSearch.click();
	}
	
	public void setStartCity(String starterCity) {
		starter.sendKeys(starterCity);
	}
	
	public void setDestinationCity(String destinationCity) {
		destination.sendKeys(destinationCity);
	}
	
	public void setDepartureDate(String departureDate) {
		departure.sendKeys(departureDate);
	}
	
	public void clickSearchButton() {
		clickSearch.click();
	}
}
