package com.parabank.Utils;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;

//import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.parabank.TestBase.TestBase;

public class ExcelUtils  extends TestBase{

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	

	public static int getRowCount(String path, String SheetName) throws Exception {

		int noOfRows;
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(SheetName);
		noOfRows = ws.getLastRowNum();
		wb.close();
		fi.close();
		return noOfRows;

	}
	public  static int getColumCount (String path,String sheetName,int rowNo) throws Exception {
		int colCount ;
		
		fi= new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetName);
		row=ws.getRow(rowNo);
		colCount=row.getLastCellNum();
		fi.close();
		wb.close();
		return colCount;
		
	}
	
	
	@SuppressWarnings("static-access")
	public static  String getData(String path,String SheetName,int rowNo,int colNo) throws Exception {
		
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		row=ws.getRow(rowNo);
		cell=row.getCell(colNo);
		cell.setCellType(cell.CELL_TYPE_STRING);
		 String data = cell.getStringCellValue();
		
		return data;
		
	}
	

}
