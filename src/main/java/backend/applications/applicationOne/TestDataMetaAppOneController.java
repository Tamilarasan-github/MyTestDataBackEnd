package backend.applications.applicationOne;

import java.util.List;
import java.util.Optional;

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
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;
import backend.applications.tables.TestTablesInfo;
import backend.applications.tables.TestTablesInfoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications/1001")
public class TestDataMetaAppOneController
{
	final long tableId=2000;
	
	@Autowired
	TestDataMetaAppOneEntity testDataMeta;
	
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	@Autowired
	TestDataAppOneTableOneRepository testDataAppRepository;
	
	@Autowired
	TestDataMetaAppOneDaoService testDataDaoService;
	
	@Autowired
	TestTablesInfoRepository testTablesInfoRepository;
	
	@GetMapping("/tables")
	public List<TestTablesInfo> getTablesList()
	{
		System.out.println("Application ID requested is 1001");
		Optional<List<TestTablesInfo>> tablesListOptional= testTablesInfoRepository.findByTestApplicationsInfoAndDeleteFlag(1001,"N");
		
		List<TestTablesInfo> tablesList= tablesListOptional.get();
		System.out.println("tablesList of 1001:" +tablesList);
		
		return tablesList;
	}
	
	@GetMapping("/tables/2000/dropdownvalues")
	public TestDataMetaDropdownValues getTestDataMetaDropdownValues()
	{
		TestDataMetaDropdownValues testDataMetaDropdownValues = new TestDataMetaDropdownValues (
				testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctTestDataMetaId()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCaseId()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestShortDescription()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctRunFlag()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestPriority()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCategory()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestScriptName()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctJiraId()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctCreatedBy()),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctUpdatedBy())
				);
		System.out.println("Dropdown values:"+testDataMetaDropdownValues);
		return testDataMetaDropdownValues;
			
	}
	
	@PostMapping("/tables/2000/search")
	public List<TestDataMetaAppOneEntity> getTestData(@RequestBody TestDataSearchRequest testDataSearchRequest)
	{
	
		System.out.println("TABLE ID: "+tableId+" - "+testDataSearchRequest.toString());
		
		for (long testDataMetaId: testDataSearchRequest.getTestDataMetaId())
		{
			System.out.println("Requested Test Data Meta ID:"+testDataMetaId);
		}
		
		
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		
		
		//testDataMetaSpecs.addNewSearchCriteria(new SearchCriteria("testTableOne",SearchOperator.IN,2001));

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
}
