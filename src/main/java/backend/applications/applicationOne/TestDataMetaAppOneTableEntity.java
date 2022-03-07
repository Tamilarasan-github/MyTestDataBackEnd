package backend.applications.applicationOne;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneTableEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoTableEntity;
import backend.applications.tables.TestTablesInfo;

@Component
@Entity
@Table(name="TEST_DATA_META")
public class TestDataMetaAppOneTableEntity
{
	@Id
	@Column(name="TEST_DATA_META_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long testDataMetaId;
	
	@ManyToOne
	@JoinColumn(name = "TEST_TABLE_ID", referencedColumnName = "ID", insertable=false, updatable = false)
	private TestTablesInfo testTableInfo;
	
	@Column(name = "TEST_TABLE_ID")
	private long testTableId;
	
	@Column(name="TEST_CASE_ID")
	private String testCaseId;
	
	@Column(name="TEST_SHORT_DESCRIPTION")
	private String testShortDescription;
	
	@Column(name="TEST_SCENARIO")
	private String testScenario;
	
	@Column(name="RUN_FLAG")
	private String runFlag;
	
	@Column(name="TEST_PRIORITY")
	private String testPriority;
	
	@Column(name="TEST_CATEGORY")
	private String testCategory;
	
	@Column(name="TEST_SCRIPT_NAME")
	private String testScriptName;
	
	@Column(name="JIRA_ID")
	private String jiraId;
	
	@Column(name="TEST_EXECUTION_TIME")
	private String testExecutionTime;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="DELETE_FLAG")
	private String deleteFlag;
	

	@OneToMany(mappedBy = "testDataMeta",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true)
	private List<TestDataAppOneTableOneTableEntity> testDataApp = new ArrayList<TestDataAppOneTableOneTableEntity>();
	
	@OneToMany(mappedBy = "testDataMeta",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<TestDataAppOneTableTwoTableEntity> testDataAppTableTwo = new ArrayList<TestDataAppOneTableTwoTableEntity>();
	
	protected TestDataMetaAppOneTableEntity()
	{
		
	}

	public TestDataMetaAppOneTableEntity(long testDataMetaId, TestTablesInfo testTableInfo, long testTableId, String testCaseId,
			String testShortDescription, String testScenario, String runFlag, String testPriority, String testCategory,
			String testScriptName, String jiraId, String testExecutionTime, String createdBy, Date createdDate,
			String updatedBy, Date updatedDate, String deleteFlag, List<TestDataAppOneTableOneTableEntity> testDataApp,
			List<TestDataAppOneTableTwoTableEntity> testDataAppTableTwo)
	{
		super();
		this.testDataMetaId = testDataMetaId;
		this.testTableInfo = testTableInfo;
		this.testTableId = testTableId;
		this.testCaseId = testCaseId;
		this.testShortDescription = testShortDescription;
		this.testScenario = testScenario;
		this.runFlag = runFlag;
		this.testPriority = testPriority;
		this.testCategory = testCategory;
		this.testScriptName = testScriptName;
		this.jiraId = jiraId;
		this.testExecutionTime = testExecutionTime;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.deleteFlag = deleteFlag;
		this.testDataApp = testDataApp;
		this.testDataAppTableTwo = testDataAppTableTwo;
	}

	public long getTestDataMetaId()
	{
		return testDataMetaId;
	}

	public void setTestDataMetaId(long testDataMetaId)
	{
		this.testDataMetaId = testDataMetaId;
	}

	public TestTablesInfo getTestTableInfo()
	{
		return testTableInfo;
	}

	public void setTestTableInfo(TestTablesInfo testTableInfo)
	{
		this.testTableInfo = testTableInfo;
	}

	public long getTestTableId()
	{
		return testTableId;
	}

	public void setTestTableId(long testTableId)
	{
		this.testTableId = testTableId;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getTestShortDescription()
	{
		return testShortDescription;
	}

	public void setTestShortDescription(String testShortDescription)
	{
		this.testShortDescription = testShortDescription;
	}

	public String getTestScenario()
	{
		return testScenario;
	}

	public void setTestScenario(String testScenario)
	{
		this.testScenario = testScenario;
	}

	public String getRunFlag()
	{
		return runFlag;
	}

	public void setRunFlag(String runFlag)
	{
		this.runFlag = runFlag;
	}

	public String getTestPriority()
	{
		return testPriority;
	}

	public void setTestPriority(String testPriority)
	{
		this.testPriority = testPriority;
	}

	public String getTestCategory()
	{
		return testCategory;
	}

	public void setTestCategory(String testCategory)
	{
		this.testCategory = testCategory;
	}

	public String getTestScriptName()
	{
		return testScriptName;
	}

	public void setTestScriptName(String testScriptName)
	{
		this.testScriptName = testScriptName;
	}

	public String getJiraId()
	{
		return jiraId;
	}

	public void setJiraId(String jiraId)
	{
		this.jiraId = jiraId;
	}

	public String getTestExecutionTime()
	{
		return testExecutionTime;
	}

	public void setTestExecutionTime(String testExecutionTime)
	{
		this.testExecutionTime = testExecutionTime;
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

	public List<TestDataAppOneTableOneTableEntity> getTestDataApp()
	{
		return testDataApp;
	}

	public void setTestDataApp(List<TestDataAppOneTableOneTableEntity> testDataApp)
	{
		this.testDataApp = testDataApp;
	}

	public List<TestDataAppOneTableTwoTableEntity> getTestDataAppTableTwo()
	{
		return testDataAppTableTwo;
	}

	public void setTestDataAppTableTwo(List<TestDataAppOneTableTwoTableEntity> testDataAppTableTwo)
	{
		this.testDataAppTableTwo = testDataAppTableTwo;
	}

	@Override
	public String toString()
	{
		return "TestDataMeta [testDataMetaId=" + testDataMetaId + ", testTableInfo=" + testTableInfo + ", testTableId="
				+ testTableId + ", testCaseId=" + testCaseId + ", testShortDescription=" + testShortDescription
				+ ", testScenario=" + testScenario + ", runFlag=" + runFlag + ", testPriority=" + testPriority
				+ ", testCategory=" + testCategory + ", testScriptName=" + testScriptName + ", jiraId=" + jiraId
				+ ", testExecutionTime=" + testExecutionTime + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", deleteFlag="
				+ deleteFlag + ", testDataApp=" + testDataApp + ", testDataAppTableTwo=" + testDataAppTableTwo + "]";
	}
	
	

}