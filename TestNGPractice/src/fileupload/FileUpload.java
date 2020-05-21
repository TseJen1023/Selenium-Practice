package fileupload;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
	private WebDriver driver;
	
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://login.yahoo.com/?.src=ym&.lang=zh-Hant-TW&.intl=tw&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dtw%26.lang%3Dzh-Hant-TW";
		System.setProperty("webdriver.chrome.driver", "/home/yang/Desktop/Selenium/chromedriver") ; 
		driver = new ChromeDriver();;
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@placeholder='邮箱帐号或手机号码']")).sendKeys("account number");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(); // Enter your password
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.xpath("//a[@class='ned-compose f-fl js-compose']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@placeholder='输入对方手机号, 就能给他发邮件']//input[@class='js-widget']")).sendKeys("fallskyfubo@163.com");
		driver.findElement(By.xpath("//div[@class='cmp-value js-value']//input[@class='value js-input']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//span[@class='w-icon-editor icon-editor-attach js-icon-txt']"));
		fileInput.click();
		//upload the file
		StringSelection ss = new StringSelection("/Users/gaoyan/Desktop/test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		
		Robot robot = new Robot();
//		Cmd+Tab
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
//		Goto window "search"
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
//		粘贴粘贴板上复制的值
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
//		Hit enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		driver.findElement(By.xpath("//span[text()='发送']")).click();
	}

	@AfterClass
	public void afterClass() {
	}

}
