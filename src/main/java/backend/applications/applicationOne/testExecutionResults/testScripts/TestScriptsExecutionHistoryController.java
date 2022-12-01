package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.SearchCriteria;
import backend.applications.TestScriptsDropdownValues;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistorySpecifications;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionSearchModel;
import backend.applications.applicationOne.testScripts.TestScriptsAppOneRepository;

@CrossOrigin
@RestController
@RequestMapping("/applications/1001/execution-summary")
public class TestScriptsExecutionHistoryController
{
	@Autowired 
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;
	
//	@Autowired
//	TestScriptsExecutionHistorySpecifications testScriptsExecutionHistorySpecifications;

	@GetMapping("/suites/{suiteExecutionId}/testScripts")
	public List<TestScriptsExecutionHistoryEntity> getTestScriptsExecutionSummary(@PathVariable("suiteExecutionId") String suiteExecutionId)
	{
		System.out.println("SUITE EXECUTION ID:"+suiteExecutionId);
		List<TestScriptsExecutionHistoryEntity> testScriptsExecutionHistoryAll=testScriptsExecutionHistoryRepository.findBySuiteExecutionId(Integer.parseInt(suiteExecutionId));
		return testScriptsExecutionHistoryAll;
	}
	
	@PostMapping("/testscripts/search")
	@ResponseBody
	public ResponseEntity<List<TestScriptsExecutionHistoryEntity>> fetchTestScriptsExecutionSummary(
			@RequestParam(name = "page") int page, 
			@RequestParam(name = "size") int size,
			@RequestParam(name = "sort") String sort,
			@RequestBody TestScriptExecutionHistorySearchModel testScriptExecutionHistorySearchModel)
	{
		System.out.println("testSuiteExecutionSearch Request:"+testScriptExecutionHistorySearchModel.toString());
		Pageable paging = PageRequest.of(
				page, size, Sort.by(sort).descending());
		
		TestScriptsExecutionHistorySpecifications testScriptsExecutionHistorySpecifications=new TestScriptsExecutionHistorySpecifications();
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testScriptExecutionId", SearchOperator.EQUALS_TO, testScriptExecutionHistorySearchModel.getTestScriptsExecutionId()));
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testScriptsId", SearchOperator.EQUALS_TO, testScriptExecutionHistorySearchModel.getTestScriptId()));
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("suiteId", SearchOperator.EQUALS_TO, testScriptExecutionHistorySearchModel.getSuiteId()));
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testScriptsCategory", SearchOperator.IN, testScriptExecutionHistorySearchModel.getTestScriptsCategory()));
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("createdBy", SearchOperator.IN, testScriptExecutionHistorySearchModel.getCreatedBy()));
		testScriptsExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("createdDate", SearchOperator.BETWEEN_DATES, testScriptExecutionHistorySearchModel.getCreatedDateFrom(), testScriptExecutionHistorySearchModel.getCreatedDateTo()));
				
		Page<TestScriptsExecutionHistoryEntity> pageRecords=testScriptsExecutionHistoryRepository.findAll(testScriptsExecutionHistorySpecifications, paging);
		
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
		
		List<TestScriptsExecutionHistoryEntity> filteredRecords=pageRecords.toList();
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
	
}
