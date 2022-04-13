package backend.applications;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class TestDataSearchRequest
{
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Integer> testDataMetaId;
	private List<Integer> testTables[];
	private String testCaseId[];
	private String jiraId[];
	private String runFlag[];
	private String testScriptName[];
	private String testShortDescription[];
	private String testCategory[];
	private String testPriority[];
	private String createdBy[];
	private Date createdFrom;
	private Date createdTo;
	private String updatedBy[];
	private Date updatedFrom;
	private Date updatedTo;
	
	TestDataSearchRequest()
	{
		
	}

	public List<Integer> getTestDataMetaId()
	{
		return testDataMetaId;
	}

	public void setTestDataMetaId(List<Integer> testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}
	
	
	public List<Integer>[] getTestTables()
	{
		return testTables;
	}

	public void setTestTables(List<Integer>[] testTables)
	{
		this.testTables = testTables;
	}

	public String[] getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String[] testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String[] getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(String[] jiraId)
	{
		this.jiraId = jiraId;
	}

	public String[] getRunFlag()
	{
		return runFlag;
	}

	public void setRunFlag(String[] runFlag)
	{
		this.runFlag = runFlag;
	}

	public String[] getTestScriptName()
	{
		return testScriptName;
	}

	public void setTestScriptName(String[] testScriptName)
	{
		this.testScriptName = testScriptName;
	}

	public String[] getTestShortDescription()
	{
		return testShortDescription;
	}

	public void setTestShortDescription(String[] testShortDescription)
	{
		this.testShortDescription = testShortDescription;
	}

	public String[] getTestCategory()
	{
		return testCategory;
	}

	public void setTestCategory(String[] testCategory)
	{
		this.testCategory = testCategory;
	}

	public String[] getTestPriority()
	{
		return testPriority;
	}

	public void setTestPriority(String[] testPriority)
	{
		this.testPriority = testPriority;
	}

	public String[] getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String[] createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedFrom()
	{
		return createdFrom;
	}

	public void setCreatedFrom(Date createdFrom)
	{
		this.createdFrom = createdFrom;
	}

	public Date getCreatedTo()
	{
		return createdTo;
	}

	public void setCreatedTo(Date createdTo)
	{
		this.createdTo = createdTo;
	}

	public String[] getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String[] updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedFrom()
	{
		return updatedFrom;
	}

	public void setUpdatedFrom(Date updatedFrom)
	{
		this.updatedFrom = updatedFrom;
	}

	public Date getUpdatedTo()
	{
		return updatedTo;
	}

	public void setUpdatedTo(Date updatedTo)
	{
		this.updatedTo = updatedTo;
	}

	@Override
	public String toString()
	{
		return "TestDataSearchRequest [testDataMetaId=" + testDataMetaId + ", testTables=" + Arrays.toString(testTables)
				+ ", testCaseId=" + Arrays.toString(testCaseId) + ", jiraId=" + Arrays.toString(jiraId) + ", runFlag="
				+ Arrays.toString(runFlag) + ", testScriptName=" + Arrays.toString(testScriptName)
				+ ", testShortDescription=" + Arrays.toString(testShortDescription) + ", testCategory="
				+ Arrays.toString(testCategory) + ", testPriority=" + Arrays.toString(testPriority) + ", createdBy="
				+ Arrays.toString(createdBy) + ", createdFrom=" + createdFrom + ", createdTo=" + createdTo
				+ ", updatedBy=" + Arrays.toString(updatedBy) + ", updatedFrom=" + updatedFrom + ", updatedTo="
				+ updatedTo + "]";
	}
	
	
}