package backend.home;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.applications.applicationOne.TestDataMetaAppOneRepository;
import backend.applications.applicationOne.testExecutionResults.testData.TestDataExecutionHistoryMetaRepository;

@Service
public class HomeService
{

	@Autowired
	TestDataMetaAppOneRepository testDataMetaAppOneRepository;
	
	@Autowired
	TestDataExecutionHistoryMetaRepository testDataExecutionHistoryMetaEntityRepository;
	
	public DashboardStats getDashboardStats(DashboardStatsRequest dashboardStatsRequest)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  	    
		String dateFrom;
		String dateTo;
		
		if(dashboardStatsRequest.getDateFrom()==null) dateFrom="01-01-2000";		
		if(dashboardStatsRequest.getDateTo()==null) dateTo="31-12-2099";
		
		dateFrom = formatter.format(dashboardStatsRequest.getDateFrom());
		dateTo = formatter.format(dashboardStatsRequest.getDateTo());
		
		String totalTestcasesCount = testDataMetaAppOneRepository.findCountOfTotalTestcases(dateFrom,dateTo);
		String regressionCount = testDataMetaAppOneRepository.findCountOfTestcases(dateFrom,dateTo, "Regression");
		String functionalCount = testDataMetaAppOneRepository.findCountOfTestcases(dateFrom,dateTo, "Functional");

		String totalTestcasesExecuted =testDataExecutionHistoryMetaEntityRepository.findExecutedTestcases(dateFrom, dateTo);
		String testcasesPassed =testDataExecutionHistoryMetaEntityRepository.findByExecutionStatus("PASS", dateFrom, dateTo);
		String testcasesFailed = testDataExecutionHistoryMetaEntityRepository.findByExecutionStatus("FAIL", dateFrom, dateTo);
		String testcasesNoResults = testDataExecutionHistoryMetaEntityRepository.findByExecutionStatus("", dateFrom, dateTo);
		
		System.out.println("testcasesPassed:"+testcasesPassed);
		
		String totalTestcasesExecutedInSIT =testDataExecutionHistoryMetaEntityRepository.findExecutedTestcasesByEnvironment("SIT", dateFrom, dateTo);
		String testcasesPassedInSIT =testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("SIT" ,"PASS", dateFrom, dateTo);
		String testcasesFailedInSIT = testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("SIT" ,"FAIL", dateFrom, dateTo);
		String testcasesNoResultsInSIT = testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("SIT", "", dateFrom, dateTo);
		
		String totalTestcasesExecutedInUAT =testDataExecutionHistoryMetaEntityRepository.findExecutedTestcasesByEnvironment("UAT", dateFrom, dateTo);
		String testcasesPassedInUAT =testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("UAT" ,"PASS", dateFrom, dateTo);
		String testcasesFailedInUAT = testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("UAT" ,"FAIL", dateFrom, dateTo);
		String testcasesNoResultsInUAT = testDataExecutionHistoryMetaEntityRepository.findExecutionStatusByEnvironment("UAT", "", dateFrom, dateTo);
		
		TestDataStats testDataStats=new TestDataStats(totalTestcasesCount, regressionCount, functionalCount);
		
		EnvironmentExecutionStats environmentExecutionStats=new EnvironmentExecutionStats();
		environmentExecutionStats.setEnvironmentName("ALL");
		environmentExecutionStats.setTotalTestcasesExecuted(totalTestcasesExecuted);
		environmentExecutionStats.setTestcasesPassed(testcasesPassed);
		environmentExecutionStats.setTestcasesFailed(testcasesFailed);
		environmentExecutionStats.setTestcasesNoResults(testcasesNoResults);
		
		EnvironmentExecutionStats environmentExecutionStatsSIT=new EnvironmentExecutionStats();
		environmentExecutionStatsSIT.setEnvironmentName("SIT");
		environmentExecutionStatsSIT.setTotalTestcasesExecuted(totalTestcasesExecutedInSIT);
		environmentExecutionStatsSIT.setTestcasesPassed(testcasesPassedInSIT);
		environmentExecutionStatsSIT.setTestcasesFailed(testcasesFailedInSIT);
		environmentExecutionStatsSIT.setTestcasesNoResults(testcasesNoResultsInSIT);
		
		EnvironmentExecutionStats environmentExecutionStatsUAT=new EnvironmentExecutionStats();
		environmentExecutionStatsUAT.setEnvironmentName("UAT");
		environmentExecutionStatsUAT.setTotalTestcasesExecuted(totalTestcasesExecutedInUAT);
		environmentExecutionStatsUAT.setTestcasesPassed(testcasesPassedInUAT);
		environmentExecutionStatsUAT.setTestcasesFailed(testcasesFailedInUAT);
		environmentExecutionStatsUAT.setTestcasesNoResults(testcasesNoResultsInUAT);
		
		List<EnvironmentExecutionStats> environmentExecutionStatsList=new ArrayList<EnvironmentExecutionStats>();
		environmentExecutionStatsList.add(environmentExecutionStats);
		environmentExecutionStatsList.add(environmentExecutionStatsSIT);
		environmentExecutionStatsList.add(environmentExecutionStatsUAT);
		
		DashboardStats dashboardStats=new DashboardStats(testDataStats, environmentExecutionStatsList);
		
		return dashboardStats;
		
	}
}
