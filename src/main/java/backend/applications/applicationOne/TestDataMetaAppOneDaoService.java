package backend.applications.applicationOne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.applications.RowValues;
import backend.applications.SearchCriteria;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.TestDataSearchRequest;
import backend.applications.KeyAndValue;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoRepository;
import backend.utils.Utils;

@Service
public class TestDataMetaAppOneDaoService
{
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	@Autowired
	TestDataAppOneTableOneRepository testDataAppOneTableOneRepository;
	
	@Autowired
	TestDataAppOneTableTwoRepository testDataAppOneTableTwoRepository;
	
	@Autowired
	Utils utils;
	
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
		
		List<TestDataAppOneTableOneEntity> listOfNewTestDataAppOneTableOne=new ArrayList<TestDataAppOneTableOneEntity>();
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
			
			listOfNewTestDataAppOneTableOne.add(newTestDataApp);
		}
		
		List<TestDataAppOneTableTwoEntity> listOfNewTestDataAppOneTableTwo=new ArrayList<TestDataAppOneTableTwoEntity>();
		for (int i = 0; i < testDataMeta.getTestDataAppOneTableTwo().size(); i++)
		{
			TestDataAppOneTableTwoEntity newTestDataApp=new TestDataAppOneTableTwoEntity();
			newTestDataApp.setTestDataMeta(newTestDataMeta);
			newTestDataApp.setTestRowDetail(testDataMeta.getTestDataAppOneTableTwo().get(i).getTestRowDetail());
			newTestDataApp.setColumnA(testDataMeta.getTestDataAppOneTableTwo().get(i).getColumnA());
			newTestDataApp.setColumnB(testDataMeta.getTestDataAppOneTableTwo().get(i).getColumnB());
			newTestDataApp.setColumnC(testDataMeta.getTestDataAppOneTableTwo().get(i).getColumnC());
			newTestDataApp.setColumnD(testDataMeta.getTestDataAppOneTableTwo().get(i).getColumnD());
			newTestDataApp.setColumnE(testDataMeta.getTestDataAppOneTableTwo().get(i).getColumnE());
			newTestDataApp.setDeleteFlag("N");
			
			listOfNewTestDataAppOneTableTwo.add(newTestDataApp);
		}
		
		newTestDataMeta.setTestDataAppOneTableOne(listOfNewTestDataAppOneTableOne);
		newTestDataMeta.setTestDataAppOneTableTwo(listOfNewTestDataAppOneTableTwo);
		
		TestDataMetaAppOneEntity saved = testDataMetaRepository.save(newTestDataMeta);
		
		return saved;
	}
	
	public List<TestDataMetaAppOneEntity> cloneTestDataMeta(long testTableId, TestDataMetaAppOneEntity testDataMetaArray[])
	{
					
		List<TestDataMetaAppOneEntity> testDataMeta = Arrays.asList(testDataMetaArray);
		List<TestDataMetaAppOneEntity> toBeCloned = new ArrayList<TestDataMetaAppOneEntity>();
		List<TestDataMetaAppOneEntity> clonedTestDataMetaList = new ArrayList<TestDataMetaAppOneEntity>();

		for (int i = 0; i < testDataMeta.size(); i++)
		{
			try 
			{
			
				TestDataMetaAppOneEntity newTestDataMeta = new TestDataMetaAppOneEntity();
				System.out.println("newTestDataMeta:"+newTestDataMeta.toString());
				
				newTestDataMeta.setTestTableOne(testDataMeta.get(i).getTestTableOne());
				newTestDataMeta.setTestTableTwo(testDataMeta.get(i).getTestTableTwo());
				newTestDataMeta.setTestTableThree(testDataMeta.get(i).getTestTableThree());

				newTestDataMeta.setTestCaseId(testDataMeta.get(i).getTestCaseId());
				newTestDataMeta.setTestShortDescription(testDataMeta.get(i).getTestShortDescription());
				newTestDataMeta.setTestScenario(testDataMeta.get(i).getTestScenario());
				newTestDataMeta.setRunFlag(testDataMeta.get(i).getRunFlag());
				newTestDataMeta.setTestPriority(testDataMeta.get(i).getTestPriority());
				newTestDataMeta.setTestCategory(testDataMeta.get(i).getTestCategory());
				newTestDataMeta.setTestScriptName(testDataMeta.get(i).getTestScriptName());
				newTestDataMeta.setJiraId(testDataMeta.get(i).getJiraId());
				newTestDataMeta.setTestExecutionTime(testDataMeta.get(i).getTestExecutionTime());
				newTestDataMeta.setCreatedBy(testDataMeta.get(i).getCreatedBy());
				newTestDataMeta.setCreatedDate(new Date());
				// newTestDataMeta.setUpdatedBy(testDataMeta.get(i).getUpdatedBy());
				// newTestDataMeta.setUpdatedDate(new Date());
				newTestDataMeta.setDeleteFlag("N");

				List<TestDataAppOneTableOneEntity> listOfNewTestDataAppOneTableOne = new ArrayList<TestDataAppOneTableOneEntity>();
				for (int testDataApp = 0; testDataApp < testDataMeta.get(i).getTestDataAppOneTableOne()
						.size(); testDataApp++)
				{
					TestDataAppOneTableOneEntity newTestDataApp = new TestDataAppOneTableOneEntity();
					newTestDataApp.setTestDataMeta(newTestDataMeta);
					newTestDataApp.setTestRowDetail(
							testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getTestRowDetail());
					newTestDataApp
							.setColumn1(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn1());
					newTestDataApp
							.setColumn2(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn2());
					newTestDataApp
							.setColumn3(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn3());
					newTestDataApp
							.setColumn4(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn4());
					newTestDataApp
							.setColumn5(testDataMeta.get(i).getTestDataAppOneTableOne().get(testDataApp).getColumn5());

					newTestDataApp.setDeleteFlag("N");

					listOfNewTestDataAppOneTableOne.add(newTestDataApp);
				}

				List<TestDataAppOneTableTwoEntity> listOfNewTestDataAppOneTableTwo = new ArrayList<TestDataAppOneTableTwoEntity>();
				for (int testDataApp = 0; testDataApp < testDataMeta.get(i).getTestDataAppOneTableTwo().size(); i++)
				{
					TestDataAppOneTableTwoEntity newTestDataApp = new TestDataAppOneTableTwoEntity();
					newTestDataApp.setTestDataMeta(newTestDataMeta);
					newTestDataApp.setTestRowDetail(
							testDataMeta.get(i).getTestDataAppOneTableTwo().get(i).getTestRowDetail());
					newTestDataApp
							.setColumnA(testDataMeta.get(i).getTestDataAppOneTableTwo().get(testDataApp).getColumnA());
					newTestDataApp
							.setColumnB(testDataMeta.get(i).getTestDataAppOneTableTwo().get(testDataApp).getColumnB());
					newTestDataApp
							.setColumnC(testDataMeta.get(i).getTestDataAppOneTableTwo().get(testDataApp).getColumnC());
					newTestDataApp
							.setColumnD(testDataMeta.get(i).getTestDataAppOneTableTwo().get(testDataApp).getColumnD());
					newTestDataApp
							.setColumnE(testDataMeta.get(i).getTestDataAppOneTableTwo().get(testDataApp).getColumnE());
					newTestDataApp.setDeleteFlag("N");

					listOfNewTestDataAppOneTableTwo.add(newTestDataApp);
				}

				newTestDataMeta.setTestDataAppOneTableOne(listOfNewTestDataAppOneTableOne);
				newTestDataMeta.setTestDataAppOneTableTwo(listOfNewTestDataAppOneTableTwo);

				toBeCloned.add(newTestDataMeta);
								
			} 
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
		
		List<TestDataMetaAppOneEntity> storedTestDataMeta = saveTestDataMeta(toBeCloned);

		for (TestDataMetaAppOneEntity testDataMetaAppOneTableEntity : storedTestDataMeta)
		{
			System.out.println("Cloned TestDataMeta ID:"+testDataMetaAppOneTableEntity.getTestDataMetaId());
			
			for (TestDataAppOneTableOneEntity TestDataAppOneTableOneTableEntity : testDataMetaAppOneTableEntity.getTestDataAppOneTableOne())
			{
				System.out.println("Cloned TestDataID:"+TestDataAppOneTableOneTableEntity.getTestDataId());
			}
		}
		return storedTestDataMeta;
	}
	
	public List<TestDataMetaAppOneEntity> saveTestDataMeta(List<TestDataMetaAppOneEntity> newTestDataMeta)
	{
		
		List<TestDataMetaAppOneEntity> storedTestDataMeta = testDataMetaRepository.saveAllAndFlush(newTestDataMeta);
		return storedTestDataMeta;
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
	
	
	public List<String> createTestDataMeta(int testTableId, RowValues newTestDataValues[])
	{

		ArrayList<String> newTestDataAddedList = new ArrayList<String>();
		TestDataMetaAppOneEntity newlyAddedTestDataMetaEntity = null;
		List<String> columnsIntegerType=new ArrayList<String>();
		columnsIntegerType.add("testPriority");
		
			try
			{
					
				for (RowValues row : newTestDataValues)
				{
					
					if (row.getId()==0)
					{
					TestDataMetaAppOneEntity testDataMetaAppOneEntity = new TestDataMetaAppOneEntity();
					testDataMetaAppOneEntity.setTestDataMetaId(null);
					testDataMetaAppOneEntity.setDeleteFlag("N");
										
					for (KeyAndValue column : row.getKeyAndValue())
					{
						String attributeName = column.getColumnName();
						String attributeValue = column.getColumnValue();

						if(!columnsIntegerType.contains(attributeName))
						{
							utils.callSetter(testDataMetaAppOneEntity, attributeName, attributeValue);
						}
						else
						{
							utils.callSetter(testDataMetaAppOneEntity, attributeName, Integer.valueOf(attributeValue));	
						}
					}
					newlyAddedTestDataMetaEntity = testDataMetaRepository.save(testDataMetaAppOneEntity);
					newTestDataAddedList.add(newlyAddedTestDataMetaEntity.getTestDataMetaId() + " record is added successfully");
					} 
				
				}
				
				for (RowValues newTestDataValue : newTestDataValues)
				{
					if(newTestDataValue.getId()!=0)
					{
					switch (testTableId)
					{
					case 2001:
						TestDataAppOneTableOneEntity testDataAppOneTableOneEntity = new TestDataAppOneTableOneEntity();
						testDataAppOneTableOneEntity.setTestDataId(null);
						testDataAppOneTableOneEntity.setDeleteFlag("N");
						testDataAppOneTableOneEntity.setTestDataMeta(newlyAddedTestDataMetaEntity);
						
						for (KeyAndValue column : newTestDataValue.getKeyAndValue())
						{
							String attributeName = column.getColumnName();
							String attributeValue = column.getColumnValue();

							if(!columnsIntegerType.contains(attributeName))
							{
								utils.callSetter(testDataAppOneTableOneEntity, attributeName, attributeValue);
							}
							else
							{
								utils.callSetter(testDataAppOneTableOneEntity, attributeName, Integer.valueOf(attributeValue));	
							}						
						}
						TestDataAppOneTableOneEntity newlyAddedTestDataAppOneTableOneEntity = testDataAppOneTableOneRepository.save(testDataAppOneTableOneEntity);
						newTestDataAddedList.add(newlyAddedTestDataAppOneTableOneEntity.getTestDataId() + " record is added successfully");
						break;

					case 2002:
						TestDataAppOneTableTwoEntity testDataAppOneTableTwoEntity = new TestDataAppOneTableTwoEntity();
						testDataAppOneTableTwoEntity.setTestDataId(null);
						testDataAppOneTableTwoEntity.setTestDataMeta(newlyAddedTestDataMetaEntity);
						testDataAppOneTableTwoEntity.setDeleteFlag("N");

						for (KeyAndValue column : newTestDataValue.getKeyAndValue())
						{
							String attributeName = column.getColumnName();
							String attributeValue = column.getColumnValue();

							if(!columnsIntegerType.contains(attributeName))
							{
								utils.callSetter(testDataAppOneTableTwoEntity, attributeName, attributeValue);
							}
							else
							{
								utils.callSetter(testDataAppOneTableTwoEntity, attributeName, Integer.valueOf(attributeValue));	
							}						
						}
						TestDataAppOneTableTwoEntity newlyAddedTestDataAppOneTableTwoEntity = testDataAppOneTableTwoRepository.save(testDataAppOneTableTwoEntity);
						newTestDataAddedList.add(newlyAddedTestDataAppOneTableTwoEntity.getTestDataId() + " record is added successfully");
						
						break;

					default:
						break;
					}
				}
			} 
			}
			catch (Exception e)
			{
				newTestDataAddedList.add("Some record details are failed to be added to new test data");
			}
			return newTestDataAddedList;

	}

	

	
	public List<String> updateTestDataMeta(int testTableId, RowValues dataUpdateRequests[])
	{

		ArrayList<String> updatedTestDataList = new ArrayList<String>();
		for (RowValues dataUpdateRequest : dataUpdateRequests)
		{
			try
			{
				List<KeyAndValue> columnsUpdateList;

				Optional<TestDataMetaAppOneEntity> testDataMetaOptional = testDataMetaRepository
						.findById(dataUpdateRequest.getId());
				if (testDataMetaOptional.isPresent())
				{
					TestDataMetaAppOneEntity fetchedTestData = testDataMetaOptional.get();

					columnsUpdateList = dataUpdateRequest.getKeyAndValue();
					for (KeyAndValue column : columnsUpdateList)
					{
						String attributeName = column.getColumnName();
						String attributeValue = column.getColumnValue();

						utils.callSetter(fetchedTestData, attributeName, attributeValue);
					}
					TestDataMetaAppOneEntity updatedTestDataMetaEntity = testDataMetaRepository.save(fetchedTestData);
					updatedTestDataList
							.add(updatedTestDataMetaEntity.getTestDataMetaId() + " record is updated successfully");
				} 
				else
				{

					switch (testTableId)
					{
					case 2001:
						Optional<TestDataAppOneTableOneEntity> optionalFetchedTestData = testDataAppOneTableOneRepository
								.findByTestDataId(Integer.valueOf(dataUpdateRequest.getId()));
						TestDataAppOneTableOneEntity fetchedTestData = optionalFetchedTestData.get();

						columnsUpdateList = dataUpdateRequest.getKeyAndValue();
						for (KeyAndValue column : columnsUpdateList)
						{
							String attributeName = column.getColumnName();
							String attributeValue = column.getColumnValue();

							utils.callSetter(fetchedTestData, attributeName, attributeValue);
						}
						TestDataAppOneTableOneEntity updatedTestDataEntity = testDataAppOneTableOneRepository
								.save(fetchedTestData);
						updatedTestDataList
								.add(updatedTestDataEntity.getTestDataId() + " record is updated successfully");
						break;

					case 2002:
						Optional<TestDataAppOneTableTwoEntity> optionalFetchedTestDataTableTwo = testDataAppOneTableTwoRepository
								.findByTestDataId(Integer.valueOf(dataUpdateRequest.getId()));
						TestDataAppOneTableTwoEntity fetchedTestDataTableTwo = optionalFetchedTestDataTableTwo.get();

						columnsUpdateList = dataUpdateRequest.getKeyAndValue();
						for (KeyAndValue column : columnsUpdateList)
						{
							String attributeName = column.getColumnName();
							String attributeValue = column.getColumnValue();

							utils.callSetter(fetchedTestDataTableTwo, attributeName, attributeValue);
						}
						TestDataAppOneTableTwoEntity updatedTestDataEntityTableTwo = testDataAppOneTableTwoRepository
								.save(fetchedTestDataTableTwo);
						updatedTestDataList
								.add(updatedTestDataEntityTableTwo.getTestDataId() + " record is updated successfully");

						break;

					default:
						break;
					}
				}
			} 
			catch (Exception e)
			{
				updatedTestDataList.add(dataUpdateRequest.getId() + " record changes are failed to update");
			}

		}
		return updatedTestDataList;

	}
	
	
	
// This below update method as well works, but logic seems not efficient	
//	public TestDataMetaAppOneEntity updateTestDataMeta(long testTableId, TestDataMetaAppOneEntity testDataMetaAppOneTableEntity)
//	{
//		TestDataMetaAppOneEntity originalRecord=testDataMetaRepository.findById(testDataMetaAppOneTableEntity.getTestDataMetaId()).get();
//		TestDataMetaAppOneEntity newRecord=testDataMetaAppOneTableEntity;
//		
//		Field testDataMetaAppOneTableEntityFields[]=testDataMetaAppOneTableEntity.getClass().getDeclaredFields();
//		
//		TestDataMetaAppOneEntity mergedTestDataMetaAppOneTableEntity=new TestDataMetaAppOneEntity();
//		
//		for (Field testDataMetaAppOneTableEntityField : testDataMetaAppOneTableEntityFields)
//		{
//			testDataMetaAppOneTableEntityField.setAccessible(true);
//			try
//			{
//				if(testDataMetaAppOneTableEntityField.getName().contains("testDataAppOneTableOne"))
//				{
//					System.out.println("TestDataAppOneTableOne field..");
//
//					Object originalTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(originalRecord);
//					Object newTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(newRecord);
//
//					Object mergedTestDataMetaAppOneTableEntityField = (newTestDataMetaAppOneTableEntityField == null) ? originalTestDataMetaAppOneTableEntityField : newTestDataMetaAppOneTableEntityField;
//
//					if(newTestDataMetaAppOneTableEntityField==null)
//					{
//						mergedTestDataMetaAppOneTableEntityField=originalTestDataMetaAppOneTableEntityField;
//						testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, mergedTestDataMetaAppOneTableEntityField);
//					}
//					else
//					{
//					List<TestDataAppOneTableOneEntity> newTestDataAppOneTableOneTableEntity=testDataMetaAppOneTableEntity.getTestDataAppOneTableOne();
//					List<TestDataAppOneTableOneEntity> originalTestDataAppOneTableOneTableEntity=originalRecord.getTestDataAppOneTableOne();
//					List<TestDataAppOneTableOneEntity> mergedTestDataAppOneTableOneTableEntityList=new ArrayList<TestDataAppOneTableOneEntity>();
//
//					for(int i=0;i<newTestDataAppOneTableOneTableEntity.size();i++)
//					{
//						Field testDataAppOneTableOneTableEntityFields[]=newTestDataAppOneTableOneTableEntity.get(i).getClass().getDeclaredFields();
//						TestDataAppOneTableOneEntity mergedTestDataAppOneTableOneTableEntity=new TestDataAppOneTableOneEntity();
//
//						
//						for (Field testDataAppOneTableOneTableEntityField : testDataAppOneTableOneTableEntityFields)
//						{
//							testDataAppOneTableOneTableEntityField.setAccessible(true);
//							
//							Object originalTestDataAppOneTableOneTableEntityField = testDataAppOneTableOneTableEntityField.get(originalTestDataAppOneTableOneTableEntity.get(i));
//						//	System.out.println("OriginalData testDataAppOneTableOne Object.."+originalTestDataAppOneTableOneTableEntityField);
//							
//							Object newTestDataAppOneTableOneTableEntityField = testDataAppOneTableOneTableEntityField.get(newTestDataAppOneTableOneTableEntity.get(i));
//						//	System.out.println("NewData testDataAppOneTableOne Object.."+newTestDataAppOneTableOneTableEntityField);
//							
//							Object finalTestDataAppOneTableOneTableEntityField = (newTestDataAppOneTableOneTableEntityField == null) ? originalTestDataAppOneTableOneTableEntityField : newTestDataAppOneTableOneTableEntityField;
//							testDataAppOneTableOneTableEntityField.set(mergedTestDataAppOneTableOneTableEntity, finalTestDataAppOneTableOneTableEntityField);
//						}
//						
//						mergedTestDataAppOneTableOneTableEntityList.add(mergedTestDataAppOneTableOneTableEntity);
//						System.out.println(mergedTestDataAppOneTableOneTableEntity.toString());
//					}
//					
//					testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, mergedTestDataAppOneTableOneTableEntityList);
//				
//					}
//				}
//		        else 
//		        {
//					Object originalTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(originalRecord);
//					Object newTestDataMetaAppOneTableEntityField = testDataMetaAppOneTableEntityField.get(newRecord);
//
//					Object finalTestDataMetaAppOneTableEntityField = (newTestDataMetaAppOneTableEntityField == null) ? originalTestDataMetaAppOneTableEntityField : newTestDataMetaAppOneTableEntityField;
//
//					testDataMetaAppOneTableEntityField.set(mergedTestDataMetaAppOneTableEntity, finalTestDataMetaAppOneTableEntityField);
//				}
//			}
//			catch (IllegalArgumentException e)
//			{
//				e.printStackTrace();
//			} 
//			catch (IllegalAccessException e)
//			{
//				e.printStackTrace();
//			}
//		}
//		
//		System.out.println("Merged Test Data:"+mergedTestDataMetaAppOneTableEntity.toString());
//		
//		TestDataMetaAppOneEntity updatedOptionalTestDataMeta=testDataMetaRepository.save(mergedTestDataMetaAppOneTableEntity);
//		
//		System.out.println("After update:"+updatedOptionalTestDataMeta.toString());
//		return updatedOptionalTestDataMeta;
//	}
	
	
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
	
	public List<TestDataMetaAppOneEntity> getTestDataMetaData(Long tableId, TestDataSearchRequest testDataSearchRequest)
	{
		System.out.println("TABLE ID: "+tableId+" - "+testDataSearchRequest);
			
		TestDataMetaAppOneSpecifications testDataMetaSpecs=new TestDataMetaAppOneSpecifications();
		
		if(tableId==2001)
		{
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testTableOne",SearchOperator.IN,tableId));
		}
		else if(tableId==2002)
		{
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testTableTwo",SearchOperator.IN,tableId));
		}
		
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

		List<TestDataMetaAppOneEntity> filteredRecords=testDataMetaRepository.findAll(testDataMetaSpecs);
		
		System.out.println("Table "+tableId+" : Test Data Filtered records:"+filteredRecords);
		
        return filteredRecords;
	}

	public void createWorkbook(String excelFileName, String sheetName, List<TestDataMetaAppOneEntity> testData)
	{
		try (Workbook workbook = new XSSFWorkbook())
		{
			Sheet sheet;
			Row row;
			Cell cell;
			int rowNum;
			int cellNumHeader;
			
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			try
			{		
				sheet = workbook.createSheet(sheetName);   
				rowNum=0;
				cellNumHeader=0;
				//Create Header
				row = sheet.createRow(rowNum++);  
			
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestDataMetaId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestCaseId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestShortDescription"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestScenario"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("RunFlag"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestPriority"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestCategory"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestScriptName"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("JiraId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestExecutionTime"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("CreatedBy"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("CreatedDate"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("UpdatedBy"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("UpdatedDate"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("DeleteFlag"); cell.setCellStyle(headerStyle);
				
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestDataId"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("TestRowDetail"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("DeleteFlag"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column1"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column2"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column3"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column4"); cell.setCellStyle(headerStyle);
				cell = row.createCell(cellNumHeader++); cell.setCellValue("Column5"); cell.setCellStyle(headerStyle);
				
				
				
				for(TestDataMetaAppOneEntity data: testData)
				{
					int cellNum=0;
					row = sheet.createRow(rowNum++);  
					row.createCell(cellNum++).setCellValue(data.getTestDataMetaId());
					row.createCell(cellNum++).setCellValue(data.getTestCaseId());
					row.createCell(cellNum++).setCellValue(data.getTestShortDescription());
					row.createCell(cellNum++).setCellValue(data.getTestScenario());
					row.createCell(cellNum++).setCellValue(data.getRunFlag());
					row.createCell(cellNum++).setCellValue(data.getTestPriority());
					row.createCell(cellNum++).setCellValue(data.getTestCategory());
					row.createCell(cellNum++).setCellValue(data.getTestScriptName());
					row.createCell(cellNum++).setCellValue(data.getJiraId());
					row.createCell(cellNum++).setCellValue(data.getTestExecutionTime());
					row.createCell(cellNum++).setCellValue(data.getCreatedBy());
					row.createCell(cellNum++).setCellValue(data.getCreatedDate());
					row.createCell(cellNum++).setCellValue(data.getUpdatedBy());
					row.createCell(cellNum++).setCellValue(data.getUpdatedDate());
					row.createCell(cellNum++).setCellValue(data.getDeleteFlag());
					
					int testDataColumnStartingPoint=cellNum;
					List<TestDataAppOneTableOneEntity> testDataTableOneList=data.getTestDataAppOneTableOne();
					
					for(int testDataRow=0; testDataRow<testDataTableOneList.size(); testDataRow++)
					{
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getTestDataId());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getTestRowDetail());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getDeleteFlag());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn1());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn2());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn3());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn4());
					row.createCell(cellNum++).setCellValue(testDataTableOneList.get(testDataRow).getColumn5());
					
					if((testDataRow+1) <testDataTableOneList.size())
					{
						row = sheet.createRow(rowNum++);  
						cellNum=testDataColumnStartingPoint;
					}
					}

				}
				
				OutputStream fileOut=new FileOutputStream("src/main/resources/GeneratedExcelFiles/"+excelFileName+".xlsx");
				workbook.write(fileOut);  
		
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	catch (IOException e)
	{
			e.printStackTrace();
	}
	}

	
}
