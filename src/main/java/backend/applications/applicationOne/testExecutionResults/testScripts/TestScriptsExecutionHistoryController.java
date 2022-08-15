package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.TestScriptsDropdownValues;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryEntity;
import backend.applications.applicationOne.testScripts.TestScriptsAppOneRepository;

@CrossOrigin
@RestController
@RequestMapping("/applications/1001/execution-summary/testScripts")
public class TestScriptsExecutionHistoryController
{
	@Autowired 
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;
	
	@PostMapping("/execution-history")
	public List<TestScriptsExecutionHistoryEntity> getTestScriptsExecutionSummary(@RequestBody  Map<String,String> requestBody)
	{
		System.out.println("SUITE ID:"+requestBody.get("suiteId"));
		List<TestScriptsExecutionHistoryEntity> testScriptsExecutionHistoryAll=testScriptsExecutionHistoryRepository.findBySuiteId(Integer.parseInt(requestBody.get("suiteId")));
		return testScriptsExecutionHistoryAll;
	}
}
