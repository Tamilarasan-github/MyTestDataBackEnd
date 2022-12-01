package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.TestDataMetaAppOneSpecifications;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataExecutionHistoryMetaRepository;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataMetaExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryRepository;
import backend.applications.applicationOne.testScripts.TestScriptsAppOneRepository;

@Service
public class TestSuiteExecutionHistoryService
{
	
	@Autowired
	TestSuiteExecutionHistoryRepository testSuiteExecutionHistoryRepository;
	
	@Autowired
	TestScriptsAppOneRepository testScriptsAppOneRepository;
	
	@Autowired
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;
		
	@Autowired
	TestDataMetaAppOneRepository testDataMetaAppOneRepository;
	
	@Autowired
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaRepository;
	
	public static List<Integer> suiteToBeExecuted = new ArrayList<Integer>();
	public static Map<Integer, ExecutionInputValues[]> suiteExecutionInputValues = new HashMap<Integer, ExecutionInputValues[]>();

	public TestSuiteExecutionHistoryEntity saveTestSuiteExecutionInfo(TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity)
	{
		return testSuiteExecutionHistoryRepository.save(testSuiteExecutionHistoryEntity);	
	}
	
	public TestDataMetaAppOneSpecifications getTestDataMetaAppOneSpecificationsWithTestDataFilter(TestDataFilter testDataFilter)
	{
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("runFlag",SearchOperator.IN,testDataFilter.getRunFlag()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testCategory",SearchOperator.IN,testDataFilter.getTestCategory()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testPriority",SearchOperator.IN,testDataFilter.getRunFlag()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testDataFilter.getCreatedBy()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdDate",SearchOperator.BETWEEN_DATES,testDataFilter.getCreatedDateFrom(),testDataFilter.getCreatedDateTo()));
		return testDataMetaSpecs;
	}
	
	@Async
	public void runTestSuite()
	{
		
		Iterator<Integer> iterator = suiteToBeExecuted.iterator();
		
		while(iterator.hasNext())
		{
			int suiteExecutionId = iterator.next();

			Optional<TestSuiteExecutionHistoryEntity> testSuiteExecutionOptional = testSuiteExecutionHistoryRepository
					.findById(suiteExecutionId);
			TestSuiteExecutionHistoryEntity testSuiteExecution = testSuiteExecutionOptional.get();
			try
			{

				ExecutionInputValues[] executionInputValues = suiteExecutionInputValues.get(suiteExecutionId);

				if (testSuiteExecution.getSuiteStatus().equalsIgnoreCase("Queued"))
				{
					testSuiteExecution.setSuiteStatus("In-Progress");
					testSuiteExecution.setUpdatedDate(new Date());
					testSuiteExecution.setUpdatedBy("System");
					testSuiteExecutionHistoryRepository.save(testSuiteExecution);

					List<TestScriptsExecutionHistoryEntity> testScriptsExecutionHistoryEntity = testScriptsExecutionHistoryRepository
							.findBySuiteExecutionId(testSuiteExecution.getExecutionId());

					int numOfTestScriptsRequested = testScriptsExecutionHistoryEntity.size();
					System.out.println("Num of Testscripts requested:" + numOfTestScriptsRequested);

					XmlSuite suite = new XmlSuite();
					suite.setName(testSuiteExecution.getSuiteName());

					HashMap<String, String> testngParams = new HashMap<String, String>();
					testngParams.put("browserName", testSuiteExecution.getBrowser());
					testngParams.put("suiteId", String.valueOf(testSuiteExecution.getSuiteId()));
					testngParams.put("suiteName", testSuiteExecution.getSuiteName());
					testngParams.put("url", testSuiteExecution.getUrl());

					for (ExecutionInputValues inputValues : executionInputValues)
					{
						testngParams.put(inputValues.getKey(), inputValues.getValue());
					}
					suite.setParameters(testngParams);

					XmlTest test = new XmlTest(suite);
					test.setName(testSuiteExecution.getSuiteName());

					List<XmlClass> classes = new ArrayList<XmlClass>();

					for (int testScriptNum = 0; testScriptNum < numOfTestScriptsRequested; testScriptNum++)
					{
						String testScriptRequested = testScriptsExecutionHistoryEntity.get(testScriptNum)
								.getTestScriptsName();

						classes.add(new XmlClass("testScripts." + testScriptRequested));
					}

					test.setXmlClasses(classes);

					List<XmlSuite> suites = new ArrayList<XmlSuite>();
					suites.add(suite);
					TestNG testNG = new TestNG();
					testNG.setXmlSuites(suites);

					testNG.run();
					testSuiteExecution.setSuiteStatus("Completed");
					testSuiteExecution.setUpdatedDate(new Date());
					testSuiteExecution.setUpdatedBy("System");
					testSuiteExecutionHistoryRepository.save(testSuiteExecution);
					System.out.println(testSuiteExecution.getExecutionId() + "Suite execution Completed!");
				}
			} catch (Exception e)
			{
				testSuiteExecution.setSuiteStatus("Error");
				testSuiteExecution.setUpdatedDate(new Date());
				testSuiteExecution.setUpdatedBy("System");
				testSuiteExecutionHistoryRepository.save(testSuiteExecution);
				System.out.println(testSuiteExecution.getExecutionId() + "Suite execution Errorrrrrr! " + e);
			} finally
			{
				suiteExecutionInputValues.remove(suiteExecutionId);
				iterator.remove();
			}

			for (Integer suiteOnTheList : suiteToBeExecuted)
			{
				System.out.println("Suite yet to be executed :" + suiteOnTheList);
			}
		}
		  
		}	
	

}
