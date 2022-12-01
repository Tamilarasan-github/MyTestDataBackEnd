package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.Date;

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
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "TEST_SCRIPT_EXEC_ID", sequenceName = "TEST_SCRIPT_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SCRIPT_EXEC_ID")
	private Integer id;
	
	@Column(name="SUITE_EXECUTION_ID")
	private long suiteExecutionId;
	
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
	
	@Column(name="EXECUTED_BY")
	private String executedBy;
	
	@Column(name="EXECUTED_DATE")
	private Date executedDate;
	
	
	public TestScriptsExecutionHistoryEntity()
	{
		
	}
	
	
	public TestScriptsExecutionHistoryEntity(Integer id, long suiteExecutionId, long suiteId, long testScriptsId,
			String testScriptsName, String testScriptsCategory, String testScriptsDescription, String executedBy,
			Date executedDate)
	{
		super();
		this.id = id;
		this.suiteExecutionId = suiteExecutionId;
		this.suiteId = suiteId;
		this.testScriptsId = testScriptsId;
		this.testScriptsName = testScriptsName;
		this.testScriptsCategory = testScriptsCategory;
		this.testScriptsDescription = testScriptsDescription;
		this.executedBy = executedBy;
		this.executedDate = executedDate;
	}


	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public long getSuiteExecutionId()
	{
		return suiteExecutionId;
	}

	public void setSuiteExecutionId(long suiteExecutionId)
	{
		this.suiteExecutionId = suiteExecutionId;
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


	public void setTestScriptsId(long testScriptsId)
	{
		this.testScriptsId = testScriptsId;
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


	public String getExecutedBy()
	{
		return executedBy;
	}


	public void setExecutedBy(String executedBy)
	{
		this.executedBy = executedBy;
	}


	public Date getExecutedDate()
	{
		return executedDate;
	}


	public void setExecutedDate(Date executedDate)
	{
		this.executedDate = executedDate;
	}


	@Override
	public String toString()
	{
		return "TestScriptsExecutionHistoryEntity [id=" + id + ", suiteExecutionId=" + suiteExecutionId + ", suiteId="
				+ suiteId + ", testScriptsId=" + testScriptsId + ", testScriptsName=" + testScriptsName
				+ ", testScriptsCategory=" + testScriptsCategory + ", testScriptsDescription=" + testScriptsDescription
				+ ", executedBy=" + executedBy + ", executedDate=" + executedDate + "]";
	}

	

	
}
