package backend.applications.applicationOne.testExecutionResults.testData;

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
@Table(name="TEST_DATA_EXECUTION_HISTORY_META_APP_ONE")
public class TestDataExecutionHistoryMetaEntity
{
	@Id
	@Column(name="TEST_DATA_EXEC_ID")
//	@SequenceGenerator(name = "TEST_DATA_EXECUTION_ID", sequenceName = "TEST_DATA_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_DATA_EXECUTION_ID")
	private long testDataExecutionId;
	
	@Column(name="SUITE_ID")
	private long suiteId;
	
	@Column(name="TEST_SCRIPT_EXEC_ID")
	private long testScriptExecutionId;
	
	@Column(name="TEST_DATA_META_ID")
	private long testDataMetaId;
	
	@Column(name="TEST_CASE_ID")
	private String testCaseId;
	
	@Column(name="TEST_SCRIPT_NAME")
	private String testScriptName;
	
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
	private String executionTime;
	
	@Column(name="EXECUTED_BY")
	private String executedBy;
	
	@Column(name="EXECUTED_ON")
	private String executedOn;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private String updatedDate;
	
	@Column(name="DELETE_FLAG")
	private String deleteFlag;
	
	
	public TestDataExecutionHistoryMetaEntity()
	{
		
	}
	
	public TestDataExecutionHistoryMetaEntity(long testDataExecutionId, long suiteId, long testScriptExecutionId,
			long testDataMetaId, String testCaseId, String testScriptName, String runFlag, String testScenario,
			int testPriority, String testCaseCategory, String jiraId, String automatedTestStatus,
			String manualTestStatus, String testFailReason, String testInformation, String testComments,
			String testIgnored, String executionStatus, String executionTime, String executedBy, String executedOn,
			String updatedBy, String updatedDate, String deleteFlag)
	{
		super();
		this.testDataExecutionId = testDataExecutionId;
		this.suiteId = suiteId;
		this.testScriptExecutionId = testScriptExecutionId;
		this.testDataMetaId = testDataMetaId;
		this.testCaseId = testCaseId;
		this.testScriptName = testScriptName;
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
	public long getTestDataExecutionId()
	{
		return testDataExecutionId;
	}
	public void setTestDataExecutionId(long testDataExecutionId)
	{
		this.testDataExecutionId = testDataExecutionId;
	}
	public long getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(long suiteId)
	{
		this.suiteId = suiteId;
	}
	public long getTestScriptExecutionId()
	{
		return testScriptExecutionId;
	}
	public void setTestScriptExecutionId(long testScriptExecutionId)
	{
		this.testScriptExecutionId = testScriptExecutionId;
	}
	public long getTestDataMetaId()
	{
		return testDataMetaId;
	}
	public void setTestDataMetaId(long testDataMetaId)
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
	public String getTestScriptName()
	{
		return testScriptName;
	}
	public void setTestScriptName(String testScriptName)
	{
		this.testScriptName = testScriptName;
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
	public String getExecutionTime()
	{
		return executionTime;
	}
	public void setExecutionTime(String executionTime)
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
	public String getExecutedOn()
	{
		return executedOn;
	}
	public void setExecutedOn(String executedOn)
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
	public String getUpdatedDate()
	{
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate)
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
		return "TestDataExecutionHistoryMeta [testDataExecutionId=" + testDataExecutionId + ", suiteId=" + suiteId
				+ ", testScriptExecutionId=" + testScriptExecutionId + ", testDataMetaId=" + testDataMetaId
				+ ", testCaseId=" + testCaseId + ", testScriptName=" + testScriptName + ", runFlag=" + runFlag
				+ ", testScenario=" + testScenario + ", testPriority=" + testPriority + ", testCaseCategory="
				+ testCaseCategory + ", jiraId=" + jiraId + ", automatedTestStatus=" + automatedTestStatus
				+ ", manualTestStatus=" + manualTestStatus + ", testFailReason=" + testFailReason + ", testInformation="
				+ testInformation + ", testComments=" + testComments + ", testIgnored=" + testIgnored
				+ ", executionStatus=" + executionStatus + ", executionTime=" + executionTime + ", executedBy="
				+ executedBy + ", executedOn=" + executedOn + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", deleteFlag=" + deleteFlag + "]";
	}
	
	

}
