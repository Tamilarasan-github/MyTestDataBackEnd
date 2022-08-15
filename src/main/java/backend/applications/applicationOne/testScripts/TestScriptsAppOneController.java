package backend.applications.applicationOne.testScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.TestScriptSearchRequest;
import backend.applications.TestScriptsDropdownValues;
import backend.applications.TestScriptsExecution;
import backend.applications.applicationOne.TestDataMetaAppOneDaoService;
import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryRepository;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataExecutionHistoryMetaEntity;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataExecutionHistoryMetaRepository;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryRepository;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryEntity;


@CrossOrigin
@RestController
@RequestMapping("/applications/1001/testscripts")
public class TestScriptsAppOneController
{		
	
	@Autowired 
	TestScriptsAppOneRepository testScriptsAppOneRepository;
	
	@Autowired
	TestDataMetaAppOneDaoService testDataDaoService;
	
	@Autowired 
	TestSuiteExecutionHistoryRepository testSuiteExecutionHistoryRepository;	
	
	@Autowired 
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;	
	
	@Autowired 
	TestDataMetaAppOneRepository testDataMetaAppOneRepository;
	
	@Autowired 
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaRepository;

	@GetMapping("/dropdownvalues")
	public TestScriptsDropdownValues getTestDataMetaDropdownValues()
	{
		TestScriptsDropdownValues testScriptsDropdownValues = new TestScriptsDropdownValues (
				testDataDaoService.convertStringListToIntegerList(testScriptsAppOneRepository.findAllDistinctTestScriptsId()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testScriptsAppOneRepository.findAllDistinctTestScripts()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testScriptsAppOneRepository.findAllDistinctTestScriptsCategory()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testScriptsAppOneRepository.findAllDistinctTestScriptsCreatedBy()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testScriptsAppOneRepository.findAllDistinctTestScriptsUpdatedBy())
				);
		System.out.println("Dropdown values:"+testScriptsDropdownValues);
		return testScriptsDropdownValues;
			
	}
	

	@PostMapping("/search")
	public List<TestScriptsEntity> searchTestScripts(@RequestBody TestScriptSearchRequest testScriptSearchRequest)
	{
		TestScriptsAppOneSpecifications testScriptsAppOneSpecifications = new TestScriptsAppOneSpecifications();
		
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScriptsId",SearchOperator.IN, testScriptSearchRequest.getTestScriptsId()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScripts",SearchOperator.IN ,testScriptSearchRequest.getTestScripts()));
		
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScriptsCategory",SearchOperator.IN,testScriptSearchRequest.getTestScriptsCategory()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testScriptSearchRequest.getCreatedBy()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("updatedBy",SearchOperator.IN,testScriptSearchRequest.getUpdatedBy()));

		List<TestScriptsEntity> filteredtestScriptsAppOneEntity = testScriptsAppOneRepository.findAll(testScriptsAppOneSpecifications);
		System.out.println("Filtered record:"+filteredtestScriptsAppOneEntity.toString());
		
		return filteredtestScriptsAppOneEntity;
		
	}
	
	
	
	@PostMapping("/addSuiteToExecution")
	public String addSuiteToExecutionList(@RequestBody TestScriptsExecution testScriptsExecution)
	{
		TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity=new TestSuiteExecutionHistoryEntity();
		
		testSuiteExecutionHistoryEntity.setSuiteName(testScriptsExecution.getSuiteName());
		testSuiteExecutionHistoryEntity.setSuiteDescription(testScriptsExecution.getSuiteName());
		testSuiteExecutionHistoryEntity.setSuiteStatus("Added");
		testSuiteExecutionHistoryEntity.setCreatedBy("Tamil");
		testSuiteExecutionHistoryEntity.setUrl(testScriptsExecution.getUrl());
		testSuiteExecutionHistoryEntity.setBrowser(testScriptsExecution.getBrowser());
		
		TestSuiteExecutionHistoryEntity testScriptsExecutionHistorySaved=testSuiteExecutionHistoryRepository.save(testSuiteExecutionHistoryEntity);
		long suiteId=testScriptsExecutionHistorySaved.getSuiteId();
		
		TestScriptsEntity[] testScripts=testScriptsExecution.getTestScripts();
		
		for(TestScriptsEntity testScript:testScripts)
		{
			TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntity=new TestScriptsExecutionHistoryEntity();
			System.out.println("suiteId inm TestScript before save:"+suiteId);
			testScriptsExecutionHistoryEntity.setSuiteId(suiteId);
			testScriptsExecutionHistoryEntity.setTestScriptsId(testScript.getTestScriptsId());
			testScriptsExecutionHistoryEntity.setTestScriptsName(testScript.getTestScripts());
			testScriptsExecutionHistoryEntity.setTestScriptsCategory(testScript.getTestScriptsCategory());
			testScriptsExecutionHistoryEntity.setTestScriptsDescription(testScript.getTestScriptsDescription());
			testScriptsExecutionHistoryEntity.setCreatedBy("Tamil");
			
			TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntitySaved=testScriptsExecutionHistoryRepository.save(testScriptsExecutionHistoryEntity);
			System.out.println("suiteId in TestScript after save:"+testScriptsExecutionHistoryEntitySaved.getSuiteId());

			long testScriptExecutionId=testScriptsExecutionHistoryEntitySaved.getTestScriptExecutionId();
		
			List<TestDataMetaAppOneEntity> testDataMetaAppOneEntityList=testDataMetaAppOneRepository.findAllByTestScriptName(testScript.getTestScripts());
			
			for(TestDataMetaAppOneEntity testDataMetaAppOneEntity:testDataMetaAppOneEntityList)
			{
			TestDataExecutionHistoryMetaEntity testDataExecutionHistoryMetaEntity=new TestDataExecutionHistoryMetaEntity();
			testDataExecutionHistoryMetaEntity.setSuiteId(suiteId);
			testDataExecutionHistoryMetaEntity.setTestScriptExecutionId(testScriptExecutionId);
			testDataExecutionHistoryMetaEntity.setTestDataMetaId(testDataMetaAppOneEntity.getTestDataMetaId());
			testDataExecutionHistoryMetaEntity.setTestCaseId(testDataMetaAppOneEntity.getTestCaseId());
			testDataExecutionHistoryMetaEntity.setTestScriptName(testDataMetaAppOneEntity.getTestScriptName());
			testDataExecutionHistoryMetaEntity.setRunFlag(testDataMetaAppOneEntity.getRunFlag());
			testDataExecutionHistoryMetaEntity.setTestScenario(testDataMetaAppOneEntity.getTestScenario());
			testDataExecutionHistoryMetaEntity.setTestPriority(Integer.parseInt(testDataMetaAppOneEntity.getTestPriority()));
			testDataExecutionHistoryMetaEntity.setTestCaseCategory(testDataMetaAppOneEntity.getTestCategory());
			testDataExecutionHistoryMetaEntity.setJiraId(testDataMetaAppOneEntity.getJiraId());
			testDataExecutionHistoryMetaEntity.setAutomatedTestStatus("Added");
			testDataExecutionHistoryMetaEntity.setUpdatedBy(testDataMetaAppOneEntity.getUpdatedBy());
			testDataExecutionHistoryMetaEntity.setDeleteFlag(testDataMetaAppOneEntity.getDeleteFlag());

			testDataExecutionHistoryMetaRepository.save(testDataExecutionHistoryMetaEntity);
			}
		}
		
		return "Suite "+suiteId+" added to execution list!";
	}
}
