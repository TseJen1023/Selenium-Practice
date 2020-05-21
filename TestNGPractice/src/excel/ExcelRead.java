package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
//	 jar link : http://poi.apache.org/download.html
//	 file - poi-bin-3.17-20170915.zip 
//	 解壓縮
//	 jars add to  build path
//	 no log4j jar file
//	 ooxml-lib jar file
//	 Excel 2007+ 

	public static void main(String[] args) throws FileNotFoundException {
		XSSFWorkbook excelWBook ; //表格
		XSSFSheet excelWSheet ;   //表單
		XSSFCell cell ;           //單元格
		// Location of the Excel file
		String path = "/home/yang/Desktop/Selenium/ExcelPractice.xlsx";
		String sheetName = "Sheet1";
		try {
			FileInputStream excelFile = new FileInputStream(path) ;
			excelWBook = new XSSFWorkbook(excelFile) ;    //傳給表格file
			excelWSheet= excelWBook.getSheet(sheetName) ; //file store to sheet
			cell = excelWSheet.getRow(1).getCell(1) ;
			String cellData = cell.getStringCellValue() ;
			System.out.println("cell data: " + cellData) ; 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}