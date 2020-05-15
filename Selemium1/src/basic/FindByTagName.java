package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagName {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		driver = new ChromeDriver();
		String baseUrl = "https://www.books.com.tw/?loc=tw_logo_001";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		driver.findElement(By.tagName("a")).click();
	
//		id 
//		name
//		class name
//		xpath
//		linktext
//		partial link text
//		tag name
//		css selector
		
	}

}
