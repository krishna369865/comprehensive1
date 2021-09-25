package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 int rowcount=0;
	 int colcount=0;
	 
	 public excelutils(String excelpath,String sheetname) throws IOException{
		 workbook=new XSSFWorkbook(excelpath); 
		 sheet=workbook.getSheet(sheetname);
		 
		 
	 }
	 
	
	public static int getRowCount() throws IOException{
		int rowcount=sheet.getPhysicalNumberOfRows();
		return rowcount;
	}
	
	public static int getColCount() {
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}
	
	public static String getCellDataString(int rownum,int colnum) throws IOException {
		 String celldata=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return celldata;
		 
		 
		
	}
	public static void getCellDataNumber(int rownum,int colnum) throws IOException {
		 double celldata=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		 
		
	}

}

