package backend.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{

	public void createWorkbook(String excelFileName, String sheetName)
	{
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet;
		Row rowhead;
		try
		{		
			sheet = workbook.createSheet(sheetName);   
			//creating the 0th row using the createRow() method  
			rowhead = sheet.createRow((short)0);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			rowhead.createCell(0).setCellValue("S.No.");  
			rowhead.createCell(1).setCellValue("Customer Name");  
			rowhead.createCell(2).setCellValue("Account Number");  
			rowhead.createCell(3).setCellValue("e-mail");  
			rowhead.createCell(4).setCellValue("Balance");  
			
			OutputStream fileOut=new FileOutputStream("src/main/resources/GeneratedExcelFiles/"+excelFileName+".xlsx");
			workbook.write(fileOut);  
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
