package backend.applications.applicationOne.suites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.applications.applicationOne.testScripts.TestScriptsEntity;

@Service
public class TestSuiteService
{
	@Autowired
	TestSuiteRepository testSuiteRepository;
	
	@Autowired
	TestSuiteTestScriptsMapperRepository testSuiteTestScriptsMapperEntityRepository;
	
	public TestSuiteEntity createSuite(TestSuiteEntity testSuiteEntity)
	{
		System.out.println("Test Suite Create Request:"+testSuiteEntity.toString());
		return testSuiteRepository.save(testSuiteEntity);		
	}

	public void mapTestScriptsToSuite(long suiteId, TestScriptsEntity[] testScripts)
	{
		for(TestScriptsEntity testScript: testScripts)
		{
		TestSuiteTestScriptsMapperEntity testSuiteTestScriptsMapperEntity = new TestSuiteTestScriptsMapperEntity();
		testSuiteTestScriptsMapperEntity.setId(null);
		testSuiteTestScriptsMapperEntity.setSuiteId((int) suiteId);
		testSuiteTestScriptsMapperEntity.setTestScriptId(testScript.getTestScriptsId());
		testSuiteTestScriptsMapperEntityRepository.save(testSuiteTestScriptsMapperEntity);
		}
	}
}
