package com.inetbank.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream xlFIS;
	public static FileOutputStream xlFOS;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheetName) throws IOException
	{
		xlFIS = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlFIS);
		ws = wb.getSheet(xlSheetName);
		int countRows = ws.getLastRowNum();
		wb.close();
		xlFIS.close();
		return countRows;
		
	}
	
	public static int getCellCount(String xlFile, String xlSheetName, int rowNum) throws IOException
	{
		xlFIS = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlFIS);
		ws = wb.getSheet(xlSheetName);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		xlFIS.close();
		
		return cellCount;
		
	}
	
	public static String getCellData(String xlFile, String xlSheetName, int rowNum, int colNum) throws IOException
	{
		xlFIS = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlFIS);
		ws = wb.getSheet(xlSheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e)
		{
			data = "";
		}
		wb.close();
		xlFIS.close();
		return data; 
		
	}
	
	
	public static void setCellData(String xlFile, String xlSheetName, int rowNum, int colNum, String data) throws IOException
	{
		xlFIS = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlFIS);
		ws = wb.getSheet(xlSheetName);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		cell.setCellValue(data);
		xlFOS = new FileOutputStream(xlFile);
		wb.write(xlFOS);
		wb.close();
		xlFIS.close();
		xlFOS.close();
	}

}
