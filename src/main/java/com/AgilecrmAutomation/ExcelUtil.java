package com.AgilecrmAutomation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static Workbook wb;

	public static void main(String[] args) throws IOException {
       
		// file path
		String filePath = "C:\\AgilecrmTestCases\\TestCase_Agilecrm.xlsx";
		// get the file path extension
		String extension = filePath.substring(filePath.indexOf("."));
		System.out.println(extension);
		// get control of the excel file
		FileInputStream input = new FileInputStream(filePath);
		// get extension of file through workbook
		if (extension.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		// take control on sheet using workbook reference
		Sheet sheet = wb.getSheet("Agile_TestCase_creation");
		// get total no of rows from sheet
		int totalrows = sheet.getPhysicalNumberOfRows();
		int totalcolumns = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 1; i < totalrows; i++) {
			// get control on rows based on i value
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalcolumns; j++) {
				// get the control of cell using row reference
				Cell cell = row.getCell(j);
				// get the cell value using cell reference
				String value = cell.getStringCellValue();
				System.out.println(value);
			}
		}
		wb.close();
		input.close();

	}
}
