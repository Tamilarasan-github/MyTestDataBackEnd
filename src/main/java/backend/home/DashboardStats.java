package backend.home;

import java.util.Arrays;
import java.util.List;

public class DashboardStats
{
	private TestDataStats testDataStats;
	private List<EnvironmentExecutionStats> environmentExecutionStats;
	
	DashboardStats()
	{}
	
	public DashboardStats(TestDataStats testDataStats, List<EnvironmentExecutionStats> environmentExecutionStats)
	{
		super();
		this.testDataStats = testDataStats;
		this.environmentExecutionStats = environmentExecutionStats;
	}
	
	public TestDataStats getTestDataStats()
	{
		return testDataStats;
	}
	public void setTestDataStats(TestDataStats testDataStats)
	{
		this.testDataStats = testDataStats;
	}
	public List<EnvironmentExecutionStats> getEnvironmentExecutionStats()
	{
		return environmentExecutionStats;
	}
	public void setEnvironmentExecutionStats(List<EnvironmentExecutionStats> environmentExecutionStats)
	{
		this.environmentExecutionStats = environmentExecutionStats;
	}

	@Override
	public String toString()
	{
		return "DashboardStats [testDataStats=" + testDataStats + ", environmentExecutionStats="
				+ environmentExecutionStats + "]";
	}
	

	
	
}
