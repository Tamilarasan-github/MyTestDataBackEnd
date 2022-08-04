package wrappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.ITestContext;
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

import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoEntity;

public class Helper extends SuperHelper{

	public String description;
	public String testcaseName;
	public String suiteId;
	public String suiteName;
	public String url;
	public String userName;
	public String password;
	
		
	@BeforeSuite
	@Parameters ({"suiteId", "suiteName", "url","userName","password"})
	public void beforeSuite(@Optional("") String suiteId, @Optional("DirectExecution") String suiteName, @Optional("")String url, @Optional("")String userName, @Optional("")String password)
	{
		System.out.println("@BeforeSuite");
		loadProperties();
		
		this.suiteId=suiteId;
		this.suiteName=suiteName;
		this.url=url;
		this.userName=userName;
		this.password=password;
		
		if(this.url==null || this.url.equals(""))
		{
			this.url=configProp.getProperty("url");
		}
		
		if(this.userName==null || this.userName.equals(""))
		{
			this.userName=credentialsProp.getProperty("userName");
		}
		
		if(this.password==null || this.password.equals(""))
		{
			this.password=credentialsProp.getProperty("password");
		}
		
		System.out.println("URL: "+this.url);
		
		System.out.println("suiteId sent to report:"+suiteId);
		startExtentReport(suiteId);
		
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
		createNewTest(description, testcaseName);
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
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(configProp.getProperty("oracle_db_url"),configProp.getProperty("oracle_db_username"),configProp.getProperty("oracle_db_password"));  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_SCRIPT_NAME='"+testScriptName+"' AND t.RUN_FLAG='Y' AND t.DELETE_FLAG='N'");  
			
			while(rs.next()) 
			{
				Statement statementTwo=con.createStatement();  
				ResultSet resultSetTwo=statementTwo.executeQuery("SELECT * FROM TEST_DATA_APP_TABLE_ONE t WHERE t.TEST_DATA_APP_META_ID="+rs.getInt("TEST_DATA_META_ID"));  

				List<TestDataAppOneTableOneEntity> testDataAppOneTableOneEntityList=new ArrayList<>();
				List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwoEntityList=new ArrayList<>();

				while(resultSetTwo.next())
				{
					if(resultSetTwo.getString("DELETE_FLAG").equals("N"))
					{
					TestDataAppOneTableOneEntity testDataAppOneTableOneEntity=new TestDataAppOneTableOneEntity();
					testDataAppOneTableOneEntity.setTestDataId(resultSetTwo.getInt("TEST_DATA_ID"));
					testDataAppOneTableOneEntity.setTestRowDetail(resultSetTwo.getString("TEST_ROW_DETAIL"));
					testDataAppOneTableOneEntity.setColumn1(resultSetTwo.getString("COLUMN1"));
					testDataAppOneTableOneEntity.setColumn2(resultSetTwo.getString("COLUMN2"));
					testDataAppOneTableOneEntity.setColumn3(resultSetTwo.getString("COLUMN3"));
					testDataAppOneTableOneEntity.setColumn4(resultSetTwo.getString("COLUMN4"));
					testDataAppOneTableOneEntity.setColumn5(resultSetTwo.getString("COLUMN5"));
					
					testDataAppOneTableOneEntityList.add(testDataAppOneTableOneEntity);
					}

				}
				resultSetTwo=null;
				resultSetTwo=statementTwo.executeQuery("SELECT * FROM TEST_DATA_APP_TABLE_TWO t WHERE t.TEST_DATA_APP_META_ID="+rs.getInt("TEST_DATA_META_ID"));  
				while(resultSetTwo.next())
				{
					if(resultSetTwo.getString("DELETE_FLAG").equals("N"))
					{
					TestDataAppOneTableTwoEntity testDataAppOneTableTwoEntity=new TestDataAppOneTableTwoEntity();
					testDataAppOneTableTwoEntity.setTestDataId(resultSetTwo.getInt("TEST_DATA_ID"));
					testDataAppOneTableTwoEntity.setTestRowDetail(resultSetTwo.getString("TEST_ROW_DETAIL"));
					testDataAppOneTableTwoEntity.setColumnA(resultSetTwo.getString("COLUMN_A"));
					testDataAppOneTableTwoEntity.setColumnB(resultSetTwo.getString("COLUMN_B"));
					testDataAppOneTableTwoEntity.setColumnC(resultSetTwo.getString("COLUMN_C"));
					testDataAppOneTableTwoEntity.setColumnD(resultSetTwo.getString("COLUMN_D"));
					testDataAppOneTableTwoEntity.setColumnE(resultSetTwo.getString("COLUMN_E"));
					
					testDataAppOneTableTwoEntityList.add(testDataAppOneTableTwoEntity);
					}

				}
				TestDataMetaAppOneEntity testDataMetaAppOneEntity=new TestDataMetaAppOneEntity();
				testDataMetaAppOneEntity.setTestDataMetaId(rs.getInt("TEST_DATA_META_ID"));
				testDataMetaAppOneEntity.setTestTableOne(rs.getInt("TEST_TABLE_ONE"));
				testDataMetaAppOneEntity.setTestTableTwo(rs.getInt("TEST_TABLE_TWO"));
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
				 
		Iterator<TestDataMetaAppOneEntity> iterator=testData.iterator();
		return iterator;
	}
}
