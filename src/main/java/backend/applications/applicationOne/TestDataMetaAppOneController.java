package backend.applications.applicationOne;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.SearchCriteria;
import backend.applications.TestDataMetaDropdownValues;
import backend.applications.TestDataSearchRequest;
import backend.applications.SearchCriteria.SearchOperator;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneRepository;
import backend.applications.tables.TestTablesInfo;
import backend.applications.tables.TestTablesInfoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/applications/1001")
public class TestDataMetaAppOneController
{
	@Autowired
	TestDataMetaAppOneTableEntity testDataMeta;
	
	@Autowired
	TestDataMetaAppOneRepository testDataMetaRepository;
	
	@Autowired
	TestDataAppOneTableOneRepository testDataAppRepository;
	
	@Autowired
	TestDataMetaAppOneDaoService testDataDaoService;
	
	@Autowired
	TestTablesInfoRepository testTablesInfoRepository;
	
	@GetMapping("/tables")
	public List<TestTablesInfo> getTablesList()
	{
		System.out.println("Application ID requested is 1001");
		Optional<List<TestTablesInfo>> tablesListOptional= testTablesInfoRepository.findByTestApplicationsInfoAndDeleteFlag(1001,"N");
		
		List<TestTablesInfo> tablesList= tablesListOptional.get();
		System.out.println("tablesList of 1001:" +tablesList);
		
		return tablesList;
	}
}
