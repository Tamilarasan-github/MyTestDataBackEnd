package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.Arrays;
import java.util.Date;

public class TestSuiteExecutionSearchModel
{
	private Integer executionId;
	private Integer suiteId;
	private String suiteName;
	private String suiteStatus[];
	private String url;
	private String executedBy[];
	private Date executedDateFrom;
	private Date executedDateTo;
	
	TestSuiteExecutionSearchModel()
	{}
	
	public TestSuiteExecutionSearchModel(Integer executionId, Integer suiteId, String suiteName, String[] suiteStatus,
			String url, String[] executedBy, Date executedDateFrom, Date executedDateTo)
	{
		super();
		this.executionId = executionId;
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.suiteStatus = suiteStatus;
		this.url = url;
		this.executedBy = executedBy;
		this.executedDateFrom = executedDateFrom;
		this.executedDateTo = executedDateTo;
	}
	public Integer getExecutionId()
	{
		return executionId;
	}
	public void setExecutionId(Integer executionId)
	{
		this.executionId = executionId;
	}
	public Integer getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(Integer suiteId)
	{
		this.suiteId = suiteId;
	}
	public String getSuiteName()
	{
		return suiteName;
	}
	public void setSuiteName(String suiteName)
	{
		this.suiteName = suiteName;
	}
	public String[] getSuiteStatus()
	{
		return suiteStatus;
	}
	public void setSuiteStatus(String[] suiteStatus)
	{
		this.suiteStatus = suiteStatus;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String[] getExecutedBy()
	{
		return executedBy;
	}
	public void setExecutedBy(String[] executedBy)
	{
		this.executedBy = executedBy;
	}
	public Date getExecutedDateFrom()
	{
		return executedDateFrom;
	}
	public void setExecutedDateFrom(Date executedDateFrom)
	{
		this.executedDateFrom = executedDateFrom;
	}
	public Date getExecutedDateTo()
	{
		return executedDateTo;
	}
	public void setExecutedDateTo(Date executedDateTo)
	{
		this.executedDateTo = executedDateTo;
	}
	@Override
	public String toString()
	{
		return "TestSuiteExecutionSearchModel [executionId=" + executionId + ", suiteId=" + suiteId + ", suiteName="
				+ suiteName + ", suiteStatus=" + Arrays.toString(suiteStatus) + ", url=" + url + ", executedBy="
				+ Arrays.toString(executedBy) + ", executedDateFrom=" + executedDateFrom + ", executedDateTo="
				+ executedDateTo + "]";
	}
		
	
}
