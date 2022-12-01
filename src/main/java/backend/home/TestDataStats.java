package backend.home;

public class TestDataStats
{
	private String totalTestcasesCreated;
	private String regressionTestcases;
	private String functionalTestcases;
	
	public TestDataStats(String totalTestcasesCreated, String regressionTestcases, String functionalTestcases)
	{
		super();
		this.totalTestcasesCreated = totalTestcasesCreated;
		this.regressionTestcases = regressionTestcases;
		this.functionalTestcases = functionalTestcases;
	}

	public String getTotalTestcasesCreated()
	{
		return totalTestcasesCreated;
	}

	public void setTotalTestcasesCreated(String totalTestcasesCreated)
	{
		this.totalTestcasesCreated = totalTestcasesCreated;
	}

	public String getRegressionTestcases()
	{
		return regressionTestcases;
	}

	public void setRegressionTestcases(String regressionTestcases)
	{
		this.regressionTestcases = regressionTestcases;
	}

	public String getFunctionalTestcases()
	{
		return functionalTestcases;
	}

	public void setFunctionalTestcases(String functionalTestcases)
	{
		this.functionalTestcases = functionalTestcases;
	}

	@Override
	public String toString()
	{
		return "TestDataStats [totalTestcasesCreated=" + totalTestcasesCreated + ", regressionTestcases="
				+ regressionTestcases + ", functionalTestcases=" + functionalTestcases + "]";
	}
	
	
}
