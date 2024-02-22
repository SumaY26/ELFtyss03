package com.demoworkshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead implements FrameworkConstants{

	public static String readStringValue(String sheetName,int row, int cell) throws EncryptedDocumentException, Exception {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(cell).toString();
	}
	public static double readNumericValue(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(cell).getNumericCellValue();
	}
	public static boolean readBoolenaValue(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(cell).getBooleanCellValue();
	}
	public static Date readDateValue(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		return sheet.getRow(row).getCell(cell).getDateCellValue();
	}
//	public static void singleRead() throws EncryptedDocumentException, IOException {
//		File f = new File(EXCEL_PATH);
//		FileInputStream fis = new FileInputStream(f);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet s = wb.getSheet("LoginData");
//		int num_rows=s.getPhysicalNumberOfRows();
//		int num_cell=s.getRow(0).getPhysicalNumberOfCells();
//		Row row = s.getRow(0);
//		Cell cell=row.getCell(num_cell);
//		
//	}
	public static String[][] multipleRead(String sheetName) throws EncryptedDocumentException, IOException{
		File file=new File(EXCEL_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
	//	int firstrow = s.getFirstRowNum();
		int num_rows=s.getPhysicalNumberOfRows();
		int num_cell=s.getRow(0).getPhysicalNumberOfCells();
	//	Row row = s.getRow(firstrow);
		//Cell cell=row.getCell(num_cell);
		String[][] data=new String[num_rows][num_cell];
		for(int i=0;i<num_rows-1;i++) {
			for(int j=0;j<num_cell;j++) {
				data[i][j]=s.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
