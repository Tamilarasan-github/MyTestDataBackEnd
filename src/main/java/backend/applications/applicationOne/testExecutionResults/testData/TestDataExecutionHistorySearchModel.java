package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.Arrays;
import java.util.Date;

public class TestDataExecutionHistorySearchModel
{
	private Integer testDataExecutionId;
    private Integer suiteId;
    private Integer testScriptExecutionId;
    private Integer testDataMetaId;
    private String testDataStatus[];
    private String testCategory[];
    private String jiraStory;
    private String testScripts;
    private String testShortDescription;
    private String executedBy[];
    private Date executedDateFrom;
    private Date executedDateTo;
    
    
    
	public TestDataExecutionHistorySearchModel(Integer testDataExecutionId, Integer suiteId,
			Integer testScriptExecutionId, Integer testDataMetaId, String[] testDataStatus, String[] testCategory,
			String jiraStory, String testScripts, String testShortDescription, String[] executedBy,
			Date executedDateFrom, Date executedDateTo)
	{
		super();
		this.testDataExecutionId = testDataExecutionId;
		this.suiteId = suiteId;
		this.testScriptExecutionId = testScriptExecutionId;
		this.testDataMetaId = testDataMetaId;
		this.testDataStatus = testDataStatus;
		this.testCategory = testCategory;
		this.jiraStory = jiraStory;
		this.testScripts = testScripts;
		this.testShortDescription = testShortDescription;
		this.executedBy = executedBy;
		this.executedDateFrom = executedDateFrom;
		this.executedDateTo = executedDateTo;
	}
	public Integer getTestDataExecutionId()
	{
		return testDataExecutionId;
	}
	public void setTestDataExecutionId(Integer testDataExecutionId)
	{
		this.testDataExecutionId = testDataExecutionId;
	}
	public Integer getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(Integer suiteId)
	{
		this.suiteId = suiteId;
	}
	public Integer getTestScriptExecutionId()
	{
		return testScriptExecutionId;
	}
	public void setTestScriptExecutionId(Integer testScriptExecutionId)
	{
		this.testScriptExecutionId = testScriptExecutionId;
	}
	public Integer getTestDataMetaId()
	{
		return testDataMetaId;
	}
	public void setTestDataMetaId(Integer testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}
	public String[] getTestDataStatus()
	{
		return testDataStatus;
	}
	public void setTestDataStatus(String[] testDataStatus)
	{
		this.testDataStatus = testDataStatus;
	}
	public String[] getTestCategory()
	{
		return testCategory;
	}
	public void setTestCategory(String[] testCategory)
	{
		this.testCategory = testCategory;
	}
	public String getJiraStory()
	{
		return jiraStory;
	}
	public void setJiraStory(String jiraStory)
	{
		this.jiraStory = jiraStory;
	}
	public String getTestScripts()
	{
		return testScripts;
	}
	public void setTestScripts(String testScripts)
	{
		this.testScripts = testScripts;
	}
	public String getTestShortDescription()
	{
		return testShortDescription;
	}
	public void setTestShortDescription(String testShortDescription)
	{
		this.testShortDescription = testShortDescription;
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
		return "TestDataExecutionHistorySearchModel [testDataExecutionId=" + testDataExecutionId + ", suiteId="
				+ suiteId + ", testScriptExecutionId=" + testScriptExecutionId + ", testDataMetaId=" + testDataMetaId
				+ ", testDataStatus=" + Arrays.toString(testDataStatus) + ", testCategory="
				+ Arrays.toString(testCategory) + ", jiraStory=" + jiraStory + ", testScripts=" + testScripts
				+ ", testShortDescription=" + testShortDescription + ", executedBy=" + Arrays.toString(executedBy)
				+ ", executedDateFrom=" + executedDateFrom + ", executedDateTo=" + executedDateTo + "]";
	}
    
	
    
}
