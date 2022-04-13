package backend.applications.applicationOne;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;

@Repository
public class TestDataMetaAppOneDaoService
{
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	public TestDataMetaAppOneEntity createTestDataMeta(TestDataMetaAppOneEntity testDataMeta)
	{
		
		TestDataMetaAppOneEntity newTestDataMeta = new TestDataMetaAppOneEntity();
		newTestDataMeta.setTestCaseId(testDataMeta.getTestCaseId());
		
		newTestDataMeta.setTestTableOne(testDataMeta.getTestTableOne());
		newTestDataMeta.setTestTableTwo(testDataMeta.getTestTableTwo());
		newTestDataMeta.setTestTableThree(testDataMeta.getTestTableThree());
		
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
		
		List<TestDataAppOneTableOneEntity> listOfNewTestDataApp=new ArrayList<TestDataAppOneTableOneEntity>();
		for (int i = 0; i < testDataMeta.getTestDataAppOneTableOne().size(); i++)
		{
			TestDataAppOneTableOneEntity newTestDataApp=new TestDataAppOneTableOneEntity();
			newTestDataApp.setTestDataMeta(newTestDataMeta);
			newTestDataApp.setTestRowDetail(testDataMeta.getTestDataAppOneTableOne().get(i).getTestRowDetail());
			newTestDataApp.setColumn1(testDataMeta.getTestDataAppOneTableOne().get(i).getColumn1());
			newTestDataApp.setColumn2(testDataMeta.getTestDataAppOneTableOne().get(i).getColumn2());
			newTestDataApp.setColumn3(testDataMeta.getTestDataAppOneTableOne().get(i).getColumn3());
			newTestDataApp.setColumn4(testDataMeta.getTestDataAppOneTableOne().get(i).getColumn4());
			newTestDataApp.setColumn5(testDataMeta.getTestDataAppOneTableOne().get(i).getColumn5());
			newTestDataApp.setDeleteFlag("N");
			
			listOfNewTestDataApp.add(newTestDataApp);
		}
		
		newTestDataMeta.setTestDataAppOneTableOne(listOfNewTestDataApp);
		TestDataMetaAppOneEntity saved = testDataMetaRepository.save(newTestDataMeta);
		
		return saved;
	}
	
	public List<TestDataMetaAppOneEntity> cloneTestDataMeta(long testTableId, TestDataMetaAppOneEntity testDataMetaArray[])
	{
		List<TestDataMetaAppOneEntity> testDataMeta = Arrays.asList(testDataMetaArray);
		List<TestDataMetaAppOneEntity> clonedTestDataMetaList=new ArrayList<TestDataMetaAppOneEntity>();
		
		for (int i = 0; i < testDataMeta.size(); i++)
		{
		TestDataMetaAppOneEntity newTestDataMeta = new TestDataMetaAppOneEntity();
		
		
		newTestDataMeta.setTestTableOne(testDataMeta.get(i).getTestTableOne());
		newTestDataMeta.setTestTableTwo(testDataMeta.get(i).getTestTableTwo());
		newTestDataMeta.setTestTableThree(testDataMeta.get(i).getTestTableThree());
		
		
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
						
		List<TestDataAppOneTableOneEntity> listOfNewTestDataApp=new ArrayList<TestDataAppOneTableOneEntity>();
		for (int testDataApp = 0; testDataApp < testDataMeta.get(i).getTestDataAppOneTableOne().size(); testDataApp++)
		{
			TestDataAppOneTableOneEntity newTestDataApp=new TestDataAppOneTableOneEntity();
			newTestDataApp.setTestDataMeta(newTestDataMeta);
			newTestDataApp.setTestRowDetail(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getTestRowDetail());
			newTestDataApp.setColumn1(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn1());
			newTestDataApp.setColumn2(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn2());
			newTestDataApp.setColumn3(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn3());
			newTestDataApp.setColumn4(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn4());
			newTestDataApp.setColumn5(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn5());
	
			newTestDataApp.setDeleteFlag("N");
			
			listOfNewTestDataApp.add(newTestDataApp);
		}
		
		newTestDataMeta.setTestDataAppOneTableOne(listOfNewTestDataApp);
		TestDataMetaAppOneEntity storedTestDataMeta = testDataMetaRepository.save(newTestDataMeta);
		
		clonedTestDataMetaList.add(storedTestDataMeta);
	}
		for (TestDataMetaAppOneEntity testDataMetaAppOneTableEntity : clonedTestDataMetaList)
		{
			System.out.println("Cloned TestDataMeta ID:"+testDataMetaAppOneTableEntity.getTestDataMetaId());
			
			for (TestDataAppOneTableOneEntity TestDataAppOneTableOneTableEntity : testDataMetaAppOneTableEntity.getTestDataAppOneTableOne())
			{
				System.out.println("Cloned TestDataID:"+TestDataAppOneTableOneTableEntity.getTestDataId());
			}
		}
		
		return clonedTestDataMetaList;
	}
	
	public List<String> deleteTestDataMeta(long testTableId, TestDataMetaAppOneEntity testDataMetaArray[])
	{
		List<TestDataMetaAppOneEntity> testDataMeta = Arrays.asList(testDataMetaArray);
		List<String> response = new ArrayList<String>();
		
		
		for (TestDataMetaAppOneEntity testDataMetaAppOneTableEntity : testDataMeta)
		{
			Integer testDataMetaId=testDataMetaAppOneTableEntity.getTestDataMetaId();
			if(testDataMetaRepository.findById(testDataMetaId).isPresent())
			{
			Optional<TestDataMetaAppOneEntity> retrievedOptionalTestDataMeta = testDataMetaRepository.findById(testDataMetaId);
			TestDataMetaAppOneEntity retievedTestDataMeta = retrievedOptionalTestDataMeta.get();
			retievedTestDataMeta.setDeleteFlag("Y");
			testDataMetaRepository.save(retievedTestDataMeta);
			response.add(testDataMetaId+":Deleted Successfully!");
			}
			else
			{
				response.add(testDataMetaId+":Record Not Found!");
			}
		}
		return response;	
	}
	
	public TestDataMetaAppOneEntity updateTestDataMeta(long testTableId, TestDataMetaAppOneEntity testDataMetaAppOneTableEntity)
	{
		TestDataMetaAppOneEntity originalRecord=testDataMetaRepository.findById(testDataMetaAppOneTableEntity.getTestDataMetaId()).get();
		TestDataMetaAppOneEntity newRecord=testDataMetaAppOneTableEntity;
		
		Field testDataMetaAppOneTableEntityFields[]=testDataMetaAppOneTableEntity.getClass().getDeclaredFields();
		
		TestDataMetaAppOneEntity mergedTestDataMetaAppOneTableEntity=new TestDataMetaAppOneEntity();
		
		for (Field testDataMetaAppOneTableEntityField : testDataMetaAppOneTableEntityFields)
		{
			testDataMetaAppOneTableEntityField.setAccessible(true);
			try
			{
				if(testDataMetaAppOneTableEntityField.getName().contains("testDataAppOneTableOne"))
				{
					System.out.println("TestDataAppOneTableOne field..");

					Object originalTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(originalRecord);
					Object newTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(newRecord);

					Object mergedTestDataMetaAppOneTableEntityField = (newTestDataMetaAppOneTableEntityField == null) ? originalTestDataMetaAppOneTableEntityField : newTestDataMetaAppOneTableEntityField;

					if(newTestDataMetaAppOneTableEntityField==null)
					{
						mergedTestDataMetaAppOneTableEntityField=originalTestDataMetaAppOneTableEntityField;
						testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, mergedTestDataMetaAppOneTableEntityField);
					}
					else
					{
					List<TestDataAppOneTableOneEntity> newTestDataAppOneTableOneTableEntity=testDataMetaAppOneTableEntity.getTestDataAppOneTableOne();
					List<TestDataAppOneTableOneEntity> originalTestDataAppOneTableOneTableEntity=originalRecord.getTestDataAppOneTableOne();
					List<TestDataAppOneTableOneEntity> mergedTestDataAppOneTableOneTableEntityList=new ArrayList<TestDataAppOneTableOneEntity>();

					for(int i=0;i<newTestDataAppOneTableOneTableEntity.size();i++)
					{
						Field testDataAppOneTableOneTableEntityFields[]=newTestDataAppOneTableOneTableEntity.get(i).getClass().getDeclaredFields();
						TestDataAppOneTableOneEntity mergedTestDataAppOneTableOneTableEntity=new TestDataAppOneTableOneEntity();

						
						for (Field testDataAppOneTableOneTableEntityField : testDataAppOneTableOneTableEntityFields)
						{
							testDataAppOneTableOneTableEntityField.setAccessible(true);
							
							Object originalTestDataAppOneTableOneTableEntityField = testDataAppOneTableOneTableEntityField.get(originalTestDataAppOneTableOneTableEntity.get(i));
						//	System.out.println("OriginalData testDataAppOneTableOne Object.."+originalTestDataAppOneTableOneTableEntityField);
							
							Object newTestDataAppOneTableOneTableEntityField = testDataAppOneTableOneTableEntityField.get(newTestDataAppOneTableOneTableEntity.get(i));
						//	System.out.println("NewData testDataAppOneTableOne Object.."+newTestDataAppOneTableOneTableEntityField);
							
							Object finalTestDataAppOneTableOneTableEntityField = (newTestDataAppOneTableOneTableEntityField == null) ? originalTestDataAppOneTableOneTableEntityField : newTestDataAppOneTableOneTableEntityField;
							testDataAppOneTableOneTableEntityField.set(mergedTestDataAppOneTableOneTableEntity, finalTestDataAppOneTableOneTableEntityField);
						}
						
						mergedTestDataAppOneTableOneTableEntityList.add(mergedTestDataAppOneTableOneTableEntity);
						System.out.println(mergedTestDataAppOneTableOneTableEntity.toString());
					}
					
					testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, mergedTestDataAppOneTableOneTableEntityList);
				
					}
				}
		        else 
		        {
					Object originalTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(originalRecord);
					Object newTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(newRecord);

					Object finalTestDataMetaAppOneTableEntityField = (newTestDataMetaAppOneTableEntityField == null) ? originalTestDataMetaAppOneTableEntityField : newTestDataMetaAppOneTableEntityField;

					testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, finalTestDataMetaAppOneTableEntityField);
				}
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			} 
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Merged Test Data:"+mergedTestDataMetaAppOneTableEntity.toString());
		
		TestDataMetaAppOneEntity updatedOptionalTestDataMeta=testDataMetaRepository.save(mergedTestDataMetaAppOneTableEntity);
		
		System.out.println("After update:"+updatedOptionalTestDataMeta.toString());
		return updatedOptionalTestDataMeta;
	}
	
	
	public List<Integer> convertStringListToIntegerList(List<String> stringList)
	{
		 List<Integer> integerList = new ArrayList<>();
	        for (String string : stringList) {
	        	integerList.add(Integer.parseInt(string));
	        }
			return integerList;
	}
	
	
	public List<String> replaceNullWithNullOrEmptyString(List<String> list)
	{
		if(list.contains(null))
		{
			list.set(list.indexOf(null), "Null/Blank");
		};
		
		return list;
	}
	
	
}
