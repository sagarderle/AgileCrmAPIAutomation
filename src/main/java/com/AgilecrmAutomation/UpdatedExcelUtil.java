package com.AgilecrmAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdatedExcelUtil {

	private String getFileExtension(String filePath) {
		String extension = filePath.substring(filePath.indexOf("."));
		System.out.println(extension);
		return extension;
	}

	private Workbook getWorkbookInstance(String filePath) throws IOException {
		Workbook wb;
		FileInputStream input = new FileInputStream(filePath);
		if (getFileExtension(filePath).equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		return wb;
	}

	private Sheet getSheet(String filePath, String sheetname) {
		Sheet sheet = null;
		try {
			Workbook wb = getWorkbookInstance(filePath);
			sheet = wb.getSheet(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}

	public Object[][] getSheetdata(String filePath, String sheetname) {
		Sheet sheet = getSheet(filePath, sheetname);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		return getCellValue(sheet, totalRows, totalColumns);
	}

	private Object[][] getCellValue(Sheet sheet, int totalRows, int totalColumns) {
		Object[][] value = new Object[totalRows][totalColumns];
		for (int i = 1; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				Cell cell = row.getCell(j);

				CellType type = cell.getCellType();

				switch (type) {

				case STRING:
					value[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					value[i][j] = cell.getNumericCellValue();
					break;
				case BOOLEAN:
					value[i][j] = cell.getBooleanCellValue();
					break;
				case _NONE:
					value[i][j] = null;
					break;
				case BLANK:
					value[i][j] = null;
					break;

				}

			}

		}
		return value;

	}

	/*
	 * Method to add/set data in to Excel
	 * 
	 * @ filepath in string format sheetname rowNum colNum value
	 */
	public void setDataInExcel(String filePath, String sheetName, int rowNum, int cellNum, Object value) {
		try {
			Workbook wb = getWorkbookInstance(filePath);
			Sheet sheet;
			// get the details of sheet if it is present in the Workbook
			if (wb.getSheet(sheetName) != null) {
				sheet = wb.getSheet(sheetName);

			} else {
				// create new sheet in the workbook
				sheet = wb.createSheet(sheetName);
			}
			// create the row if not present else get row control
			Row row;
			if (sheet.getRow(rowNum) != null) {
				row = sheet.getRow(rowNum);
			} else {
				row = sheet.createRow(rowNum);
			}
			// create cell if not present else get cell control
			Cell cell;
			if (row.getCell(cellNum) != null) {
				cell = row.getCell(cellNum);
			} else {
				cell = row.createCell(cellNum);
			}
			setCellValue(cell, value);
			FileOutputStream output = new FileOutputStream(filePath);
			wb.write(output);
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCellValue(Cell cell, Object val) {
		if (val instanceof Integer) {
			cell.setCellValue((int) val);
		} else if (val instanceof String) {
			cell.setCellValue(val.toString());

		} else if (val instanceof Boolean) {
			cell.setCellValue((boolean) val);
		}

	}

	/*
	 * public static void main(String[] args) throws IOException { String filePath =
	 * "C:\\AgilecrmTestCases\\TestCase_Agilecrm.xlsx"; UpdatedExcelUtilTest
	 * excelvalues = new UpdatedExcelUtilTest(); Object[][] data =
	 * excelvalues.getSheetdata(filePath, "Agile_TestCase_creation"); int rowlength
	 * = data.length; int collength = 2; for (int i = 1; i <= rowlength - 1; i++) {
	 * for (int j = 0; j < collength; j++) { System.out.println(data[i][j]); }
	 * 
	 * }
	 * 
	 * }
	 */
}
