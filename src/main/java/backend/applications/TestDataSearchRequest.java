package backend.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class TestDataSearchRequest
{
	private long testDataMetaId[];
	private long testTableId;
	private String testcaseId[];
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

	public long[] getTestDataMetaId()
	{
		return testDataMetaId;
	}

	public void setTestDataMetaId(long[] testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}

	public long getTestTableId()
	{
		return testTableId;
	}

	public void setTestTableId(long testTableId)
	{
		this.testTableId = testTableId;
	}

	public String[] getTestcaseId()
	{
		return testcaseId;
	}

	public void setTestcaseId(String[] testcaseId)
	{
		this.testcaseId = testcaseId;
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

	
	
}