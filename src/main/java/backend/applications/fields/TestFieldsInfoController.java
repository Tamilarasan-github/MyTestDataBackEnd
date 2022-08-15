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


@CrossOrigin
@RestController
public class TestFieldsInfoController
{
	@Autowired
	TestFieldsInfoRepository testFieldsInfoRepository;
	
	
	@GetMapping("/fields/tables/{tableId}")
	public List<TestFieldsInfoEntity> getFieldsList(@PathVariable long tableId)
	{
		System.out.println("Fields requested for table:"+tableId);
		Optional<List<TestFieldsInfoEntity>> tablesList= testFieldsInfoRepository.findAllByTableNameOrderByFieldOrder(tableId);
		
		return tablesList.get();
	}
	
	
}
