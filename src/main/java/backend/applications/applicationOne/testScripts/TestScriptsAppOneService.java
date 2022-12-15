package backend.applications.applicationOne.testScripts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.applications.RowValues;
import backend.applications.KeyAndValue;
import backend.utils.Utils;

@Service
public class TestScriptsAppOneService
{

	@Autowired 
	TestScriptsAppOneRepository testScriptsAppOneRepository;
	
	@Autowired
	Utils utils;
	
	public static boolean isGetter(Method method){
	    // identify get methods
	    if((method.getName().startsWith("get") || method.getName().startsWith("is")) 
	        && method.getParameterCount() == 0 && !method.getReturnType().equals(void.class)){
	      return true;
	    }
	    return false; 
	  }

	public static boolean isSetter(Method method){
	    // identify set methods
	    if(method.getName().startsWith("set") && method.getParameterCount() == 1 
	        && method.getReturnType().equals(void.class)){
	      return true;
	    }
	    return false; 
	  }
	

	
	@Transactional
	public TestScriptsEntity updateTestScripts(RowValues dataUpdateRequest) {
		System.out.println("updateTestScriptRequest:" +dataUpdateRequest.toString());
		List<TestScriptsEntity> updatedTestScriptsEntityList=new ArrayList<>();
//		for(DataUpdate testScript:dataUpdateRequest)
//		{
			Optional <TestScriptsEntity> optionalFetchedTestScript = testScriptsAppOneRepository.findByTestScriptId(Integer.valueOf(dataUpdateRequest.getId()));
			TestScriptsEntity fetchedTestScript = optionalFetchedTestScript.get();
			
			List<KeyAndValue> columnsUpdateList = dataUpdateRequest.getKeyAndValue();
			System.out.println("fetchedTestScript: Before:" +fetchedTestScript.toString());
			
			for (KeyAndValue column : columnsUpdateList)
			{
				String attributeName=column.getColumnName();
				String attributeValue=column.getColumnValue();
				
				utils.callSetter(fetchedTestScript, attributeName, attributeValue);
				
				System.out.println("fetchedTestScript: Inside For loop:" +fetchedTestScript.toString());
			}
			System.out.println("fetchedTestScript: Outside For loop:" +fetchedTestScript.toString());

			
		
		TestScriptsEntity updatedTestScriptsEntity=testScriptsAppOneRepository.save(fetchedTestScript);
		updatedTestScriptsEntityList.add(updatedTestScriptsEntity);
		//}
		
		return updatedTestScriptsEntity;
		
	}
}
