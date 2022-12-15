package backend.applications.applicationOne.testdataInputTables.tableOne;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.RowValues;
import backend.applications.SearchCriteria;
import backend.applications.TestDataMetaDropdownValues;
import backend.applications.TestDataSearchRequest;
import backend.applications.SearchCriteria.SearchOperator;

import backend.applications.applicationOne.TestDataMetaAppOneDaoService;
import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.TestDataMetaAppOneSpecifications;
import backend.applications.applicationOne.TestDataMetaAppOneEntity;

@CrossOrigin
@RestController
@RequestMapping("/applications/1001/")
public class TestDataAppOneTableOneController
{
	//final long tableId=2001;
	
	@Autowired
	TestDataMetaAppOneEntity testDataMeta;
	
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	@Autowired
	TestDataAppOneTableOneRepository testDataAppRepository;
	
	@Autowired
	TestDataMetaAppOneDaoService testDataDaoService;
	
	@GetMapping("tables/{tableId}/dropdownvalues")
	public TestDataMetaDropdownValues getTestDataMetaDropdownValues(@PathVariable("tableId") Long tableId)
	{
		TestDataMetaDropdownValues testDataMetaDropdownValues =null;
		
		if(tableId==2000)
		{ 
		testDataMetaDropdownValues =  new TestDataMetaDropdownValues (
		
			testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctTestDataMetaId()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCaseId()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestShortDescription()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctRunFlag()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestPriority()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCategory()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestScriptName()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctJiraId()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctCreatedBy()),
			testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctUpdatedBy())
			);
		}
		else if(tableId==2001)
			{ 
			testDataMetaDropdownValues =  new TestDataMetaDropdownValues (
			
				testDataDaoService.convertStringListToIntegerList(testDataMetaRepository.findAllDistinctTestDataMetaIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCaseIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestShortDescriptionByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctRunFlagByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestPriorityByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestCategoryByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctTestScriptNameByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctJiraIdByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctCreatedByByTestTableOne(tableId)),
				testDataDaoService.replaceNullWithNullOrEmptyString(testDataMetaRepository.findAllDistinctUpdatedByByTestTableOne(tableId))
				);
			}
		else if(tableId==2002)
		{
		
		
			testDataMetaDropdownValues = new TestDataMetaDropdownValues (
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
		System.out.println("Dropdown values:"+testDataMetaDropdownValues);
		return testDataMetaDropdownValues;
			
	}
	
	
	@PostMapping("tables/{tableId}/search")
	public ResponseEntity<List<TestDataMetaAppOneEntity>> getTestData(
			@PathVariable("tableId") Long tableId, 
			@RequestParam(name = "page") int page, 
			@RequestParam(name = "size") int size,
			@RequestParam(name = "sort") String sort,
			@RequestBody TestDataSearchRequest testDataSearchRequest)
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
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testShortDescription",SearchOperator.CONTAINS,testDataSearchRequest.getTestShortDescription()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testPriority",SearchOperator.IN,testDataSearchRequest.getTestPriority())); 
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("testCategory",SearchOperator.IN,testDataSearchRequest.getTestCategory())); 	
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdBy",SearchOperator.IN,testDataSearchRequest.getCreatedBy()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("createdDate",SearchOperator.BETWEEN_DATES,testDataSearchRequest.getCreatedFrom(),testDataSearchRequest.getCreatedTo()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("updatedBy",SearchOperator.IN,testDataSearchRequest.getUpdatedBy()));
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("updatedDate",SearchOperator.IN,testDataSearchRequest.getUpdatedFrom(),testDataSearchRequest.getUpdatedTo()));
		
		testDataMetaSpecs.addNewTestDataMetaSearchCriteria(new SearchCriteria("deleteFlag",SearchOperator.IN, new String[] {"N"}));

		
		Pageable paging = PageRequest.of(
				page, size, Sort.by(sort).ascending());
		
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
		System.out.println("Table "+tableId+" : Test Data Filtered records:"+filteredRecords);
		
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
	
	
	@PostMapping("tables/{tableId}/clone")
	public List<TestDataMetaAppOneEntity> cloneTestData(@PathVariable("tableId") Long tableId, @RequestBody TestDataMetaAppOneEntity[] testDataMeta)
	{
		
		for (int i = 0; i < testDataMeta.length; i++)
		{
			System.out.println("Requested to Clone:"+testDataMeta[i].getTestDataMetaId());
		}
		
		return testDataDaoService.cloneTestDataMeta(tableId, testDataMeta);
	}
	
	@PostMapping("tables/{tableId}/create1")
	public TestDataMetaAppOneEntity createTestData(@PathVariable("tableId") Long tableId, @RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		return testDataDaoService.createTestDataMeta(testDataMeta);
	}
	
	@PatchMapping("tables/{tableId}/update")
	public ResponseEntity<List<String>> updateTestData(@PathVariable("tableId") Long tableId, @RequestBody RowValues dataUpdate[])
	{
		
		for (RowValues dataUpdatePrint : dataUpdate)
		{
			System.out.println("Updates requested:"+dataUpdatePrint.toString());
		}
		
		List<String> updateStatus=new ArrayList<>();
		boolean failFlag=false;
		try 
		{
			updateStatus.addAll(testDataDaoService.updateTestDataMeta(tableId.intValue(), dataUpdate));
			
			for (String status : updateStatus)
			{
				if(status.contains("fail"))
				{
					failFlag=true;
				}
			}
			
			if(failFlag==true)
				{
					throw new Exception("Failed to update");
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(updateStatus,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(updateStatus,
				HttpStatus.ACCEPTED);

	}
	
	
	@PostMapping("tables/{tableId}/create")
	public ResponseEntity<List<String>> createTestData(@PathVariable("tableId") Long tableId, @RequestBody RowValues rowValues[])
	{
		System.out.println("Request:" +rowValues.toString());
		for (RowValues rowValue : rowValues)
		{
			System.out.println("New Test Data Request:"+rowValue.toString());
		}
		
		List<String> addNewTestDataStatus=new ArrayList<>();
		boolean failFlag=false;
		try 
		{
			addNewTestDataStatus.addAll(testDataDaoService.createTestDataMeta(tableId.intValue(), rowValues));
			
			for (String status : addNewTestDataStatus)
			{
				if(status.contains("fail"))
				{
					failFlag=true;
				}
			}
			
			if(failFlag==true)
				{
				return new ResponseEntity<>(addNewTestDataStatus,
						HttpStatus.INTERNAL_SERVER_ERROR);
				}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(addNewTestDataStatus,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(addNewTestDataStatus,
				HttpStatus.ACCEPTED);

	}
	
	@PutMapping("/bulkupdate")
	public void bulkUpdateTestData(@RequestBody TestDataMetaAppOneEntity testDataMeta)
	{
		
	}
	
	@PutMapping("tables/{tableId}/delete")
	public List<String> deleteTestData(@PathVariable("tableId") Long tableId,@RequestBody TestDataMetaAppOneEntity[] testDataMeta)
	{
		for (int i = 0; i < testDataMeta.length; i++)
		{
			System.out.println("Requested to delete:"+testDataMeta[i].getTestDataMetaId());
		}
		return testDataDaoService.deleteTestDataMeta(tableId, testDataMeta);
		
	}
	
	@PostMapping("tables/{tableId}/exportExcel")
	public ResponseEntity<Resource> exportExcel(@PathVariable("tableId") Long tableId, @RequestBody TestDataSearchRequest testDataSearchRequest)
	{		
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String currentDataAndTime = formatter.format(date);
		
		String fileName="TestData_"+tableId+"_".concat(currentDataAndTime);
		testDataDaoService.createWorkbook(fileName, "Table_"+tableId, testDataDaoService.getTestDataMetaData(tableId, testDataSearchRequest));
		
		
		
		File file= new File("src/main/resources/GeneratedExcelFiles/"+fileName+".xlsx");
		Resource resource =null;
		try
		{
			resource = new UrlResource(file.toURI());
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("fileName", fileName);
	    responseHeaders.set("Access-Control-Expose-Headers", "*");
		
		 return ResponseEntity.ok()
                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                 .headers(responseHeaders)
                 .body(resource);
	}
}
