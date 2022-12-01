package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TEST_DATA_META_EXECUTION_HISTORY_APP_ONE")
public class TestDataMetaExecutionHistoryEntity
{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "TEST_DATA_EXECUTION_ID", sequenceName = "TEST_DATA_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_DATA_EXECUTION_ID")
	private Integer id;
	
	@Column(name="SUITE_EXECUTION_ID")
	private Integer suiteExecutionId;
	
	@Column(name="SUITE_ID")
	private Integer suiteId;
	
	@Column(name="TEST_SCRIPT_EXECUTION_ID")
	private Integer testScriptExecutionId;
	
	@Column(name="TEST_SCRIPT_ID")
	private Integer testScriptId;
	
	@Column(name="TEST_SCRIPT_NAME")
	private String testScriptName;
	
	@Column(name="TEST_DATA_META_ID")
	private Integer testDataMetaId;
	
	@Column(name="TEST_CASE_ID")
	private String testCaseId;
		
	@Column(name="RUN_FLAG")
	private String runFlag;
	
	@Column(name="TEST_SCENARIO")
	private String testScenario;
	
	@Column(name="TEST_PRIORITY")
	private int testPriority;
	
	@Column(name="TEST_CASE_CATEGORY")
	private String testCaseCategory;
	
	@Column(name="JIRA_ID")
	private String jiraId;
	
	@Column(name="AUTOMATED_TEST_STATUS")
	private String automatedTestStatus;
	
	@Column(name="MANUAL_TEST_STATUS")
	private String manualTestStatus;
	
	@Column(name="TEST_FAIL_REASON")
	private String testFailReason;
	
	@Column(name="TEST_INFORMATION")
	private String testInformation;
	
	@Column(name="TEST_COMMENTS")
	private String testComments;
	
	@Column(name="TEST_IGNORED")
	private String testIgnored;
	
	@Column(name="EXECUTION_STATUS")
	private String executionStatus;
	
	@Column(name="EXECUTION_TIME")
	private Integer executionTime;
	
	@Column(name="EXECUTED_BY")
	private String executedBy;
	
	@Column(name="EXECUTED_ON")
	private Date executedOn;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="DELETE_FLAG")
	private String deleteFlag;
	
	
	public TestDataMetaExecutionHistoryEntity()
	{
		
	}

	public TestDataMetaExecutionHistoryEntity(Integer id, Integer suiteExecutionId, Integer suiteId,
			Integer testScriptExecutionId, Integer testScriptId, String testScriptName, Integer testDataMetaId,
			String testCaseId, String runFlag, String testScenario, int testPriority, String testCaseCategory,
			String jiraId, String automatedTestStatus, String manualTestStatus, String testFailReason,
			String testInformation, String testComments, String testIgnored, String executionStatus,
			Integer executionTime, String executedBy, Date executedOn, String updatedBy, Date updatedDate,
			String deleteFlag)
	{
		super();
		this.id = id;
		this.suiteExecutionId = suiteExecutionId;
		this.suiteId = suiteId;
		this.testScriptExecutionId = testScriptExecutionId;
		this.testScriptId = testScriptId;
		this.testScriptName = testScriptName;
		this.testDataMetaId = testDataMetaId;
		this.testCaseId = testCaseId;
		this.runFlag = runFlag;
		this.testScenario = testScenario;
		this.testPriority = testPriority;
		this.testCaseCategory = testCaseCategory;
		this.jiraId = jiraId;
		this.automatedTestStatus = automatedTestStatus;
		this.manualTestStatus = manualTestStatus;
		this.testFailReason = testFailReason;
		this.testInformation = testInformation;
		this.testComments = testComments;
		this.testIgnored = testIgnored;
		this.executionStatus = executionStatus;
		this.executionTime = executionTime;
		this.executedBy = executedBy;
		this.executedOn = executedOn;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.deleteFlag = deleteFlag;
	}



	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public Integer getSuiteExecutionId()
	{
		return suiteExecutionId;
	}


	public void setSuiteExecutionId(Integer suiteExecutionId)
	{
		this.suiteExecutionId = suiteExecutionId;
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


	public Integer getTestScriptId()
	{
		return testScriptId;
	}


	public void setTestScriptId(Integer testScriptId)
	{
		this.testScriptId = testScriptId;
	}


	public String getTestScriptName()
	{
		return testScriptName;
	}


	public void setTestScriptName(String testScriptName)
	{
		this.testScriptName = testScriptName;
	}


	public Integer getTestDataMetaId()
	{
		return testDataMetaId;
	}


	public void setTestDataMetaId(Integer testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}


	public String getTestCaseId()
	{
		return testCaseId;
	}


	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}


	public String getRunFlag()
	{
		return runFlag;
	}


	public void setRunFlag(String runFlag)
	{
		this.runFlag = runFlag;
	}


	public String getTestScenario()
	{
		return testScenario;
	}


	public void setTestScenario(String testScenario)
	{
		this.testScenario = testScenario;
	}


	public int getTestPriority()
	{
		return testPriority;
	}


	public void setTestPriority(int testPriority)
	{
		this.testPriority = testPriority;
	}


	public String getTestCaseCategory()
	{
		return testCaseCategory;
	}


	public void setTestCaseCategory(String testCaseCategory)
	{
		this.testCaseCategory = testCaseCategory;
	}


	public String getJiraId()
	{
		return jiraId;
	}


	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}


	public String getAutomatedTestStatus()
	{
		return automatedTestStatus;
	}


	public void setAutomatedTestStatus(String automatedTestStatus)
	{
		this.automatedTestStatus = automatedTestStatus;
	}


	public String getManualTestStatus()
	{
		return manualTestStatus;
	}


	public void setManualTestStatus(String manualTestStatus)
	{
		this.manualTestStatus = manualTestStatus;
	}


	public String getTestFailReason()
	{
		return testFailReason;
	}


	public void setTestFailReason(String testFailReason)
	{
		this.testFailReason = testFailReason;
	}


	public String getTestInformation()
	{
		return testInformation;
	}


	public void setTestInformation(String testInformation)
	{
		this.testInformation = testInformation;
	}


	public String getTestComments()
	{
		return testComments;
	}


	public void setTestComments(String testComments)
	{
		this.testComments = testComments;
	}


	public String getTestIgnored()
	{
		return testIgnored;
	}


	public void setTestIgnored(String testIgnored)
	{
		this.testIgnored = testIgnored;
	}


	public String getExecutionStatus()
	{
		return executionStatus;
	}


	public void setExecutionStatus(String executionStatus)
	{
		this.executionStatus = executionStatus;
	}


	public Integer getExecutionTime()
	{
		return executionTime;
	}


	public void setExecutionTime(Integer executionTime)
	{
		this.executionTime = executionTime;
	}


	public String getExecutedBy()
	{
		return executedBy;
	}


	public void setExecutedBy(String executedBy)
	{
		this.executedBy = executedBy;
	}


	public Date getExecutedOn()
	{
		return executedOn;
	}


	public void setExecutedOn(Date executedOn)
	{
		this.executedOn = executedOn;
	}


	public String getUpdatedBy()
	{
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate()
	{
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}


	public String getDeleteFlag()
	{
		return deleteFlag;
	}


	public void setDeleteFlag(String deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}


	@Override
	public String toString()
	{
		return "TestDataExecutionHistoryMetaEntity [id=" + id + ", suiteExecutionId=" + suiteExecutionId + ", suiteId="
				+ suiteId + ", testScriptExecutionId=" + testScriptExecutionId + ", testScriptId=" + testScriptId
				+ ", testScriptName=" + testScriptName + ", testDataMetaId=" + testDataMetaId + ", testCaseId="
				+ testCaseId + ", runFlag=" + runFlag + ", testScenario=" + testScenario + ", testPriority="
				+ testPriority + ", testCaseCategory=" + testCaseCategory + ", jiraId=" + jiraId
				+ ", automatedTestStatus=" + automatedTestStatus + ", manualTestStatus=" + manualTestStatus
				+ ", testFailReason=" + testFailReason + ", testInformation=" + testInformation + ", testComments="
				+ testComments + ", testIgnored=" + testIgnored + ", executionStatus=" + executionStatus
				+ ", executionTime=" + executionTime + ", executedBy=" + executedBy + ", executedOn=" + executedOn
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
	
	

}
