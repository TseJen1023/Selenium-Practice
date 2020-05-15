package pomtestcase;

import static org.junit.jupiter.api.Assertions.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageclasses.SearchPageFactory;

class FIndLinks {
	WebDriver driver ;
	String baseUrl ;
	SearchPageFactory searchPage ;
	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver() ;
		baseUrl = "https://www.expedia.com.tw/flights" ;
		searchPage = new SearchPageFactory(driver) ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}

	@Test
	void test() {
		driver.get(baseUrl);
		searchPage.clickFlightTab();
		List<WebElement> linkList = clickableLinks(driver) ;
		for(WebElement link : linkList) {
			String href = link.getAttribute("href") ;
			try {
				System.out.println("URL " + href + " returned"+ linkStatus(new URL(href))) ;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static List<WebElement> clickableLinks(WebDriver driver){
		List<WebElement> linksToClick = new ArrayList<WebElement>() ;
		List<WebElement> elements = driver.findElements(By.tagName("a")) ; //find all tag with a(href img)
		elements.addAll(driver.findElements(By.tagName("img"))) ;
		for(WebElement element: elements) {
			//if href can be click, not empty, add it to linksToClick list
			if(element.getAttribute("href") != null) {
				linksToClick.add(element) ;
			}
		}
		return linksToClick ;
	}
	
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection)url.openConnection() ;
			http.connect() ;
			String responseMessage = http.getResponseMessage() ;
			http.disconnect();
			return responseMessage ;
		}catch(Exception e) {
			return e.getMessage() ;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
