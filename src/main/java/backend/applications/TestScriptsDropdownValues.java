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
public class TestScriptsDropdownValues
{
	private List<Integer> testScriptsId;
		
	private List<String> testScripts;
	
	private List<String> testScriptsCategory;

	private List<String> createdBy;

	private List<String> updatedBy;

	public TestScriptsDropdownValues(List<Integer> testScriptId, List<String> testScripts,
			List<String> testScriptsCategory, List<String> createdBy, List<String> updatedBy)
	{
		super();
		this.testScriptsId = testScriptId;
		this.testScripts = testScripts;
		this.testScriptsCategory = testScriptsCategory;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public List<Integer> getTestScriptsId()
	{
		return testScriptsId;
	}

	public void setTestScriptsId(List<Integer> testScriptId)
	{
		this.testScriptsId = testScriptId;
	}

	public List<String> getTestScripts()
	{
		return testScripts;
	}

	public void setTestScripts(List<String> testScripts)
	{
		this.testScripts = testScripts;
	}

	public List<String> getTestScriptsCategory()
	{
		return testScriptsCategory;
	}

	public void setTestScriptsCategory(List<String> testScriptsCategory)
	{
		this.testScriptsCategory = testScriptsCategory;
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
		return "TestScriptsDropdownValues [testScriptsId=" + testScriptsId + ", testScripts=" + testScripts
				+ ", testScriptsCategory=" + testScriptsCategory + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}

	
	
	
}
