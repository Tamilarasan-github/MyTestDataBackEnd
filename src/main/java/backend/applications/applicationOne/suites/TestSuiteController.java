package backend.applications.applicationOne.suites;

import java.util.ArrayList;
import java.util.HashMap;
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
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryRepository;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionRequestModel;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionSearchModel;
import backend.applications.applicationOne.testScripts.TestScriptsAppOneRepository;
import backend.applications.applicationOne.testScripts.TestScriptsEntity;
import backend.utils.Utils;
@CrossOrigin
@Controller
@RequestMapping("/applications/1001/suites")
public class TestSuiteController
{
		
	@Autowired
	TestSuiteRepository testSuiteRepository;
	
	@Autowired
	TestSuiteService testSuiteService;
	
	@Autowired
	TestScriptsAppOneRepository testScriptsAppOneRepository;
	
	@Autowired
	TestSuiteTestScriptsMapperRepository testSuiteTestScriptsMapperRepository;
	
				
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<TestSuiteEntity>> fetchTestSuites(
			@RequestParam(name = "page") int page, 
			@RequestParam(name = "size") int size,
			@RequestParam(name = "sort") String sort,
			@RequestBody TestSuiteSearchModel testSuiteSearchModel)
	{
		System.out.println("Suite Request:"+testSuiteSearchModel.toString());
		Pageable paging = PageRequest.of(
				page, size, Sort.by(sort).ascending());
		
		TestSuiteSpecifications testSuiteExecutionHistorySpecs=new TestSuiteSpecifications();
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("suiteName", SearchOperator.EQUALS_TO, testSuiteSearchModel.getSuiteName()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("suiteId", SearchOperator.EQUALS_TO, testSuiteSearchModel.getSuiteId()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("createdBy", SearchOperator.IN, testSuiteSearchModel.getCreatedBy()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("createdDate", SearchOperator.BETWEEN_DATES, testSuiteSearchModel.getCreatedDateFrom(), testSuiteSearchModel.getCreatedDateTo()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("updatedBy", SearchOperator.IN, testSuiteSearchModel.getCreatedBy()));
		testSuiteExecutionHistorySpecs.addNewTestSuiteSpecifications(new SearchCriteria("updatedDate", SearchOperator.BETWEEN_DATES, testSuiteSearchModel.getUpdatedDateFrom(), testSuiteSearchModel.getUpdatedDateTo()));
		
		Page<TestSuiteEntity> pageRecords=testSuiteRepository.findAll(testSuiteExecutionHistorySpecs, paging);
		
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
		
		List<TestSuiteEntity> filteredRecords=pageRecords.toList();
		System.out.println("TestSuiteEntity Filtered records:"+filteredRecords);
		
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
	
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<TestSuiteEntity> createSuite(@RequestBody TestSuiteCreateRequestModel testSuiteCreateRequestModel)
	{
		//TestSuiteEntity savedTestSuiteEntity =null;
		System.out.println("testSuiteCreateRequestModel:"+testSuiteCreateRequestModel.toString());
		TestSuiteEntity request=testSuiteCreateRequestModel.getSuiteInfo();
				
		TestSuiteEntity savedTestSuiteEntity=testSuiteService.createSuite(request);
		long suiteId=savedTestSuiteEntity.getSuiteId();
		System.out.println("New Suite ID:"+suiteId);
		
		try {
		testSuiteService.mapTestScriptsToSuite(suiteId, testSuiteCreateRequestModel.getTestScripts());
		}
		catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.internalServerError().body(savedTestSuiteEntity);
		}
		return ResponseEntity.ok()
		    .body(savedTestSuiteEntity);
	}
	
	@GetMapping("/testscripts/{suiteId}")
	@ResponseBody
	public ResponseEntity<List<TestScriptsEntity>> getTestScriptsBySuiteId(@PathVariable String suiteId)
	{
		List<TestScriptsEntity> testScriptsEntityList = null;
		try
		{
		int suiteUniqueId= Integer.valueOf(suiteId);
		List<Integer> testScriptsId= testSuiteTestScriptsMapperRepository.findTestScriptsBySuiteId(suiteUniqueId);
		
		testScriptsEntityList = testScriptsAppOneRepository.findAllById(testScriptsId);
		}
		catch(Exception e)
		{
			return ResponseEntity.internalServerError().body(testScriptsEntityList);
		}
		return ResponseEntity.ok()
			    .body(testScriptsEntityList);
	}
			
}
