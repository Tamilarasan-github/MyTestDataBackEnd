package backend.applications.tables;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.TestApplicationsInfo;
import backend.applications.TestApplicationsInfoRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestTableInfoController
{
	
	@Autowired
	TestApplicationsInfoRepository testApplicationsInfoRepository;
	

	@Autowired
	TestTablesInfoRepository testTablesInfoRepository;
	
	
	@GetMapping("/applications")
	public List<TestApplicationsInfo> getApplicationsList()
	{
		Optional<List<TestApplicationsInfo>> applicationListOptional=  testApplicationsInfoRepository.findByDeleteFlag("N");
		System.out.println("applicationList:" +applicationListOptional);
		
		List<TestApplicationsInfo> applicationList= applicationListOptional.get();
		return applicationList;
	}
	
	@GetMapping("/tables")
	public Optional<List<TestTablesInfo>> getTablesList()
	{
		Optional<List<TestTablesInfo>> tablesList= testTablesInfoRepository.findByDeleteFlag("N");
		System.out.println("tablesList:" +tablesList);
		
		return tablesList;
	}
	
	@GetMapping("/applications/{applicationId}/tables")
	public List<TestTablesInfo> getTablesList(@PathVariable long applicationId)
	{
		System.out.println("Application ID requested is "+applicationId);
		Optional<List<TestTablesInfo>> tablesListOptional= testTablesInfoRepository.findByTestApplicationsInfoAndDeleteFlag(applicationId,"N");
		
		List<TestTablesInfo> tablesList= tablesListOptional.get();
		System.out.println("tablesList of "+applicationId+":" +tablesList);
		
		return tablesList;
	}
}
