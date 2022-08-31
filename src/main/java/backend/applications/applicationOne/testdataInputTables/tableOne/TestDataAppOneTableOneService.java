package backend.applications.applicationOne.testdataInputTables.tableOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;

public class TestDataAppOneTableOneService
{

	public void createWorkbook(String excelFileName, String sheetName, List<TestDataMetaAppOneEntity> testData)
	{
		try (Workbook workbook = new XSSFWorkbook())
		{
			Sheet sheet;
			Row row;
			Cell cell;
			int rowNum;
			int cellNumHeader;
			
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			try
			{		
				sheet = workbook.createSheet(sheetName);   
				rowNum=0;
				cellNumHeader=0;
				//Create Header
				row = sheet.createRow(rowNum++);  
			
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestDataMetaId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestCaseId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestShortDescription"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestScenario"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("RunFlag"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestPriority"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestCategory"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestScriptName"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("JiraId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestExecutionTime"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("CreatedBy"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("CreatedDate"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("UpdatedBy"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("UpdatedDate"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("DeleteFlag"); cell.setCellStyle(headerStyle);
				
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestDataId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestRowDetail"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("DeleteFlag"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column1"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column2"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column3"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column4"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column5"); cell.setCellStyle(headerStyle);
				
				
				
				for(TestDataMetaAppOneEntity data: testData)
				{
					int cellNum=0;
					row = sheet.createRow(rowNum++);  
					row.createCell(cellNum++).setCellValue(data.getTestDataMetaId());
					row.createCell(cellNum++).setCellValue(data.getTestCaseId());
					row.createCell(cellNum++).setCellValue(data.getTestShortDescription());
					row.createCell(cellNum++).setCellValue(data.getTestScenario());
					row.createCell(cellNum++).setCellValue(data.getRunFlag());
					row.createCell(cellNum++).setCellValue(data.getTestPriority());
					row.createCell(cellNum++).setCellValue(data.getTestCategory());
					row.createCell(cellNum++).setCellValue(data.getTestScriptName());
					row.createCell(cellNum++).setCellValue(data.getJiraId());
					row.createCell(cellNum++).setCellValue(data.getTestExecutionTime());
					row.createCell(cellNum++).setCellValue(data.getCreatedBy());
					row.createCell(cellNum++).setCellValue(data.getCreatedDate());
					row.createCell(cellNum++).setCellValue(data.getUpdatedBy());
					row.createCell(cellNum++).setCellValue(data.getUpdatedDate());
					row.createCell(cellNum++).setCellValue(data.getDeleteFlag());
					
					int testDataColumnStartingPoint=cellNum;
					List<TestDataAppOneTableOneEntity> testDataTableOneList=data.getTestDataAppOneTableOne();
					
					for(int testDataRow=0; testDataRow<testDataTableOneList.size(); testDataRow++)
					{
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getTestDataId());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getTestRowDetail());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getDeleteFlag());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn1());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn2());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn3());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn4());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn5());
					
					if((testDataRow+1) <testDataTableOneList.size())
					{
						row = sheet.createRow(rowNum++);  
						cellNum=testDataColumnStartingPoint;
					}
					}

				}
				
				OutputStream fileOut=new FileOutputStream("src/main/resources/GeneratedExcelFiles/"+excelFileName+".xlsx");
				workbook.write(fileOut);  
		
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	catch (IOException e)
	{
			e.printStackTrace();
	}
	}

}
