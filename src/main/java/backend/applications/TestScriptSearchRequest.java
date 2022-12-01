package backend.applications;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class TestScriptSearchRequest
{
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Integer> testScriptsId;
	private String testScripts[];
	private String testScriptsCategory[];
	private String createdBy[];
	private Date createdDateFrom;
	private Date createdDateTo;
	private String updatedBy[];
	private Date updatedDateFrom;
	private Date updatedDateTo;
	
	TestScriptSearchRequest()
	{
		
	}

	public TestScriptSearchRequest(List<Integer> testScriptsId, String[] testScripts, String[] testScriptsCategory,
			String[] createdBy, Date createdDateFrom, Date createdDateTo, String[] updatedBy, Date updatedDateFrom,
			Date updatedDateTo)
	{
		super();
		this.testScriptsId = testScriptsId;
		this.testScripts = testScripts;
		this.testScriptsCategory = testScriptsCategory;
		this.createdBy = createdBy;
		this.createdDateFrom = createdDateFrom;
		this.createdDateTo = createdDateTo;
		this.updatedBy = updatedBy;
		this.updatedDateFrom = updatedDateFrom;
		this.updatedDateTo = updatedDateTo;
	}

	public List<Integer> getTestScriptsId()
	{
		return testScriptsId;
	}

	public void setTestScriptsId(List<Integer> testScriptsId)
	{
		this.testScriptsId = testScriptsId;
	}

	public String[] getTestScripts()
	{
		return testScripts;
	}

	public void setTestScripts(String[] testScripts)
	{
		this.testScripts = testScripts;
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

	public String[] getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String[] updatedBy)
	{
		this.updatedBy = updatedBy;
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
		return "TestScriptSearchRequest [testScriptsId=" + testScriptsId + ", testScripts="
				+ Arrays.toString(testScripts) + ", testScriptsCategory=" + Arrays.toString(testScriptsCategory)
				+ ", createdBy=" + Arrays.toString(createdBy) + ", createdDateFrom=" + createdDateFrom
				+ ", createdDateTo=" + createdDateTo + ", updatedBy=" + Arrays.toString(updatedBy)
				+ ", updatedDateFrom=" + updatedDateFrom + ", updatedDateTo=" + updatedDateTo + "]";
	}

	


	
	
}