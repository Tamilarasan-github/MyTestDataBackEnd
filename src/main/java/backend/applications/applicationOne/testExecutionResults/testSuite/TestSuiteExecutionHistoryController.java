package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import backend.applications.applicationOne.testScripts.TestScriptsEntity;
import backend.utils.Utils;
@CrossOrigin
@Controller
@RequestMapping("/applications/1001/execution-summary")
public class TestSuiteExecutionHistoryController
{
		
	@Autowired
	TestSuiteExecutionHistoryRepository testSuiteExecutionHistoryRepository;
	
	@Autowired
	TestScriptsAppOneRepository testScriptsAppOneRepository;
	
	@Autowired
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;
	
	@Autowired
	TestSuiteExecutionHistoryService testSuiteExecutionHistoryService;
	
	@Autowired
	TestDataMetaAppOneRepository testDataMetaAppOneRepository;
	
	@Autowired
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaRepository;
	
		
	@GetMapping("/suites")
	@ResponseBody
	public List<TestSuiteExecutionHistoryEntity> getTestSuitesExecutionSummary()
	{
		List<TestSuiteExecutionHistoryEntity> testSuiteExecutionHistoryAll=testSuiteExecutionHistoryRepository.findAll();
		return testSuiteExecutionHistoryAll;
	}
	
	@PostMapping("/suites/search")
	@ResponseBody
	public ResponseEntity<List<TestSuiteExecutionHistoryEntity>> fetchTestSuitesExecutionSummary(
			@RequestParam(name = "page") int page, 
			@RequestParam(name = "size") int size,
			@RequestParam(name = "sort") String sort,
			@RequestBody TestSuiteExecutionSearchModel testSuiteExecutionSearchModel)
	{
		System.out.println("testSuiteExecutionSearch Request:"+testSuiteExecutionSearchModel.toString());
		Pageable paging = PageRequest.of(
				page, size, Sort.by(sort).ascending());
		
		TestSuiteExecutionHistorySpecifications testSuiteExecutionHistorySpecs=new TestSuiteExecutionHistorySpecifications();
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("suiteName", SearchOperator.EQUALS_TO, testSuiteExecutionSearchModel.getSuiteName()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("url", SearchOperator.EQUALS_TO, testSuiteExecutionSearchModel.getUrl()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("suiteId", SearchOperator.EQUALS_TO, testSuiteExecutionSearchModel.getSuiteId()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("suiteStatus", SearchOperator.IN, testSuiteExecutionSearchModel.getSuiteStatus()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("createdBy", SearchOperator.IN, testSuiteExecutionSearchModel.getCreatedBy()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("createdDate", SearchOperator.BETWEEN_DATES, testSuiteExecutionSearchModel.getCreatedDateFrom(), testSuiteExecutionSearchModel.getCreatedDateTo()));
				
		Page<TestSuiteExecutionHistoryEntity> pageRecords=testSuiteExecutionHistoryRepository.findAll(testSuiteExecutionHistorySpecs, paging);
		
		int totalPages=pageRecords.getTotalPages();
		int numOfElements=pageRecords.getNumberOfElements();
		boolean hasNext=pageRecords.hasNext();
		boolean hasPrevious=pageRecords.hasPrevious();
		int currentPage=pageRecords.getNumber();
		
		System.out.println("totalPages:"+totalPages);
		System.out.println("numOfElements:"+numOfElements);
		System.out.println("hasNext:"+hasNext);
		System.out.println("hasPrevious:"+hasPrevious);
		System.out.println("currentPage:"+currentPage);
		
		List<TestSuiteExecutionHistoryEntity> filteredRecords=pageRecords.toList();
		System.out.println("TestSuiteExecutionHistoryEntity Filtered records:"+filteredRecords);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "*");
        headers.add("Access-Control-Allow-Headers", "*");
        
        
		headers.add("totalPages",Integer.toString(totalPages));
		headers.add("numOfElements",Integer.toString(numOfElements));
		headers.add("hasNext",Boolean.toString(hasNext));
		headers.add("hasPrevious",Boolean.toString(hasPrevious));
		headers.add("currentPage",Integer.toString(currentPage));
		
		return ResponseEntity.ok()
		        .headers(headers)
		        .body(filteredRecords);
	}
	
	
	
	@PostMapping("/testscripts/execute")
	@ResponseBody
	public ResponseEntity<List<String>> executeTestscripts(@RequestBody  TestSuiteExecutionRequestModel testSuiteExecutionRequestModel)
	{
		 // get the start time
	    long start = System.nanoTime();
	    List<String> savedList = new ArrayList<String>();
	    
		TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity = testSuiteExecutionHistoryService.saveTestSuiteExecutionInfo(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo());
		int suiteExecutionId = testSuiteExecutionHistoryEntity.getExecutionId();
		int suiteId = testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getSuiteId();
		
		 // get the start time
	    long timeAfterSuiteSave = System.nanoTime();
		 System.out.println("Execution time: To add/save one Test Suite record to Execution :" + (timeAfterSuiteSave - start)  + " nanoseconds");

		 
		Optional<TestScriptsEntity> testScriptsEntityOptional= testScriptsAppOneRepository.findByTestScriptId(suiteId); //here in this case suiteId is same as TestscriptId
		TestScriptsEntity testScriptsEntity = testScriptsEntityOptional.get();
		int testScriptId = testScriptsEntity.getTestScriptsId();
		
	    long timeAfterTestScriptFetch = System.nanoTime();
		 System.out.println("Execution time: To fetch one Test Script by ID :" + (timeAfterTestScriptFetch - start)  + " nanoseconds");

		TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntity = new TestScriptsExecutionHistoryEntity();
		testScriptsExecutionHistoryEntity.setTestScriptsId(testScriptId);
		testScriptsExecutionHistoryEntity.setSuiteExecutionId(suiteExecutionId);
		testScriptsExecutionHistoryEntity.setSuiteId(suiteId);
		testScriptsExecutionHistoryEntity.setTestScriptsName(testScriptsEntity.getTestScripts());
		testScriptsExecutionHistoryEntity.setTestScriptsCategory(testScriptsEntity.getTestScriptsCategory());
		testScriptsExecutionHistoryEntity.setTestScriptsDescription(testScriptsEntity.getTestScriptsDescription());
		testScriptsExecutionHistoryEntity.setExecutedBy(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedBy());
		testScriptsExecutionHistoryEntity.setExecutedDate(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedDate());
			
		TestScriptsExecutionHistoryEntity newTestScriptsExecutionHistoryEntity = testScriptsExecutionHistoryRepository.save(testScriptsExecutionHistoryEntity);
		int testScriptExecutionId = newTestScriptsExecutionHistoryEntity.getId();
		
		 long timeAfterNewTestScriptExecSave = System.nanoTime();
		 System.out.println("Execution time: To Add/Save one Test Script to Execution :" + (timeAfterNewTestScriptExecSave - start)  + " nanoseconds");

		 
		TestDataMetaAppOneSpecifications testDataMetaSpecs = testSuiteExecutionHistoryService.getTestDataMetaAppOneSpecificationsWithTestDataFilter(testSuiteExecutionRequestModel.getTestDataFilter());
		List<TestDataMetaAppOneEntity> testDataMetaAppOneEntity = testDataMetaAppOneRepository.findAll(testDataMetaSpecs);
		
		 long timeAfterTestDataFetch = System.nanoTime();
		 System.out.println("Execution time: To fetch All "+testDataMetaAppOneEntity.size()+" Test Data :" + (timeAfterTestDataFetch - start)  + " nanoseconds");

		List<String> failedList = new ArrayList<String>();

		testDataMetaAppOneEntity.parallelStream().forEach(testDataMeta -> {
			try
			{
				TestDataMetaExecutionHistoryEntity testDataMetaExecutionHistoryEntity = new TestDataMetaExecutionHistoryEntity();

				testDataMetaExecutionHistoryEntity.setSuiteExecutionId(suiteExecutionId);
				testDataMetaExecutionHistoryEntity.setSuiteId(suiteId);

				testDataMetaExecutionHistoryEntity.setTestScriptExecutionId(testScriptExecutionId);
				testDataMetaExecutionHistoryEntity.setTestScriptId(testScriptId);
				testDataMetaExecutionHistoryEntity.setTestScriptName(testDataMeta.getTestScriptName());

				testDataMetaExecutionHistoryEntity.setJiraId(testDataMeta.getJiraId());
				
				testDataMetaExecutionHistoryEntity.setTestCaseCategory(testDataMeta.getTestCategory());
				testDataMetaExecutionHistoryEntity.setTestCaseId(testDataMeta.getTestCategory());
				
				testDataMetaExecutionHistoryEntity.setTestDataMetaId(testDataMeta.getTestDataMetaId());
				
				testDataMetaExecutionHistoryEntity.setTestPriority(testDataMeta.getTestPriority());
				testDataMetaExecutionHistoryEntity.setTestScenario(testDataMeta.getTestScenario());

				testDataMetaExecutionHistoryEntity.setAutomatedTestStatus("Not Executed");
				testDataMetaExecutionHistoryEntity
						.setExecutedBy(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedBy());
				testDataMetaExecutionHistoryEntity
						.setExecutedOn(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedDate());
				testDataMetaExecutionHistoryEntity.setExecutionStatus("Not Executed");
				
				testDataMetaExecutionHistoryEntity.setDeleteFlag("N");

				testDataExecutionHistoryMetaRepository.save(testDataMetaExecutionHistoryEntity);
				
				savedList.add("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " added successfully to the execution queue. Other Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
				
			} 
			catch (Exception e)
			{
				System.out.println("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " failed to add to the execution queue. Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
				
				failedList.add("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " failed to add to the execution queue. Other Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
			}
		});
		 long timeAfterAllTestDataExecSave = System.nanoTime();
		 System.out.println("Execution time: To add All "+testDataMetaAppOneEntity.size()+" Test Data to Execution :" + (timeAfterAllTestDataExecSave - start)  + " nanoseconds " +(timeAfterAllTestDataExecSave - start)/1_000_000_000+" secs");
		 
		if(failedList.size()>0)
		{
			List<String> mergedList = new ArrayList<String>();
			mergedList.addAll(savedList);
			mergedList.addAll(failedList);
			
			return ResponseEntity.internalServerError()
			        .body(mergedList);
		}
		
		if(TestSuiteExecutionHistoryService.suiteToBeExecuted.size()<=0)
		{
			TestSuiteExecutionHistoryService.suiteToBeExecuted.add(suiteExecutionId);
			TestSuiteExecutionHistoryService.suiteExecutionInputValues.put(suiteExecutionId, testSuiteExecutionRequestModel.getExecutionInputValues());
			testSuiteExecutionHistoryService.runTestSuite();
		}
		else
		{
			TestSuiteExecutionHistoryService.suiteToBeExecuted.add(suiteExecutionId);
			TestSuiteExecutionHistoryService.suiteExecutionInputValues.put(suiteExecutionId, testSuiteExecutionRequestModel.getExecutionInputValues());
		}
		
		return ResponseEntity.ok()
		        .body(savedList);
	}
	
	@PostMapping("/suites/execute")
	@ResponseBody
	public ResponseEntity<List<String>> executeTestSuite(@RequestBody  TestSuiteExecutionRequestModel testSuiteExecutionRequestModel)
	{
		 // get the start time
	    long start = System.nanoTime();
	    List<String> savedList = new ArrayList<String>();
	    
		TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity = testSuiteExecutionHistoryService.saveTestSuiteExecutionInfo(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo());
		int suiteExecutionId = testSuiteExecutionHistoryEntity.getExecutionId();
		int suiteId = testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getSuiteId();
		
		 // get the start time
	    long timeAfterSuiteSave = System.nanoTime();
		 System.out.println("Execution time: To add/save one Test Suite record to Execution :" + (timeAfterSuiteSave - start)  + " nanoseconds");

		 
		Optional<TestScriptsEntity> testScriptsEntityOptional= testScriptsAppOneRepository.findByTestScriptId(suiteId); //here in this case suiteId is same as TestscriptId
		TestScriptsEntity testScriptsEntity = testScriptsEntityOptional.get();
		int testScriptId = testScriptsEntity.getTestScriptsId();
		
	    long timeAfterTestScriptFetch = System.nanoTime();
		 System.out.println("Execution time: To fetch one Test Script by ID :" + (timeAfterTestScriptFetch - start)  + " nanoseconds");

		TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntity = new TestScriptsExecutionHistoryEntity();
		testScriptsExecutionHistoryEntity.setTestScriptsId(testScriptId);
		testScriptsExecutionHistoryEntity.setSuiteExecutionId(suiteExecutionId);
		testScriptsExecutionHistoryEntity.setSuiteId(suiteId);
		testScriptsExecutionHistoryEntity.setTestScriptsName(testScriptsEntity.getTestScripts());
		testScriptsExecutionHistoryEntity.setTestScriptsCategory(testScriptsEntity.getTestScriptsCategory());
		testScriptsExecutionHistoryEntity.setTestScriptsDescription(testScriptsEntity.getTestScriptsDescription());
		testScriptsExecutionHistoryEntity.setExecutedBy(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedBy());
		testScriptsExecutionHistoryEntity.setExecutedDate(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedDate());
			
		TestScriptsExecutionHistoryEntity newTestScriptsExecutionHistoryEntity = testScriptsExecutionHistoryRepository.save(testScriptsExecutionHistoryEntity);
		int testScriptExecutionId = newTestScriptsExecutionHistoryEntity.getId();
		
		 long timeAfterNewTestScriptExecSave = System.nanoTime();
		 System.out.println("Execution time: To Add/Save one Test Script to Execution :" + (timeAfterNewTestScriptExecSave - start)  + " nanoseconds");

		 
		TestDataMetaAppOneSpecifications testDataMetaSpecs = testSuiteExecutionHistoryService.getTestDataMetaAppOneSpecificationsWithTestDataFilter(testSuiteExecutionRequestModel.getTestDataFilter());
		List<TestDataMetaAppOneEntity> testDataMetaAppOneEntity = testDataMetaAppOneRepository.findAll(testDataMetaSpecs);
		
		 long timeAfterTestDataFetch = System.nanoTime();
		 System.out.println("Execution time: To fetch All "+testDataMetaAppOneEntity.size()+" Test Data :" + (timeAfterTestDataFetch - start)  + " nanoseconds");

		List<String> failedList = new ArrayList<String>();

		testDataMetaAppOneEntity.parallelStream().forEach(testDataMeta -> {
			try
			{
				TestDataMetaExecutionHistoryEntity testDataMetaExecutionHistoryEntity = new TestDataMetaExecutionHistoryEntity();

				testDataMetaExecutionHistoryEntity.setSuiteExecutionId(suiteExecutionId);
				testDataMetaExecutionHistoryEntity.setSuiteId(suiteId);

				testDataMetaExecutionHistoryEntity.setTestScriptExecutionId(testScriptExecutionId);
				testDataMetaExecutionHistoryEntity.setTestScriptId(testScriptId);
				testDataMetaExecutionHistoryEntity.setTestScriptName(testDataMeta.getTestScriptName());

				testDataMetaExecutionHistoryEntity.setJiraId(testDataMeta.getJiraId());
				
				testDataMetaExecutionHistoryEntity.setTestCaseCategory(testDataMeta.getTestCategory());
				testDataMetaExecutionHistoryEntity.setTestCaseId(testDataMeta.getTestCategory());
				
				testDataMetaExecutionHistoryEntity.setTestDataMetaId(testDataMeta.getTestDataMetaId());
				
				testDataMetaExecutionHistoryEntity.setTestPriority(testDataMeta.getTestPriority());
				testDataMetaExecutionHistoryEntity.setTestScenario(testDataMeta.getTestScenario());

				testDataMetaExecutionHistoryEntity.setAutomatedTestStatus("Not Executed");
				testDataMetaExecutionHistoryEntity
						.setExecutedBy(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedBy());
				testDataMetaExecutionHistoryEntity
						.setExecutedOn(testSuiteExecutionRequestModel.getTestSuiteExecutionInfo().getExecutedDate());
				testDataMetaExecutionHistoryEntity.setExecutionStatus("Not Executed");
				
				testDataMetaExecutionHistoryEntity.setDeleteFlag("N");

				testDataExecutionHistoryMetaRepository.save(testDataMetaExecutionHistoryEntity);
				
				savedList.add("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " added successfully to the execution queue. Other Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
				
			} 
			catch (Exception e)
			{
				System.out.println("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " failed to add to the execution queue. Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
				
				failedList.add("Test Data Meta ID:"+testDataMeta.getTestDataMetaId()
						+ " failed to add to the execution queue. Other Info: Suite Execution ID:" + suiteExecutionId
						+ " Test Script Execution ID:" + testScriptExecutionId + " Suite Id:" + suiteId);
			}
		});
		 long timeAfterAllTestDataExecSave = System.nanoTime();
		 System.out.println("Execution time: To add All "+testDataMetaAppOneEntity.size()+" Test Data to Execution :" + (timeAfterAllTestDataExecSave - start)  + " nanoseconds " +(timeAfterAllTestDataExecSave - start)/1_000_000_000+" secs");
		 
		if(failedList.size()>0)
		{
			List<String> mergedList = new ArrayList<String>();
			mergedList.addAll(savedList);
			mergedList.addAll(failedList);
			
			return ResponseEntity.internalServerError()
			        .body(mergedList);
		}
		
		if(TestSuiteExecutionHistoryService.suiteToBeExecuted.size()<=0)
		{
			TestSuiteExecutionHistoryService.suiteToBeExecuted.add(suiteExecutionId);
			TestSuiteExecutionHistoryService.suiteExecutionInputValues.put(suiteExecutionId, testSuiteExecutionRequestModel.getExecutionInputValues());
			testSuiteExecutionHistoryService.runTestSuite();
		}
		else
		{
			TestSuiteExecutionHistoryService.suiteToBeExecuted.add(suiteExecutionId);
			TestSuiteExecutionHistoryService.suiteExecutionInputValues.put(suiteExecutionId, testSuiteExecutionRequestModel.getExecutionInputValues());
		}
		
		return ResponseEntity.ok()
		        .body(savedList);
	}
			
	@PostMapping("/cancel")
	@ResponseBody
	public String cancelSuiteExecution(@RequestBody  Map<String,String> requestBody)
	{

		String suiteId=String.valueOf(requestBody.get("suiteName"));
		
		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		//Iterate over set to find yours
		for(Thread thread : setOfThread)
		{
			System.out.println("Thread:"+thread.getName());
		    if(thread.getName()==suiteId)
		    {
		    	System.out.println("Thread Name matched:"+suiteId);
		        thread.interrupt();
		    }
		}
		return suiteId+" execution is stopped!";
	}
	
	@GetMapping("/view-report/{suiteId}")
	public String viewReport(@PathVariable("suiteId") String suiteId)
	{
		System.out.println("View Report:"+suiteId);
		return suiteId;

	}

	
}
