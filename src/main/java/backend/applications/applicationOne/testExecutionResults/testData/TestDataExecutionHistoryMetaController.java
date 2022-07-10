package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications/1001/execution-summary/testDataMeta")
public class TestDataExecutionHistoryMetaController
{
	@Autowired
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaRepository;
	
	@PostMapping("/execution-history")
	public List<TestDataExecutionHistoryMetaEntity> getTestScriptsExecutionSummary(@RequestBody  Map<String,String> requestBody)
	{
		System.out.println("TestScriptExecutionID:"+requestBody.get("testScriptExecutionId"));
		List<TestDataExecutionHistoryMetaEntity> testDataExecutionHistoryMetaEntity=testDataExecutionHistoryMetaRepository.findByTestScriptExecutionId(Integer.parseInt(requestBody.get("testScriptExecutionId")));
		System.out.println("Test Data Exec History size:"+testDataExecutionHistoryMetaEntity.size());
		return testDataExecutionHistoryMetaEntity;
	}

}
