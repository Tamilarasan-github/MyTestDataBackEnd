package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.Arrays;
import java.util.Date;

public class TestScriptExecutionHistorySearchModel
{
	private long testScriptsExecutionId;
	private long suiteId;
	private long testScriptId;
	private String testScriptsCategory[];
	private String createdBy[];
	private Date createdDateFrom;
	private Date createdDateTo;
	
	public TestScriptExecutionHistorySearchModel()
	{}
	
	public TestScriptExecutionHistorySearchModel(long testScriptsExecutionId, long suiteId, long testScriptId,
			String[] testScriptsCategory, String[] createdBy, Date createdDateFrom, Date createdDateTo)
	{
		super();
		this.testScriptsExecutionId = testScriptsExecutionId;
		this.suiteId = suiteId;
		this.testScriptId = testScriptId;
		this.testScriptsCategory = testScriptsCategory;
		this.createdBy = createdBy;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
	}
	public long getTestScriptsExecutionId()
	{
		return testScriptsExecutionId;
	}
	public void setTestScriptsExecutionId(long testScriptsExecutionId)
	{
		this.testScriptsExecutionId = testScriptsExecutionId;
	}
	public long getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(long suiteId)
	{
		this.suiteId = suiteId;
	}
	public long getTestScriptId()
	{
		return testScriptId;
	}
	public void setTestScriptId(long testScriptId)
	{
		this.testScriptId = testScriptId;
	}
	public String[] getTestScriptsCategory()
	{
		return testScriptsCategory;
	}
	public void setTestScriptsCategory(String[] testScriptsCategory)
	{
		this.testScriptsCategory = testScriptsCategory;
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
		return "TestScriptExecutionHistorySearchModel [testScriptsExecutionId=" + testScriptsExecutionId + ", suiteId="
				+ suiteId + ", testScriptId=" + testScriptId + ", testScriptsCategory="
				+ Arrays.toString(testScriptsCategory) + ", createdBy=" + Arrays.toString(createdBy)
				+ ", createdDateFrom=" + createdDateFrom + ", createdDateTo=" + createdDateTo + "]";
	}
	
	
}
