package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException{
		fileName = fileName+".png";
		String directory = "/home/yang/Desktop/Selenium/ScreenShot/";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory+fileName));
	}

}
