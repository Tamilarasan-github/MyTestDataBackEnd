package backend.applications.applicationOne.testdataInputTables.tableTwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;

@CrossOrigin
@RestController
@RequestMapping("/applications/1000001/tables/2002")
public class TestDataAppOneTableTwoController
{
	final long tableId=2002;
	
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
				testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctTestDataMetaIdByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCaseIdByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestShortDescriptionByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctRunFlagByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestPriorityByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCategoryByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestScriptNameByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctJiraIdByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctCreatedByByTestTableTwo(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctUpdatedByByTestTableTwo(tableId))
				);
			
	}
	
	
	
	@PostMapping("/search")
	public ResponseEntity<List<TestDataMetaAppOneEntity>> getTestData(@RequestBody TestDataSearchRequest testDataSearchRequest)
	{
		System.out.println("TABLE ID: "+tableId+" - "+testDataSearchRequest);
	
		
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testTableTwo",SearchOperator.IN,2002));

		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testDataMetaId",SearchOperator.IN, testDataSearchRequest.getTestDataMetaId()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testCaseId",SearchOperator.IN ,testDataSearchRequest.getTestCaseId()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("jiraId",SearchOperator.IN,testDataSearchRequest.getJiraId()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("runFlag",SearchOperator.IN,testDataSearchRequest.getRunFlag()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testScriptName",SearchOperator.IN,testDataSearchRequest.getTestScriptName()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testShortDescription",SearchOperator.IN,testDataSearchRequest.getTestShortDescription()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testPriority",SearchOperator.IN,testDataSearchRequest.getTestPriority())); 
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testCategory",SearchOperator.IN,testDataSearchRequest.getTestCategory())); 	
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testDataSearchRequest.getCreatedBy()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdDate",SearchOperator.IN,testDataSearchRequest.getCreatedFrom(),testDataSearchRequest.getCreatedTo()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("updatedBy",SearchOperator.IN,testDataSearchRequest.getUpdatedBy()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("updatedDate",SearchOperator.IN,testDataSearchRequest.getUpdatedFrom(),testDataSearchRequest.getUpdatedTo()));

		Pageable paging = PageRequest.of(
	            0, 5, Sort.by("testDataMetaId").ascending());
		
		Page<TestDataMetaAppOneEntity> pageRecords=testDataMetaRepository.findAll(testDataMetaSpecs, paging);
		
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
		
		List<TestDataMetaAppOneEntity> filteredRecords=pageRecords.toList();
		System.out.println("Table 2002 : Test Data Filtered records:"+filteredRecords);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache");

		headers.add("totalPages",Integer.toString(totalPages));
		headers.add("numOfElements",Integer.toString(numOfElements));
		headers.add("hasNext",Boolean.toString(hasNext));
		headers.add("hasPrevious",Boolean.toString(hasPrevious));
		headers.add("currentPage",Integer.toString(currentPage));
        
        return ResponseEntity.ok()
        .headers(headers)
        .body(filteredRecords);
	}
	
	
	@PostMapping("/clone")
	public List<TestDataMetaAppOneEntity> cloneTestData(@RequestBody TestDataMetaAppOneEntity[] testDataMeta)
	{
		return testDataDaoService.cloneTestDataMeta(2002, testDataMeta);
	}
	
	@PostMapping("/create")
	public TestDataMetaAppOneEntity createTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		return testDataDaoService.createTestDataMeta(testDataMeta);
	}
	
	@PutMapping("/update")
	public void updateTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		
	}
	
	@PutMapping("/bulkupdate")
	public void bulkUpdateTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		
	}
	
	@DeleteMapping("/delete")
	public void deleteTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		
	}
}
