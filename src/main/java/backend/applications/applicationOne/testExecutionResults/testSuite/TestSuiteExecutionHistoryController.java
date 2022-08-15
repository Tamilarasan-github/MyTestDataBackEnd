package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import backend.applications.TestScriptsDropdownValues;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;
import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryRepository;
import backend.applications.applicationOne.testExecutionResults.testSuite.TestSuiteExecutionHistoryEntity;
import backend.applications.applicationOne.testScripts.TestScriptsAppOneRepository;
@CrossOrigin
@Controller
@RequestMapping("/applications/1001/execution-summary/testSuite")
public class TestSuiteExecutionHistoryController
{
		
	@Autowired
	TestSuiteExecutionHistoryRepository testSuiteExecutionHistoryRepository;
	
	@Autowired
	TestScriptsExecutionHistoryRepository testScriptsExecutionHistoryRepository;
	
	@GetMapping("/execution-history")
	@ResponseBody
	public List<TestSuiteExecutionHistoryEntity> getTestSuitesExecutionSummary()
	{
		List<TestSuiteExecutionHistoryEntity> testSuiteExecutionHistoryAll=testSuiteExecutionHistoryRepository.findAll();
		return testSuiteExecutionHistoryAll;
	}
	
	@PostMapping("/run")
	@ResponseBody
	public String runTestSuite(@RequestBody  Map<String,String> requestBody)
	{
//		<suite name="TmpSuite" >
//		  <test name="TmpTest" >
//		    <classes>
//		      <class name="test.failures.Child"  />
//		    <classes>
//		    </test>
//		</suite>
		long suiteId=Integer.parseInt(requestBody.get("suiteId"));
		
		TestSuiteExecutionHistoryEntity testSuiteExecutionHistoryEntity=testSuiteExecutionHistoryRepository.findBySuiteId(suiteId);
		testSuiteExecutionHistoryEntity.setSuiteStatus("Queued");
		testSuiteExecutionHistoryRepository.save(testSuiteExecutionHistoryEntity);
			
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    try {
		    	
				List<TestScriptsExecutionHistoryEntity> testScriptsExecutionHistoryEntity=testScriptsExecutionHistoryRepository.findBySuiteId(suiteId);

		    	int numOfTestScriptsRequested=testScriptsExecutionHistoryEntity.size();
				System.out.println("Num of Testscripts requested:"+numOfTestScriptsRequested);
				
				XmlSuite suite = new XmlSuite();
				suite.setName(testSuiteExecutionHistoryEntity.getSuiteName());
				
				 HashMap<String,String> testngParams = new HashMap<String,String> ();
				    testngParams.put("browserName", testSuiteExecutionHistoryEntity.getBrowser()); 
				    testngParams.put("suiteId",String.valueOf(testSuiteExecutionHistoryEntity.getSuiteId())); 
				    testngParams.put("suiteName",testSuiteExecutionHistoryEntity.getSuiteName()); 
				    testngParams.put("url",testSuiteExecutionHistoryEntity.getUrl()); 
				    suite.setParameters(testngParams);
				 
				XmlTest test = new XmlTest(suite);
				test.setName(testSuiteExecutionHistoryEntity.getSuiteName());
				
				List<XmlClass> classes = new ArrayList<XmlClass>();
				
				for(int testScriptNum=0; testScriptNum<numOfTestScriptsRequested; testScriptNum++)
				{
					String testScriptRequested=testScriptsExecutionHistoryEntity.get(testScriptNum).getTestScriptsName();
					
					classes.add(new XmlClass("testScripts."+testScriptRequested));
				}
				
				test.setXmlClasses(classes) ;

				List<XmlSuite> suites = new ArrayList<XmlSuite>();
				suites.add(suite);
				TestNG testNG = new TestNG();
				testNG.setXmlSuites(suites);
				
				
				    
				testSuiteExecutionHistoryRepository.updateSuiteStatusById("In-progress", suiteId);
				
				testNG.run();
				
				testSuiteExecutionHistoryRepository.updateSuiteStatusById("Completed", suiteId);
				System.out.println("TestNG execution Completed!");
		    }
		    catch(Exception e) {
		    	System.out.println("Exception while running test suite:" +e);
		    	
				
		    }
		    }
		});  
		thread.setName(String.valueOf(testSuiteExecutionHistoryEntity.getSuiteId()));
		
    	System.out.println("Before Start: Thread ID:"+thread.getId()+" - Thread Name:"+thread.getName()+" - Thread State:"+thread.getState());

    	try {
		thread.start();
    	}
    	catch(Exception e)
    	{
    		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
			for(Thread th : setOfThread)
			{
			    if(th.getName()==String.valueOf(suiteId))
			    {
			    	th.interrupt();
			    }
			}
			
			testSuiteExecutionHistoryRepository.updateSuiteStatusById("Error", suiteId);
    	}
		
    	System.out.println("In the end: Thread ID:"+thread.getId()+" - Thread Name:"+thread.getName()+" - Thread State:"+thread.getState());
		
    	return "Testscript batch execution is completed! - "+thread.getId();
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public String cancelSuiteExecution(@RequestBody  Map<String,String> requestBody)
	{

		String suiteId=String.valueOf(requestBody.get("suiteName"));
		
		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		//Iterate over set to find yours
		for(Thread thread : setOfThread)
		{
			System.out.println("Thread:"+thread.getName());
		    if(thread.getName()==suiteId)
		    {
		    	System.out.println("Thread Name matched:"+suiteId);
		        thread.interrupt();
		    }
		}
		return suiteId+" execution is stopped!";
	}
	
	@GetMapping("/view-report/{suiteId}")
	public String viewReport(@PathVariable("suiteId") String suiteId)
	{
		System.out.println("View Report:"+suiteId);
		return suiteId;

	}

	
}
