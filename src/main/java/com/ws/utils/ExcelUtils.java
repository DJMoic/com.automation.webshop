package com.ws.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	XSSFWorkbook wb;
	
	/*
	 * This constructor is used to read excel file
	 */

	public ExcelUtils(String excelPath) {
		try {
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
		     wb = new XSSFWorkbook(fis);
		} 
		    catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public int getRowCount(int sheetNo) {
		int count = wb.getSheetAt(sheetNo).getLastRowNum()+1;
		return count;
		}
		
		public String getCellData(int sheetNo, int row, int cell ) {
			String data = wb.getSheetAt(sheetNo).getRow(row).getCell(cell).toString();
			return data;
		
			
		
	}

}
