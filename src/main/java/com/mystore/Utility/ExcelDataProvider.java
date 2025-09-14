package com.mystore.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public Workbook wb;
	
	public ExcelDataProvider() {
		String excelpath=System.getProperty("user.dir")+"\\testData\\TestData.xlsx";
		
		try {
			File src=new File(excelpath);
			FileInputStream file=new FileInputStream(src);
			wb=WorkbookFactory.create(file);
			} 
			catch (Exception e) {
			
			e.printStackTrace();
			}
		
	}
	
	public String getStringData(String sheetname,int row,int column ) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
	public double getNumericData(String sheetname,int row,int column ) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		

}}
