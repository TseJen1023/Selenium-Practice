package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;

	/*
	 * set path and open file
	 * @params - Excel path & sheet name 
	 */
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// open file
			path = "/home/yang/Desktop/Selenium/E.xlsx";
			FileInputStream ExcelFile = new FileInputStream(path);
			// lookup excel file
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}
	/*
	 * get data 
	 */
	public static String[][] getTestData(String tableName) {
		String[][] testData = null;

		try {
			// data type : number and string
			DataFormatter formatter = new DataFormatter();
			// BoundaryCells put the first row and last row
			// according to first and last, we can get the row data
			XSSFCell[] boundaryCells = findCells(tableName);
			// cell start
			XSSFCell startCell = boundaryCells[0];
			// cell end
			XSSFCell endCell = boundaryCells[1];

			// FIND each row's column start
			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex() - 1;
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;

			testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol + 1; j++) {
					// testData[i-startRow][j-startCol] =
					// ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					Cell cell = ExcelWSheet.getRow(i).getCell(j);
					testData[i - startRow][j - startCol] = formatter.formatCellValue(cell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : ExcelWSheet) {
			for (Cell cell : row) {
				// if (tableName.equals(cell.getStringCellValue())) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equalsIgnoreCase("begin")) {
						// find the element, start the cell
						cells[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						// end the cell
						cells[1] = (XSSFCell) cell;
					}
				}
			}
		}
		return cells;
	}
}

