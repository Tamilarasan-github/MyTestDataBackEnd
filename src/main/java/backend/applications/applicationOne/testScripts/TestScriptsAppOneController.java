package backend.applications.applicationOne.testScripts;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.DataUpdate;
import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.TestScriptSearchRequest;
import backend.applications.TestScriptsDropdownValues;
import backend.applications.TestScriptsExecution;
import backend.applications.applicationOne.TestDataMetaAppOneDaoService;
import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataMetaExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataExecutionHistoryMetaRepository;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryRepository;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryRepository;
import backend.utils.Utils;


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
	TestScriptsAppOneService testScriptsAppOneService;
	
	@Autowired 
	TestSuiteExecutionHistoryRepository testSuiteExecutionHistoryRepository;	
	
	@Autowired 
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;	
		
	@Autowired
	TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity;
	
	@Autowired
	TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntity;
	
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
	

	@PostMapping("/save")
	public TestScriptsEntity saveTestScript(@RequestBody TestScriptsEntity testScriptsEntity)
	{
		testScriptsEntity.setTestScriptsId(null);
		TestScriptsEntity savedTestScriptsEntity=testScriptsAppOneRepository.save(testScriptsEntity);
		return savedTestScriptsEntity;
		
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteTestScript(@RequestBody TestScriptsEntity testScriptsEntity)
	{
		try
		{
			Optional<TestScriptsEntity> deleteTestScriptOptional = testScriptsAppOneRepository
					.findByTestScriptId(Integer.valueOf(testScriptsEntity.getTestScriptsId()));
			TestScriptsEntity deletedTestscript = deleteTestScriptOptional.get();
			deletedTestscript.setDeleteFlag("Y");

			TestScriptsEntity afterDeleteTestScript = testScriptsAppOneRepository.save(deletedTestscript);
			System.out.println("afterDeleteTestScript.getTestScriptsId():"+afterDeleteTestScript.getTestScriptsId());
			System.out.println("testScriptsEntity.getTestScriptsId():"+testScriptsEntity.getTestScriptsId());
			System.out.println("afterDeleteTestScript.getDeleteFlag().equalsIgnoreCase(\"Y\"):" +afterDeleteTestScript.getDeleteFlag().equalsIgnoreCase("Y"));
			
			if ((afterDeleteTestScript.getTestScriptsId().equals(testScriptsEntity.getTestScriptsId()))
					&& (afterDeleteTestScript.getDeleteFlag().equalsIgnoreCase("Y")))
			{
				return new ResponseEntity<>(
						"Test Script " + deletedTestscript.getTestScriptsId() + " deleted successfully.",
						HttpStatus.ACCEPTED);
			} else
			{
				return new ResponseEntity<>(
						"Test Script " + deletedTestscript.getTestScriptsId() + " deletion some error happened.",
						HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Unknown error might have happened", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateTestScript(@RequestBody DataUpdate dataUpdateRequest)
	{
		try
		{
			TestScriptsEntity updatedTestScriptsEntity =testScriptsAppOneService.updateTestScripts(dataUpdateRequest);
			return new ResponseEntity<TestScriptsEntity>(updatedTestScriptsEntity, HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Unknown error might have happened", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping("/search")
	public List<TestScriptsEntity> searchTestScripts(@RequestBody TestScriptSearchRequest testScriptSearchRequest)
	{
		
//		System.out.println("Session:"+request.getSession().getId());
//		
//		if(!(request.getSession()==null))
//		{
//			System.out.println(request.getSession().getAttributeNames().toString());
//			request.getSession().setAttribute("userName", "Tamilarasan S");
//		}
		
		System.out.println(testScriptSearchRequest.toString());
		TestScriptsAppOneSpecifications testScriptsAppOneSpecifications = new TestScriptsAppOneSpecifications();
		
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScriptsId",SearchOperator.IN, testScriptSearchRequest.getTestScriptsId()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScripts",SearchOperator.IN ,testScriptSearchRequest.getTestScripts()));
		
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("testScriptsCategory",SearchOperator.IN,testScriptSearchRequest.getTestScriptsCategory()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testScriptSearchRequest.getCreatedBy()));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("updatedBy",SearchOperator.IN,testScriptSearchRequest.getUpdatedBy()));
		
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("updatedDate",SearchOperator.BETWEEN_DATES,Utils.formatDate("yyyy-MM-dd", testScriptSearchRequest.getUpdatedDateFrom()),Utils.formatDate("yyyy-MM-dd", testScriptSearchRequest.getUpdatedDateTo())));
		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("createdDate",SearchOperator.BETWEEN_DATES,Utils.formatDate("yyyy-MM-dd", testScriptSearchRequest.getCreatedDateFrom()),Utils.formatDate("yyyy-MM-dd", testScriptSearchRequest.getCreatedDateTo())));

		testScriptsAppOneSpecifications.addNewSearchCriteria(new SearchCriteria("deleteFlag",SearchOperator.IN,"N"));

		
		List<TestScriptsEntity> filteredtestScriptsAppOneEntity = testScriptsAppOneRepository.findAll(testScriptsAppOneSpecifications);
		System.out.println("Filtered record:"+filteredtestScriptsAppOneEntity.toString());
		
		return filteredtestScriptsAppOneEntity;
		
	}
	
	
	
//	@PostMapping("/addSuiteToExecution")
//	public String addSuiteToExecutionList(@RequestBody TestScriptsExecution testScriptsExecution)
//	{
//		TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity=new TestSuiteExecutionHistoryEntity();
//		
//		testSuiteExecutionHistoryEntity.setSuiteName(testScriptsExecution.getSuiteName());
//		testSuiteExecutionHistoryEntity.setSuiteDescription(testScriptsExecution.getSuiteName());
//		testSuiteExecutionHistoryEntity.setSuiteStatus("Added");
//		testSuiteExecutionHistoryEntity.setExecutedBy("Tamil");
//		testSuiteExecutionHistoryEntity.setUrl(testScriptsExecution.getUrl());
//		testSuiteExecutionHistoryEntity.setBrowser(testScriptsExecution.getBrowser());
//		testSuiteExecutionHistoryEntity.setExecutedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
//		
//		TestSuiteExecutionHistoryEntity testSuiteExecutionHistorySaved=testSuiteExecutionHistoryRepository.save(testSuiteExecutionHistoryEntity);
//		long suiteId=testSuiteExecutionHistorySaved.getSuiteId();
//		
//		TestScriptsEntity[] testScripts=testScriptsExecution.getTestScripts();
//		
//		for(TestScriptsEntity testScript:testScripts)
//		{
//			TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntity=new TestScriptsExecutionHistoryEntity();
//			System.out.println("suiteId in TestScript before save:"+suiteId);
//			testScriptsExecutionHistoryEntity.setSuiteId(suiteId);
//			testScriptsExecutionHistoryEntity.setTestScriptsId(testScript.getTestScriptsId());
//			testScriptsExecutionHistoryEntity.setTestScriptsName(testScript.getTestScripts());
//			testScriptsExecutionHistoryEntity.setTestScriptsCategory(testScript.getTestScriptsCategory());
//			testScriptsExecutionHistoryEntity.setTestScriptsDescription(testScript.getTestScriptsDescription());
//			testScriptsExecutionHistoryEntity.setExecutedBy("Tamil");
//			testScriptsExecutionHistoryEntity.setExecutedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
//			
//			TestScriptsExecutionHistoryEntity testScriptsExecutionHistoryEntitySaved=testScriptsExecutionHistoryRepository.save(testScriptsExecutionHistoryEntity);
//			System.out.println("suiteId in TestScript after save:"+testScriptsExecutionHistoryEntitySaved.getSuiteId());
//
//			long testScriptExecutionId=testScriptsExecutionHistoryEntitySaved.getId();
//		
//			List<TestDataMetaAppOneEntity> testDataMetaAppOneEntityList=testDataMetaAppOneRepository.findAllByTestScriptName(testScript.getTestScripts());
//			
//			for(TestDataMetaAppOneEntity testDataMetaAppOneEntity:testDataMetaAppOneEntityList)
//			{
//			TestDataMetaExecutionHistoryEntity testDataExecutionHistoryMetaEntity=new TestDataMetaExecutionHistoryEntity();
//			testDataExecutionHistoryMetaEntity.setSuiteId(suiteId);
//			testDataExecutionHistoryMetaEntity.setTestScriptExecutionId(testScriptExecutionId);
//			testDataExecutionHistoryMetaEntity.setTestDataMetaId(testDataMetaAppOneEntity.getTestDataMetaId());
//			testDataExecutionHistoryMetaEntity.setTestCaseId(testDataMetaAppOneEntity.getTestCaseId());
//			testDataExecutionHistoryMetaEntity.setTestScriptName(testDataMetaAppOneEntity.getTestScriptName());
//			testDataExecutionHistoryMetaEntity.setRunFlag(testDataMetaAppOneEntity.getRunFlag());
//			testDataExecutionHistoryMetaEntity.setTestScenario(testDataMetaAppOneEntity.getTestScenario());
//			testDataExecutionHistoryMetaEntity.setTestPriority(Integer.parseInt(testDataMetaAppOneEntity.getTestPriority()));
//			testDataExecutionHistoryMetaEntity.setTestCaseCategory(testDataMetaAppOneEntity.getTestCategory());
//			testDataExecutionHistoryMetaEntity.setJiraId(testDataMetaAppOneEntity.getJiraId());
//			testDataExecutionHistoryMetaEntity.setAutomatedTestStatus("Added");
//			testDataExecutionHistoryMetaEntity.setUpdatedBy(testDataMetaAppOneEntity.getUpdatedBy());
//			testDataExecutionHistoryMetaEntity.setExecutedOn(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
//			testDataExecutionHistoryMetaEntity.setDeleteFlag(testDataMetaAppOneEntity.getDeleteFlag());
//
//			testDataExecutionHistoryMetaRepository.save(testDataExecutionHistoryMetaEntity);
//			}
//		}
//		
//		return "Suite "+suiteId+" added to execution list!";
//	}
}
