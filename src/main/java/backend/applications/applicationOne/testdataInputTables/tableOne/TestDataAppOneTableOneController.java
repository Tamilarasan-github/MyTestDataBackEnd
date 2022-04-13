package backend.applications.applicationOne.testdataInputTables.tableOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.SearchCriteria;
import backend.applications.TestDataMetaDropdownValues;
import backend.applications.TestDataSearchRequest;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.TestDataMetaAppOneDaoService;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.TestDataMetaAppOneSpecifications;
import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications/1001/tables/2001")
public class TestDataAppOneTableOneController
{
	final long tableId=2001;
	
	@Autowired
	TestDataMetaAppOneEntity testDataMeta;
	
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	@Autowired
	TestDataAppOneTableOneRepository testDataAppRepository;
	
	@Autowired
	TestDataMetaAppOneDaoService testDataDaoService;
	
	@GetMapping("/dropdownvalues")
	public TestDataMetaDropdownValues getTestDataMetaDropdownValues()
	{
		return new TestDataMetaDropdownValues (
				testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctTestDataMetaIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCaseIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestShortDescriptionByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctRunFlagByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestPriorityByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCategoryByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestScriptNameByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctJiraIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctCreatedByByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctUpdatedByByTestTableOne(tableId))
				);
			
	}
	
	
	@PostMapping("/search")
	public List<TestDataMetaAppOneEntity> getTestData(@RequestBody TestDataSearchRequest testDataSearchRequest)
	{
		System.out.println("TABLE ID: "+tableId+" - "+testDataSearchRequest.toString());
		
		for (long testDataMetaId: testDataSearchRequest.getTestDataMetaId())
		{
			System.out.println("Requested Test Data Meta ID:"+testDataMetaId);
		}
		
		
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testTableOne",SearchOperator.IN,2001));

		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testDataMetaId",SearchOperator.IN, testDataSearchRequest.getTestDataMetaId()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testCaseId",SearchOperator.IN ,testDataSearchRequest.getTestCaseId()));
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("jiraId",SearchOperator.IN,testDataSearchRequest.getJiraId()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("runFlag",SearchOperator.IN,testDataSearchRequest.getRunFlag()));
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testScriptName",SearchOperator.IN,testDataSearchRequest.getTestScriptName()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testShortDescription",SearchOperator.IN,testDataSearchRequest.getTestShortDescription()));
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testPriority",SearchOperator.IN,testDataSearchRequest.getTestPriority())); 
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testCategory",SearchOperator.IN,testDataSearchRequest.getTestCategory())); 	
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testDataSearchRequest.getCreatedBy()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("createdDate",SearchOperator.IN,testDataSearchRequest.getCreatedFrom(),testDataSearchRequest.getCreatedTo()));
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("updatedBy",SearchOperator.IN,testDataSearchRequest.getUpdatedBy()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("updatedDate",SearchOperator.IN,testDataSearchRequest.getUpdatedFrom(),testDataSearchRequest.getUpdatedTo()));

		List<TestDataMetaAppOneEntity> filteredTestDataMeta=testDataMetaRepository.findAll(testDataMetaSpecs);
		System.out.println("Filtered record:"+filteredTestDataMeta.toString());
		
		return filteredTestDataMeta;
	}
	
	
	@PostMapping("/clone")
	public List<TestDataMetaAppOneEntity> cloneTestData(@RequestBody TestDataMetaAppOneEntity[] testDataMeta)
	{
		for (int i = 0; i < testDataMeta.length; i++)
		{
			System.out.println("Requested to Clone:"+testDataMeta[i].getTestDataMetaId());
		}
		
		return testDataDaoService.cloneTestDataMeta(2001, testDataMeta);
	}
	
	@PostMapping("/create")
	public TestDataMetaAppOneEntity createTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		return testDataDaoService.createTestDataMeta(testDataMeta);
	}
	
	@PatchMapping("/update")
	public TestDataMetaAppOneEntity updateTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		System.out.println("Update requested:"+testDataMeta.toString());
		return testDataDaoService.updateTestDataMeta(2001, testDataMeta);
	}
	
	@PutMapping("/bulkupdate")
	public void bulkUpdateTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		
	}
	
	@PutMapping("/delete")
	public List<String> deleteTestData(@RequestBody TestDataMetaAppOneEntity[] testDataMeta)
	{
		for (int i = 0; i < testDataMeta.length; i++)
		{
			System.out.println("Requested to delete:"+testDataMeta[i].getTestDataMetaId());
		}
		return testDataDaoService.deleteTestDataMeta(tableId, testDataMeta);
		
	}
}
