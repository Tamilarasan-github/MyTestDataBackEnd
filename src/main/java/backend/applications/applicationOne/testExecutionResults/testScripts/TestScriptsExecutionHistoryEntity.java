package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TEST_SCRIPTS_EXECUTION_HISTORY_APP_ONE")
public class TestScriptsExecutionHistoryEntity
{
	@Id
	@Column(name="TEST_SCRIPT_EXEC_ID")
	@SequenceGenerator(name = "TEST_SCRIPT_EXEC_ID", sequenceName = "TEST_SCRIPT_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SCRIPT_EXEC_ID")
	private long testScriptExecutionId;
	
	@Column(name="SUITE_ID")
	private long suiteId;
	
	@Column(name="TEST_SCRIPT_ID")
	private long testScriptsId;
	
	@Column(name="TEST_SCRIPT_NAME")
	private String testScriptsName;
	
	@Column(name="TEST_SCRIPT_CATEGORY")
	private String testScriptsCategory;
	
	@Column(name="TEST_SCRIPT_DESCRIPTION")
	private String testScriptsDescription;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	
	public TestScriptsExecutionHistoryEntity()
	{
		
	}


	public TestScriptsExecutionHistoryEntity(long testScriptExecutionId, long suiteId, long testScriptsId,
			String testScriptsName, String testScriptsCategory, String testScriptsDescription, String createdBy,
			Date createdDate)
	{
		super();
		this.testScriptExecutionId = testScriptExecutionId;
		this.suiteId = suiteId;
		this.testScriptsId = testScriptsId;
		this.testScriptsName = testScriptsName;
		this.testScriptsCategory = testScriptsCategory;
		this.testScriptsDescription = testScriptsDescription;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}


	public long getTestScriptExecutionId()
	{
		return testScriptExecutionId;
	}


	public void setTestScriptExecutionId(long testScriptExecutionId)
	{
		this.testScriptExecutionId = testScriptExecutionId;
	}


	public long getSuiteId()
	{
		return suiteId;
	}


	public void setSuiteId(long suiteId)
	{
		this.suiteId = suiteId;
	}


	public long getTestScriptsId()
	{
		return testScriptsId;
	}


	public void setTestScriptsId(long integer)
	{
		this.testScriptsId = integer;
	}


	public String getTestScriptsName()
	{
		return testScriptsName;
	}


	public void setTestScriptsName(String testScriptsName)
	{
		this.testScriptsName = testScriptsName;
	}


	public String getTestScriptsCategory()
	{
		return testScriptsCategory;
	}


	public void setTestScriptsCategory(String testScriptsCategory)
	{
		this.testScriptsCategory = testScriptsCategory;
	}


	public String getTestScriptsDescription()
	{
		return testScriptsDescription;
	}


	public void setTestScriptsDescription(String testScriptsDescription)
	{
		this.testScriptsDescription = testScriptsDescription;
	}


	public String getCreatedBy()
	{
		return createdBy;
	}


	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}


	public Date getCreatedDate()
	{
		return createdDate;
	}


	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}


	@Override
	public String toString()
	{
		return "TestScriptsExecutionHistoryEntity [testScriptExecutionId=" + testScriptExecutionId + ", suiteId="
				+ suiteId + ", testScriptsId=" + testScriptsId + ", testScriptsName=" + testScriptsName
				+ ", testScriptsCategory=" + testScriptsCategory + ", testScriptsDescription=" + testScriptsDescription
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

	
}
