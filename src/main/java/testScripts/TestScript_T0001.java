package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoEntity;
import listeners.MyWebDriverListener;
import wrappers.Helper;

public class TestScript_T0001 extends Helper
{
	private static Logger log = LogManager.getLogger(TestScript_T0001.class.getName());
	
	@BeforeClass
	public void setValues()
	{
		description.set("Open Google and Search");
		testcaseName.set("TestScript_T0001");
		
		testDataFileNameWithPath.set("//filename with path");
		testDataSheetName.set("sheetName..");
		
	}

	@Test(dataProvider="testDataProvider")
	public void openGoogle(TestDataMetaAppOneEntity testData)
	{
		// WebDriverManager.chromedriver().setup();
		createNewTest(testData.getTestShortDescription(), testData.getTestScenario());

		System.out.println(testData.getTestTableOne());
		System.out.println(testData.getTestTableTwo());
		
		List<TestDataAppOneTableOneEntity> testDataAppOneTableOneEntityList=testData.getTestDataAppOneTableOne();
		List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwoEntityList=testData.getTestDataAppOneTableTwo();

		openBrowser("chrome");
		getWebDriver().get(url.get());
		
		
		WebElement searchBar = getWebDriver().findElement(By.name("q"));
		
		if(testDataAppOneTableOneEntityList.size()>0)
		{
		enterTextAndClickEnter(searchBar, testDataAppOneTableOneEntityList.get(0).getColumn1(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableOneEntityList.get(0).getColumn2(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableOneEntityList.get(0).getColumn3(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableOneEntityList.get(0).getColumn4(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableOneEntityList.get(0).getColumn5(), true);
		}
		
		if(testDataAppOneTableTwoEntityList.size()>0)
		{
		enterTextAndClickEnter(searchBar, testDataAppOneTableTwoEntityList.get(0).getColumnA(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableTwoEntityList.get(0).getColumnB(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableTwoEntityList.get(0).getColumnC(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableTwoEntityList.get(0).getColumnD(), true);
//		enterTextAndClickEnter(searchBar, testDataAppOneTableTwoEntityList.get(0).getColumnE(), true);
		}
		try
		{
			Thread.sleep(13000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getWebDriver().quit();
		System.out.println("TestScript_T0001 - Completed");
	}

}
