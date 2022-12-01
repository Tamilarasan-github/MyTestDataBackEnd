package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.Arrays;
import java.util.Date;

public class TestSuiteExecutionSearchModel
{
	private long suiteId;
	private String suiteName;
	private String suiteStatus[];
	private String url;
	private String createdBy[];
	private Date createdDateFrom;
	private Date createdDateTo;
		
	public TestSuiteExecutionSearchModel(long suiteId, String suiteName, String[] suiteStatus, String url,
			String[] createdBy, Date createdDateFrom, Date createdDateTo)
	{
		super();
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.suiteStatus = suiteStatus;
		this.url = url;
		this.createdBy = createdBy;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
	}
	
	public long getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(long suiteId)
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
	public String[] getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(String[] createdBy)
	{
		this.createdBy = createdBy;
	}
	public Date getCreatedDateFrom()
	{
		return createdDateFrom;
	}
	public void setCreatedDateFrom(Date createdDateFrom)
	{
		this.createdDateFrom = createdDateFrom;
	}
	public Date getCreatedDateTo()
	{
		return createdDateTo;
	}
	public void setCreatedDateTo(Date createdDateTo)
	{
		this.createdDateTo = createdDateTo;
	}

	@Override
	public String toString()
	{
		return "TestSuiteExecutionSearchModel [suiteId=" + suiteId + ", suiteName=" + suiteName + ", suiteStatus="
				+ Arrays.toString(suiteStatus) + ", url=" + url + ", createdBy=" + Arrays.toString(createdBy)
				+ ", createdDateFrom=" + createdDateFrom + ", createdDateTo=" + createdDateTo + "]";
	}

	
	
}
