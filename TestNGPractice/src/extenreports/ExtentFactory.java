package extenreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "/home/yang/Desktop/Selenium/Report/smultipleReport.html";
		extent = new ExtentReports(Path, false); //false -> 不覆蓋已有文件 追加
		extent.addSystemInfo("Selenium Version", "3.6.0").addSystemInfo("Platform", "Ubuntu");

		return extent;
	}
}
