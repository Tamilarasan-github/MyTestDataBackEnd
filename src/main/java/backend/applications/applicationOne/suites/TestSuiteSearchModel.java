package backend.applications.applicationOne.suites;

import java.util.Arrays;
import java.util.Date;

public class TestSuiteSearchModel
{
	private long suiteId;
	private String suiteName;
	private String createdBy[];
	private Date createdDateFrom;
	private Date createdDateTo;
	private Date updatedDateFrom;
	private Date updatedDateTo;
	
	public TestSuiteSearchModel()
	{}
	
	public TestSuiteSearchModel(long suiteId, String suiteName, String[] createdBy, Date createdDateFrom,
			Date createdDateTo, Date updatedDateFrom, Date updatedDateTo)
	{
		super();
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.createdBy = createdBy;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
		this.updatedDateFrom = updatedDateFrom;
		this.updatedDateTo = updatedDateTo;
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
	public Date getUpdatedDateFrom()
	{
		return updatedDateFrom;
	}
	public void setUpdatedDateFrom(Date updatedDateFrom)
	{
		this.updatedDateFrom = updatedDateFrom;
	}
	public Date getUpdatedDateTo()
	{
		return updatedDateTo;
	}
	public void setUpdatedDateTo(Date updatedDateTo)
	{
		this.updatedDateTo = updatedDateTo;
	}
	
	@Override
	public String toString()
	{
		return "TestSuiteSearchModel [suiteId=" + suiteId + ", suiteName=" + suiteName + ", createdBy="
				+ Arrays.toString(createdBy) + ", createdDateFrom=" + createdDateFrom + ", createdDateTo="
				+ createdDateTo + ", updatedDateFrom=" + updatedDateFrom + ", updatedDateTo=" + updatedDateTo + "]";
	}
		
	
}