package backend.applications.applicationOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneTableEntity;

@Repository
public class TestDataMetaAppOneDaoService
{
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	public TestDataMetaAppOneTableEntity createTestDataMeta(TestDataMetaAppOneTableEntity testDataMeta)
	{
		
		TestDataMetaAppOneTableEntity newTestDataMeta = new TestDataMetaAppOneTableEntity();
		newTestDataMeta.setTestCaseId(testDataMeta.getTestCaseId());
		newTestDataMeta.setTestTableId(testDataMeta.getTestTableId());
		newTestDataMeta.setTestShortDescription(testDataMeta.getTestShortDescription());
		newTestDataMeta.setTestScenario(testDataMeta.getTestScenario());
		newTestDataMeta.setRunFlag(testDataMeta.getRunFlag());
		newTestDataMeta.setTestPriority(testDataMeta.getTestPriority());
		newTestDataMeta.setTestCategory(testDataMeta.getTestCategory());
		newTestDataMeta.setTestScriptName(testDataMeta.getTestScriptName());
		newTestDataMeta.setJiraId(testDataMeta.getJiraId());
		newTestDataMeta.setTestExecutionTime(testDataMeta.getTestExecutionTime());
		newTestDataMeta.setCreatedBy(testDataMeta.getCreatedBy());
		newTestDataMeta.setCreatedDate(testDataMeta.getCreatedDate());
		newTestDataMeta.setUpdatedBy(testDataMeta.getUpdatedBy());
		newTestDataMeta.setUpdatedDate(testDataMeta.getUpdatedDate());
		newTestDataMeta.setDeleteFlag("N");
		
		List<TestDataAppOneTableOneTableEntity> listOfNewTestDataApp=new ArrayList<TestDataAppOneTableOneTableEntity>();
		for (int i = 0; i < testDataMeta.getTestDataApp().size(); i++)
		{
			TestDataAppOneTableOneTableEntity newTestDataApp=new TestDataAppOneTableOneTableEntity();
			newTestDataApp.setTestDataMeta(newTestDataMeta);
			newTestDataApp.setTestRowDetail(testDataMeta.getTestDataApp().get(i).getTestRowDetail());
			newTestDataApp.setColumn1(testDataMeta.getTestDataApp().get(i).getColumn1());
			newTestDataApp.setColumn2(testDataMeta.getTestDataApp().get(i).getColumn2());
			newTestDataApp.setColumn3(testDataMeta.getTestDataApp().get(i).getColumn3());
			newTestDataApp.setColumn4(testDataMeta.getTestDataApp().get(i).getColumn4());
			newTestDataApp.setColumn5(testDataMeta.getTestDataApp().get(i).getColumn5());
			newTestDataApp.setDeleteFlag("N");
			
			listOfNewTestDataApp.add(newTestDataApp);
		}
		
		newTestDataMeta.setTestDataApp(listOfNewTestDataApp);
		TestDataMetaAppOneTableEntity saved = testDataMetaRepository.save(newTestDataMeta);
		
		return saved;
	}
	
	public List<TestDataMetaAppOneTableEntity> cloneTestDataMeta(TestDataMetaAppOneTableEntity testDataMetaArray[])
	{
		List<TestDataMetaAppOneTableEntity> testDataMeta = Arrays.asList(testDataMetaArray);
		List<TestDataMetaAppOneTableEntity> clonedTestDataMetaList=new ArrayList<TestDataMetaAppOneTableEntity>();
		
		for (int i = 0; i < testDataMeta.size(); i++)
		{
		TestDataMetaAppOneTableEntity newTestDataMeta = new TestDataMetaAppOneTableEntity();
		newTestDataMeta.setTestCaseId(testDataMeta.get(i).getTestCaseId());
		newTestDataMeta.setTestScenario(testDataMeta.get(i).getTestShortDescription());
		newTestDataMeta.setTestScenario(testDataMeta.get(i).getTestScenario());
		newTestDataMeta.setRunFlag(testDataMeta.get(i).getRunFlag());
		newTestDataMeta.setTestPriority(testDataMeta.get(i).getTestPriority());
		newTestDataMeta.setTestCategory(testDataMeta.get(i).getTestCategory());
		newTestDataMeta.setTestScriptName(testDataMeta.get(i).getTestScriptName());
		newTestDataMeta.setJiraId(testDataMeta.get(i).getJiraId());
		newTestDataMeta.setTestExecutionTime(testDataMeta.get(i).getTestExecutionTime());
		newTestDataMeta.setCreatedBy(testDataMeta.get(i).getCreatedBy());
		newTestDataMeta.setCreatedDate(testDataMeta.get(i).getCreatedDate());
		newTestDataMeta.setUpdatedBy(testDataMeta.get(i).getUpdatedBy());
		newTestDataMeta.setUpdatedDate(testDataMeta.get(i).getUpdatedDate());
		newTestDataMeta.setDeleteFlag("N");
		
		List<TestDataAppOneTableOneTableEntity> listOfNewTestDataApp=new ArrayList<TestDataAppOneTableOneTableEntity>();
		for (int testDataApp = 0; testDataApp < testDataMeta.get(i).getTestDataApp().size(); testDataApp++)
		{
			TestDataAppOneTableOneTableEntity newTestDataApp=new TestDataAppOneTableOneTableEntity();
			newTestDataApp.setTestDataMeta(newTestDataMeta);
			newTestDataApp.setTestRowDetail(testDataMeta.get(i).getTestDataApp().get(testDataApp).getTestRowDetail());
			newTestDataApp.setColumn1(testDataMeta.get(i).getTestDataApp().get(testDataApp).getColumn1());
			newTestDataApp.setColumn2(testDataMeta.get(i).getTestDataApp().get(testDataApp).getColumn2());
			newTestDataApp.setColumn3(testDataMeta.get(i).getTestDataApp().get(testDataApp).getColumn3());
			newTestDataApp.setColumn4(testDataMeta.get(i).getTestDataApp().get(testDataApp).getColumn4());
			newTestDataApp.setColumn5(testDataMeta.get(i).getTestDataApp().get(testDataApp).getColumn5());
			newTestDataApp.setDeleteFlag("N");
			
			listOfNewTestDataApp.add(newTestDataApp);
		}
		
		newTestDataMeta.setTestDataApp(listOfNewTestDataApp);
		TestDataMetaAppOneTableEntity saved = testDataMetaRepository.save(newTestDataMeta);
		clonedTestDataMetaList.add(saved);
	}
		return clonedTestDataMetaList;
	}
	
	
	public List<Integer> convertStringListToIntegerList(List<String> stringList)
	{
		 List<Integer> integerList = new ArrayList<>();
	        for (String string : stringList) {
	        	integerList.add(Integer.parseInt(string));
	        }
			return integerList;
	}
	
	
	public List<String> replaceNullToNullOrEmptyString(List<String> list)
	{
		if(list.contains(null))
		{
			list.set(list.indexOf(null), "Null/Blank");
		};
		
		return list;
	}
	
	
}
