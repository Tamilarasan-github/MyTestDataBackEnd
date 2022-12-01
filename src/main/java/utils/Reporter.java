package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Reporter
{

	private static Logger log=LogManager.getLogger(Reporter.class.getName());
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public static ExtentReports extentReport;
//	public ExtentTest extentTest;

	public static synchronized void startExtentReport()
	{
		String pattern = "MM_dd_yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		String pattern2 = "MM_dd_yyyy_HH_mm_ss";
		simpleDateFormat = new SimpleDateFormat(pattern2);
		String date2 = simpleDateFormat.format(new Date());
		
		extentReport = new ExtentReports();
		String reportPath="src/main/resources/templates/";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath+"/"+date+"/"+date2+".html");
		extentReport.attachReporter(spark);
		log.debug("startExtentReport() is triggered and extent report is started");
	}
	
	public static synchronized void startExtentReport(String reportName)
	{
		String pattern = "MM_dd_yyyy_HH_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		extentReport = new ExtentReports();
		String reportPath="src/main/resources/templates/";
		ExtentSparkReporter spark;
		
		if(reportName.isBlank() || reportName.equalsIgnoreCase("0") || reportName.equalsIgnoreCase(""))
		{
			spark = new ExtentSparkReporter(reportPath+date+".html");
		}
		else
		{
			spark = new ExtentSparkReporter(reportPath+reportName+".html");
		}
		
		extentReport.attachReporter(spark);
		log.debug("startExtentReport() is triggered and extent report is started");
	}
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}

	public static synchronized ExtentTest createNewTest(String desc, String testName)
	{
		ExtentTest test = extentReport.createTest(desc, testName);
		log.debug("createNewTest(String desc, String testName) is triggered and new test is created with desc as "+desc+" and testName as "+testName);
	//	extentTestMap.put((int)Thread.currentThread().getId(), extentTest);
		extentTest.set(test);
		return getExtentTest();
	}

	public void log(Status status, String details)
	{
		if(status.equals(Status.FAIL))
		{
			getExtentTest().log(status, details, MediaEntityBuilder
					.createScreenCaptureFromPath(takeScreenshot()).build());
			log.debug("log(Status status, String details) is triggered and status is "+status+" and details are "+details);
		}
		else
		{
			getExtentTest().log(status, details);
		}
	}

	public void log(Status status, String details, boolean takeScreenshot)
	{
		if (takeScreenshot)
		{
			getExtentTest().log(status, details, MediaEntityBuilder
					.createScreenCaptureFromPath(takeScreenshot()).build());
			log.debug("log(Status status, String details, boolean takeScreenshot) is triggered and status is "+status+", details are "+details+" and takeScreenshot is "+takeScreenshot);
		} 
		else
		{
			getExtentTest().log(status, details);
		}
	}


	public static void saveReport()
	{
		extentReport.flush();
		log.debug("saveReport() is triggered and report is flushed/saved");

	}
	
	
	
	public abstract String takeScreenshot();
	
}
