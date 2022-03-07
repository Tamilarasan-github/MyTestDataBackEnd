package backend.applications.fields;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import backend.applications.TestApplicationsInfo;
import backend.applications.TestApplicationsInfoRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestFieldsInfoController
{
	@Autowired
	TestFieldsInfoRepository testFieldsInfoRepository;
	
	
	@GetMapping("/fields")
	public List<TestFieldsInfoEntity> getFieldsList()
	{
		Optional<List<TestFieldsInfoEntity>> tablesList= testFieldsInfoRepository.findAllOrderByFieldOrder();
		
		return tablesList.get();
	}
	
	@GetMapping("/fields/fieldsorder")
	public List<TestFieldsInfoEntity> getFieldsOrder()
	{
		Optional<List<TestFieldsInfoEntity>> tablesList= testFieldsInfoRepository.findAllByTableNameOrderByFieldOrder("TEST_DATA_META");
			
		
		return tablesList.get();
	}
	
}
