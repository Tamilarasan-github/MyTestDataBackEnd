package backend.applications.applicationOne.testdataInputTables.tableOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import backend.applications.applicationOne.TestDataMetaAppOneTableEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications/1001/tables/2001")
public class TestDataAppOneTableOneController
{
	final long tableId=2001;
	
	@Autowired
	TestDataMetaAppOneTableEntity testDataMeta;
	
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
				testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctOfTestDataMetaId(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfTestCaseId(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfTestShortDescription(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfRunFlag(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfTestPriority(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfTestCategory(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfTestScriptName(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfJiraId(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfCreatedBy(tableId)),
				testDataDaoService.replaceNullToNullOrEmptyString(testDataMetaRepository.findAllDistinctOfUpdatedBy(tableId))
				);
			
	}
	
	@GetMapping("/headers")
	public TestDataMetaAppOneTableEntity getRandomFirstRecord()
	{
		System.out.println(tableId+" is requested");
		return testDataMetaRepository.getRandomFirstRecord(tableId);
	}
	
	@PostMapping("/search")
	public List<TestDataMetaAppOneTableEntity> getTestData(@RequestBody TestDataSearchRequest testDataSearchRequest)
	{
		System.out.println("TABLE ID: "+tableId+" - "+testDataSearchRequest);
	
		
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		
		
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testTableId",SearchOperator.IN,tableId));

		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testDataMetaId",SearchOperator.IN, testDataSearchRequest.getTestDataMetaId()));
		testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testCaseId",SearchOperator.IN ,testDataSearchRequest.getTestcaseId()));
		
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

		return testDataMetaRepository.findAll(testDataMetaSpecs);
	}
	
	
	@PostMapping("/clone")
	public List<TestDataMetaAppOneTableEntity> cloneTestData(@RequestBody TestDataMetaAppOneTableEntity[] testDataMeta)
	{
		return testDataDaoService.cloneTestDataMeta(testDataMeta);
	}
	
	@PostMapping("/create")
	public TestDataMetaAppOneTableEntity createTestData(@RequestBody TestDataMetaAppOneTableEntity testDataMeta)
	{
		return testDataDaoService.createTestDataMeta(testDataMeta);
	}
	
	@PutMapping("/update")
	public void updateTestData(@RequestBody TestDataMetaAppOneTableEntity testDataMeta)
	{
		
	}
	
	@PutMapping("/bulkupdate")
	public void bulkUpdateTestData(@RequestBody TestDataMetaAppOneTableEntity testDataMeta)
	{
		
	}
	
	@DeleteMapping("/delete")
	public void deleteTestData(@RequestBody TestDataMetaAppOneTableEntity testDataMeta)
	{
		
	}
}
