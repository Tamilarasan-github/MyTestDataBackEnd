package backend.applications;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class TestScriptSearchRequest
{
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private String testScriptsId[];
	private String testScripts[];
	private String testScriptsCategory[];
	private String createdBy[];
	private Date createdFrom;
	private Date createdTo;
	private String updatedBy[];
	private Date updatedFrom;
	private Date updatedTo;
	
	TestScriptSearchRequest()
	{
		
	}

	public TestScriptSearchRequest(String[] testScriptsId, String[] testScripts, String[] testScriptsCategory,
			String[] createdBy, Date createdFrom, Date createdTo, String[] updatedBy, Date updatedFrom, Date updatedTo)
	{
		super();
		this.testScriptsId = testScriptsId;
		this.testScripts = testScripts;
		this.testScriptsCategory = testScriptsCategory;
		this.createdBy = createdBy;
		this.createdFrom = createdFrom;
		this.createdTo = createdTo;
		this.updatedBy = updatedBy;
		this.updatedFrom = updatedFrom;
		this.updatedTo = updatedTo;
	}

	public String[] getTestScriptsId()
	{
		return testScriptsId;
	}

	public void setTestScriptsId(String[] testScriptsId)
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
		return "TestScriptSearchRequest [testScriptsId=" + Arrays.toString(testScriptsId) + ", testScripts="
				+ Arrays.toString(testScripts) + ", testScriptsCategory=" + Arrays.toString(testScriptsCategory)
				+ ", createdBy=" + Arrays.toString(createdBy) + ", createdFrom=" + createdFrom + ", createdTo="
				+ createdTo + ", updatedBy=" + Arrays.toString(updatedBy) + ", updatedFrom=" + updatedFrom
				+ ", updatedTo=" + updatedTo + "]";
	}

	
}