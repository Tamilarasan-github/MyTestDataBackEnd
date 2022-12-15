package wrappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoEntity;

public class Helper extends SuperHelper{

	public static String testDataSourceLocalExecution;
	public ThreadLocal<String> description = new ThreadLocal<>();
	public ThreadLocal<String> testcaseName = new ThreadLocal<>();
	
	public ThreadLocal<String> testDataFileNameWithPath = new ThreadLocal<>();
	public ThreadLocal<String> testDataSheetName = new ThreadLocal<>();

	public ThreadLocal<Integer> suiteExecutionId = new ThreadLocal<>();
	public ThreadLocal<Integer> suiteId = new ThreadLocal<>();
	public ThreadLocal<String> suiteName = new ThreadLocal<>();
	public ThreadLocal<String> url = new ThreadLocal<>();
	public ThreadLocal<String> userName = new ThreadLocal<>();
	public ThreadLocal<String> password = new ThreadLocal<>();
	
	public ThreadLocal<String> queryLocalExecution = new ThreadLocal<>();
	
	static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

	
	@BeforeSuite
	@Parameters ({"suiteExecutionId", "suiteId", "suiteName", "url","userName","password"})
	public void beforeSuite(@Optional("") String suiteExecutionId, @Optional("") String suiteId, @Optional("Local Execution") String suiteName, @Optional("")String url, @Optional("")String userName, @Optional("")String password)
	{
		System.out.println("@BeforeSuite");
		loadProperties();
				
		if(suiteExecutionId==null || suiteExecutionId.equals(""))
		{
			this.suiteExecutionId.set(0);
		}
		else
		{
			this.suiteExecutionId.set(Integer.valueOf(suiteExecutionId));
		}
		
		if(suiteId==null || suiteId.equals(""))
		{
			this.suiteId.set(0);
		}
		else
		{
			this.suiteId.set(Integer.valueOf(suiteId));
		}
		
		this.suiteName.set(suiteName);
		this.url.set(url);
		this.userName.set(userName);
		this.password.set(password);
		
		if(this.url.get()==null || this.url.get().equals(""))
		{
			this.url.set(configProp.getProperty("url"));
		}
		
		if(this.userName.get()==null || this.userName.get().equals(""))
		{
			this.userName.set(credentialsProp.getProperty("userName"));
		}
		
		if(this.password.get()==null || this.password.get().equals(""))
		{
			this.password.set(credentialsProp.getProperty("password"));
		}
		
		testDataSourceLocalExecution = configProp.getProperty("testDataSource");

		System.out.println("URL: "+this.url.get());
		
		System.out.println("suiteExecutionId sent to report:"+suiteExecutionId);
		startExtentReport(suiteExecutionId);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("@BeforeMethod");
		//createNewTest(description.get(), testcaseName.get());
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("@AfterSuite");
		
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest");
		saveReport();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("@AfterClass");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("@AfterMethod");
		
	}
	
	@DataProvider(name="testDataProvider")
	public Iterator<TestDataMetaAppOneEntity> myDataProvider(ITestNGMethod iTestNGMethod)
	{
		String testScriptName=iTestNGMethod.getRealClass().getSimpleName();
		List<TestDataMetaAppOneEntity> testData = new ArrayList<TestDataMetaAppOneEntity>();
		
		try{    
			Connection con=DriverManager.getConnection(configProp.getProperty("db_url"),configProp.getProperty("db_username"),configProp.getProperty("db_password"));  
			Statement stmt=con.createStatement(); 
			ResultSet testDataMetaResultSet = null;
			if(suiteExecutionId.get()!=0)
			{
			
			ResultSet resultSetTestDataExec=stmt.executeQuery("SELECT * FROM TEST_DATA_META_EXECUTION_HISTORY_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.SUITE_EXECUTION_ID="+suiteExecutionId.get()+" AND t.DELETE_FLAG='N'");  
			System.out.println("Info: Executed from UI and TEST_DATA_META_EXECUTION_HISTORY_APP_ONE query is executed");
			System.out.println("SELECT * FROM TEST_DATA_META_EXECUTION_HISTORY_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.SUITE_EXECUTION_ID="+suiteExecutionId.get()+" AND t.DELETE_FLAG='N'");
		//	log(Status.INFO, "Info: Executed from UI: Query: SELECT * FROM TEST_DATA_META_EXECUTION_HISTORY_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.SUITE_EXECUTION_ID="+suiteExecutionId.get()+" AND t.DELETE_FLAG='N'");
			
			List<Integer> testDataMetaIdList = new ArrayList<>();
			while(resultSetTestDataExec.next())
			{
				testDataMetaIdList.add(resultSetTestDataExec.getInt("TEST_DATA_META_ID"));
			}
			resultSetTestDataExec.close();
			
			StringBuffer sb=new StringBuffer();
			
			for (int i = 0; i < testDataMetaIdList.size(); i++)
			{
				sb.append(testDataMetaIdList.get(i));
				
				if(i!=(testDataMetaIdList.size()-1))
				{
				sb.append(",");
				}
			}
			
			String testDataMetaIdListAsString = sb.toString();
			
			testDataMetaResultSet=stmt.executeQuery("SELECT * FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_DATA_META_ID IN ("+testDataMetaIdListAsString+")");  
			}
			else if(testDataSourceLocalExecution.equalsIgnoreCase("database") || testDataSourceLocalExecution.equalsIgnoreCase("db"))
				{
				if(queryLocalExecution.get()==null || queryLocalExecution.get().equalsIgnoreCase(""))
				{
					testDataMetaResultSet=stmt.executeQuery("SELECT * FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.DELETE_FLAG='N'");  
					System.out.println("Info: Local Execution and TEST_DATA_META_APP_ONE default query is executed");
		//			log(Status.INFO, "Info: Local Execution: Query: SELECT * FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.DELETE_FLAG='N'");
				}
				else
				{
					testDataMetaResultSet=stmt.executeQuery(queryLocalExecution.get());
					System.out.println("Info: Local Execution and testscript based customized query is executed");
		//			log(Status.INFO, "Info: Local Execution and testscript based customized query "+queryLocalExecution.get());
				}
			}
			while(testDataMetaResultSet.next()) 
			{
				Statement statementTwo=con.createStatement();  
				ResultSet tableOneResultSet=statementTwo.executeQuery("SELECT * FROM TEST_DATA_APP_TABLE_ONE t WHERE t.TEST_DATA_APP_META_ID="+testDataMetaResultSet.getInt("TEST_DATA_META_ID"));  

				List<TestDataAppOneTableOneEntity> testDataAppOneTableOneEntityList=new ArrayList<>();
				List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwoEntityList=new ArrayList<>();

				while(tableOneResultSet.next())
				{
					if(tableOneResultSet.getString("DELETE_FLAG").equals("N"))
					{
					TestDataAppOneTableOneEntity testDataAppOneTableOneEntity=new TestDataAppOneTableOneEntity();
					testDataAppOneTableOneEntity.setTestDataId(tableOneResultSet.getInt("TEST_DATA_ID"));
					testDataAppOneTableOneEntity.setTestRowDetail(tableOneResultSet.getString("TEST_ROW_DETAIL"));
					testDataAppOneTableOneEntity.setColumn1(tableOneResultSet.getString("COLUMN1"));
					testDataAppOneTableOneEntity.setColumn2(tableOneResultSet.getString("COLUMN2"));
					testDataAppOneTableOneEntity.setColumn3(tableOneResultSet.getString("COLUMN3"));
					testDataAppOneTableOneEntity.setColumn4(tableOneResultSet.getString("COLUMN4"));
					testDataAppOneTableOneEntity.setColumn5(tableOneResultSet.getString("COLUMN5"));
					
					testDataAppOneTableOneEntityList.add(testDataAppOneTableOneEntity);
					}

				}
				tableOneResultSet=null;
				tableOneResultSet=statementTwo.executeQuery("SELECT * FROM TEST_DATA_APP_TABLE_TWO t WHERE t.TEST_DATA_APP_META_ID="+testDataMetaResultSet.getInt("TEST_DATA_META_ID"));  
				while(tableOneResultSet.next())
				{
					if(tableOneResultSet.getString("DELETE_FLAG").equals("N"))
					{
					TestDataAppOneTableTwoEntity testDataAppOneTableTwoEntity=new TestDataAppOneTableTwoEntity();
					testDataAppOneTableTwoEntity.setTestDataId(tableOneResultSet.getInt("TEST_DATA_ID"));
					testDataAppOneTableTwoEntity.setTestRowDetail(tableOneResultSet.getString("TEST_ROW_DETAIL"));
					testDataAppOneTableTwoEntity.setColumnA(tableOneResultSet.getString("COLUMN_A"));
					testDataAppOneTableTwoEntity.setColumnB(tableOneResultSet.getString("COLUMN_B"));
					testDataAppOneTableTwoEntity.setColumnC(tableOneResultSet.getString("COLUMN_C"));
					testDataAppOneTableTwoEntity.setColumnD(tableOneResultSet.getString("COLUMN_D"));
					testDataAppOneTableTwoEntity.setColumnE(tableOneResultSet.getString("COLUMN_E"));
					
					testDataAppOneTableTwoEntityList.add(testDataAppOneTableTwoEntity);
					}

				}
				TestDataMetaAppOneEntity testDataMetaAppOneEntity=new TestDataMetaAppOneEntity();
				testDataMetaAppOneEntity.setTestDataMetaId(testDataMetaResultSet.getInt("TEST_DATA_META_ID"));
				testDataMetaAppOneEntity.setTestShortDescription(testDataMetaResultSet.getString("TEST_SHORT_DESCRIPTION"));
				testDataMetaAppOneEntity.setTestScenario(testDataMetaResultSet.getString("TEST_SCENARIO"));
				testDataMetaAppOneEntity.setTestTableOne(testDataMetaResultSet.getInt("TEST_TABLE_ONE"));
				testDataMetaAppOneEntity.setTestTableTwo(testDataMetaResultSet.getInt("TEST_TABLE_TWO"));
				testDataMetaAppOneEntity.setTestDataAppOneTableOne(testDataAppOneTableOneEntityList);
				testDataMetaAppOneEntity.setTestDataAppOneTableTwo(testDataAppOneTableTwoEntityList);
				
				testData.add(testDataMetaAppOneEntity);
			}
			con.close();  
			}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  	
		finally
		{
			
		}
				 
		Iterator<TestDataMetaAppOneEntity> iterator=testData.iterator();
		return iterator;
	}
}
