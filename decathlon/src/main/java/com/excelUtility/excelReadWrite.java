package com.excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadWrite {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	String filePath;
	
	public excelReadWrite(String path) 
	{
		filePath = path;
	}
	
	//To read excel data
	public String readExcelData(String sheetName, int rowNumber, int colNumber) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(colNumber);
		
//		String value = cell.getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
        
		inputStream.close();
		
		return value;
	}
	
	//To write excel data
	public void writeExcelData(String sheetName, int rowNumber, int columnNumber, String data, String color) throws IOException
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell;	
		
		if(color=="blue")
		{
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			style.setFont(font);
			
			cell = row.createCell(columnNumber);
			cell.setCellValue(data);
			cell.setCellStyle(style);
		}		
		else if(color == "green")
		{
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			style.setFont(font);
			
			cell = row.createCell(columnNumber);
			cell.setCellValue(data);
			cell.setCellStyle(style);
		}
		else if(color == "red")
		{
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			style.setFont(font);
			
			cell = row.createCell(columnNumber);
			cell.setCellValue(data);
			cell.setCellStyle(style);
		}
		
		inputStream.close();
		
		outputStream = new FileOutputStream(new File(filePath));
		workbook.write(outputStream);
        outputStream.close();
	}
	
	public int getTotalRows(String sheetName) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		int totalRows = sheet.getLastRowNum();
		inputStream.close();
		
		return(totalRows);		
	}
	
	public int getTotalcolumns(String sheetName) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		int totalcolumns = sheet.getRow(1).getLastCellNum();
		inputStream.close();
		
		return(totalcolumns);		
	}
}
