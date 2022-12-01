package backend.home;

public class EnvironmentExecutionStats
{
	private String environmentName;
	private String totalTestcasesExecuted;
	private String testcasesPassed;
	private String testcasesFailed;
	private String testcasesNoResults;
		
	EnvironmentExecutionStats()
	{}
	
	public EnvironmentExecutionStats(String environmentName, String totalTestcasesExecuted, String testcasesPassed, String testcasesFailed,
			String testcasesNoResults)
	{
		super();
		this.environmentName=environmentName;
		this.totalTestcasesExecuted = totalTestcasesExecuted;
		this.testcasesPassed = testcasesPassed;
		this.testcasesFailed = testcasesFailed;
		this.testcasesNoResults = testcasesNoResults;
	}
	
	
	
	public String getEnvironmentName()
	{
		return environmentName;
	}
	public void setEnvironmentName(String environmentName)
	{
		this.environmentName = environmentName;
	}
	public String getTotalTestcasesExecuted()
	{
		return totalTestcasesExecuted;
	}
	public void setTotalTestcasesExecuted(String totalTestcasesExecuted)
	{
		this.totalTestcasesExecuted = totalTestcasesExecuted;
	}
	public String getTestcasesPassed()
	{
		return testcasesPassed;
	}
	public void setTestcasesPassed(String testcasesPassed)
	{
		this.testcasesPassed = testcasesPassed;
	}
	public String getTestcasesFailed()
	{
		return testcasesFailed;
	}
	public void setTestcasesFailed(String testcasesFailed)
	{
		this.testcasesFailed = testcasesFailed;
	}
	public String getTestcasesNoResults()
	{
		return testcasesNoResults;
	}
	public void setTestcasesNoResults(String testcasesNoResults)
	{
		this.testcasesNoResults = testcasesNoResults;
	}



	@Override
	public String toString()
	{
		return "EnvironmentExecutionStats [environmentName=" + environmentName + ", totalTestcasesExecuted="
				+ totalTestcasesExecuted + ", testcasesPassed=" + testcasesPassed + ", testcasesFailed="
				+ testcasesFailed + ", testcasesNoResults=" + testcasesNoResults + "]";
	}
	
	
}
