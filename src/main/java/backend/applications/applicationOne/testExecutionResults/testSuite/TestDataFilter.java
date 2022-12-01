package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.Arrays;
import java.util.Date;

public class TestDataFilter
{
	private String runFlag[];
	
	private String testCategory[];
	
	private Integer testPriority[];
	
	private String createdBy[];
	
	private Date createdDateFrom;
	
	private Date createdDateTo;
	
	TestDataFilter()
	{}

	public TestDataFilter(String[] runFlag, String[] testCategory, Integer[] testPriority, String[] createdBy,
			Date createdDateFrom, Date createdDateTo)
	{
		super();
		this.runFlag = runFlag;
		this.testCategory = testCategory;
		this.testPriority = testPriority;
		this.createdBy = createdBy;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
	}

	public String[] getRunFlag()
	{
		return runFlag;
	}

	public void setRunFlag(String[] runFlag)
	{
		this.runFlag = runFlag;
	}

	public String[] getTestCategory()
	{
		return testCategory;
	}

	public void setTestCategory(String[] testCategory)
	{
		this.testCategory = testCategory;
	}

	public Integer[] getTestPriority()
	{
		return testPriority;
	}

	public void setTestPriority(Integer[] testPriority)
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
		return "TestDataFilter [runFlag=" + Arrays.toString(runFlag) + ", testCategory=" + Arrays.toString(testCategory)
				+ ", testPriority=" + Arrays.toString(testPriority) + ", createdBy=" + Arrays.toString(createdBy)
				+ ", createdDateFrom=" + createdDateFrom + ", createdDateTo=" + createdDateTo + "]";
	}

	
}
