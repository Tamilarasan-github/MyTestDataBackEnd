package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptExecutionHistorySearchModel;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistorySpecifications;

@CrossOrigin
@RestController
@RequestMapping("/applications/1001/execution-summary")
public class TestDataExecutionHistoryMetaController
{
	@Autowired
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaRepository;
	
	@PostMapping("/execution-history")
	public List<TestDataMetaExecutionHistoryEntity> getTestScriptsExecutionSummary(@RequestBody  Map<String,String> requestBody)
	{
		System.out.println("TestScriptExecutionID:"+requestBody.get("testScriptExecutionId"));
		List<TestDataMetaExecutionHistoryEntity> testDataExecutionHistoryMetaEntity=testDataExecutionHistoryMetaRepository.findByTestScriptExecutionId(Integer.parseInt(requestBody.get("testScriptExecutionId")));
		System.out.println("Test Data Exec History size:"+testDataExecutionHistoryMetaEntity.size());
		return testDataExecutionHistoryMetaEntity;
	}

	@PostMapping("/testdata/search")
	@ResponseBody
	public ResponseEntity<List<TestDataMetaExecutionHistoryEntity>> fetchTestDataExecutionSummary(
			@RequestParam(name = "page") int page, 
			@RequestParam(name = "size") int size,
			@RequestParam(name = "sort") String sort,
			@RequestBody TestDataExecutionHistorySearchModel testDataExecutionHistorySearchModel)
	{
		System.out.println("testDataExecutionHistorySearch Request:"+testDataExecutionHistorySearchModel.toString());
		Pageable paging = PageRequest.of(
				page, size, Sort.by(sort).descending());
		
		TestDataExecutionHistorySpecifications testDataExecutionHistorySpecifications=new TestDataExecutionHistorySpecifications();
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testDataExecutionId", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getTestDataExecutionId()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("suiteId", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getSuiteId()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testScriptExecutionId", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getTestScriptExecutionId()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testDataMetaId", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getTestDataMetaId()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testScriptName", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getTestScripts()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("testCaseCategory", SearchOperator.IN, testDataExecutionHistorySearchModel.getTestCategory()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("jiraId", SearchOperator.EQUALS_TO, testDataExecutionHistorySearchModel.getJiraStory()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("executedOn", SearchOperator.BETWEEN_DATES, testDataExecutionHistorySearchModel.getExecutedDateFrom(), testDataExecutionHistorySearchModel.getExecutedDateTo()));
		testDataExecutionHistorySpecifications.addNewTestSuiteExecutionHistorySpecifications(new SearchCriteria("executedBy", SearchOperator.IN, testDataExecutionHistorySearchModel.getExecutedBy()));

		Page<TestDataMetaExecutionHistoryEntity> pageRecords=testDataExecutionHistoryMetaRepository.findAll(testDataExecutionHistorySpecifications, paging);
		
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
		
		List<TestDataMetaExecutionHistoryEntity> filteredRecords=pageRecords.toList();
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
