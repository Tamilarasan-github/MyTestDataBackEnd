/**
 * 
 */
package backend.applications;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author tamil
 *
 */
public class TestDataMetaDropdownValues
{
	private List<Integer> testDataMetaId;
		
	private List<String> testCaseId;
	
	private List<String> testShortDescription;
	
	private List<String> runFlag;

	private List<String> testPriority;

	private List<String> testCategory;

	private List<String> testScriptName;

	private List<String> jiraId;

	private List<String> createdBy;

	private List<String> updatedBy;

	public TestDataMetaDropdownValues(List<Integer> testDataMetaId, List<String> testCaseId,
			List<String> testShortDescription, List<String> runFlag, List<String> testPriority,
			List<String> testCategory, List<String> testScriptName, List<String> jiraId, List<String> createdBy,
			List<String> updatedBy)
	{
		super();
		this.testDataMetaId = testDataMetaId;
		this.testCaseId = testCaseId;
		this.testShortDescription = testShortDescription;
		this.runFlag = runFlag;
		this.testPriority = testPriority;
		this.testCategory = testCategory;
		this.testScriptName = testScriptName;
		this.jiraId = jiraId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}


	public List<Integer> getTestDataMetaId()
	{
		return testDataMetaId;
	}

	public void setTestDataMetaId(List<Integer> testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}

	public List<String> getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(List<String> testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public List<String> getTestShortDescription()
	{
		return testShortDescription;
	}

	public void setTestShortDescription(List<String> testShortDescription)
	{
		this.testShortDescription = testShortDescription;
	}

	public List<String> getRunFlag()
	{
		return runFlag;
	}

	public void setRunFlag(List<String> runFlag)
	{
		this.runFlag = runFlag;
	}

	public List<String> getTestPriority()
	{
		return testPriority;
	}

	public void setTestPriority(List<String> testPriority)
	{
		this.testPriority = testPriority;
	}

	public List<String> getTestCategory()
	{
		return testCategory;
	}

	public void setTestCategory(List<String> testCategory)
	{
		this.testCategory = testCategory;
	}

	public List<String> getTestScriptName()
	{
		return testScriptName;
	}

	public void setTestScriptName(List<String> testScriptName)
	{
		this.testScriptName = testScriptName;
	}

	public List<String> getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(List<String> jiraId)
	{
		this.jiraId = jiraId;
	}

	public List<String> getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(List<String> createdBy)
	{
		this.createdBy = createdBy;
	}

	public List<String> getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(List<String> updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString()
	{
		return "TestDataMetaDropdownValues [testDataMetaId=" + testDataMetaId + ", testCaseId=" + testCaseId + ", testShortDescription=" + testShortDescription + ", runFlag="
				+ runFlag + ", testPriority=" + testPriority + ", testCategory=" + testCategory + ", testScriptName="
				+ testScriptName + ", jiraId=" + jiraId + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
