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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableTwo.TestDataAppOneTableTwoEntity;
import backend.applications.tables.TestTablesInfo;

@Component
@Entity
@Table(name="TEST_DATA_META_APP_ONE")
public class TestDataMetaAppOneEntity
{
	@Id
	@Column(name="TEST_DATA_META_ID")
//	@SequenceGenerator(name = "TEST_DATA_META_ID", sequenceName = "TEST_DATA_META_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_DATA_META_ID")
	private Integer testDataMetaId;
		
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
	
	@Column(name = "TEST_TABLE_ONE")
	private Integer testTableOne;
	
	@Column(name = "TEST_TABLE_TWO")
	private Integer testTableTwo;
	
	@Column(name = "TEST_TABLE_THREE")
	private Integer testTableThree;
	

	@OneToMany(mappedBy = "testDataMeta",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true)
	private List<TestDataAppOneTableOneEntity> testDataAppOneTableOne = new ArrayList<TestDataAppOneTableOneEntity>();
	
	@OneToMany(mappedBy = "testDataMeta",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwo = new ArrayList<TestDataAppOneTableTwoEntity>();
	
	public TestDataMetaAppOneEntity()
	{
		
	}

	public TestDataMetaAppOneEntity(Integer testDataMetaId, String testCaseId, String testShortDescription,
			String testScenario, String runFlag, String testPriority, String testCategory, String testScriptName,
			String jiraId, String testExecutionTime, String createdBy, Date createdDate, String updatedBy,
			Date updatedDate, String deleteFlag, Integer testTableOne, Integer testTableTwo, Integer testTableThree,
			List<TestDataAppOneTableOneEntity> testDataAppOneTableOne,
			List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwo)
	{
		super();
		this.testDataMetaId = testDataMetaId;
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
		this.testTableOne = testTableOne;
		this.testTableTwo = testTableTwo;
		this.testTableThree =  testTableThree;
		this.testDataAppOneTableOne = testDataAppOneTableOne;
		this.testDataAppOneTableTwo = testDataAppOneTableTwo;
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

	public Integer getTestTableOne()
	{
		return testTableOne;
	}

	public void setTestTableOne(Integer testTableOne)
	{
		this.testTableOne = testTableOne;
	}

	public Integer getTestTableTwo()
	{
		return testTableTwo;
	}

	public void setTestTableTwo(Integer testTableTwo)
	{
		this.testTableTwo = testTableTwo;
	}

	public Integer getTestTableThree()
	{
		return testTableThree;
	}

	public void setTestTableThree(Integer testTableThree)
	{
		this.testTableThree = testTableThree;
	}

	public List<TestDataAppOneTableOneEntity> getTestDataAppOneTableOne()
	{
		return testDataAppOneTableOne;
	}

	public void setTestDataAppOneTableOne(List<TestDataAppOneTableOneEntity> testDataAppOneTableOne)
	{
		this.testDataAppOneTableOne = testDataAppOneTableOne;
	}

	public List<TestDataAppOneTableTwoEntity> getTestDataAppOneTableTwo()
	{
		return testDataAppOneTableTwo;
	}

	public void setTestDataAppOneTableTwo(List<TestDataAppOneTableTwoEntity> testDataAppOneTableTwoEntityList)
	{
		this.testDataAppOneTableTwo = testDataAppOneTableTwoEntityList;
	}

	@Override
	public String toString()
	{
		return "TestDataMetaAppOneTableEntity [testDataMetaId=" + testDataMetaId + ", testCaseId=" + testCaseId
				+ ", testShortDescription=" + testShortDescription + ", testScenario=" + testScenario + ", runFlag="
				+ runFlag + ", testPriority=" + testPriority + ", testCategory=" + testCategory + ", testScriptName="
				+ testScriptName + ", jiraId=" + jiraId + ", testExecutionTime=" + testExecutionTime + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", deleteFlag=" + deleteFlag + ", testTableOne=" + testTableOne + ", testTableTwo="
				+ testTableTwo + ", testTableThree=" + testTableThree + ", testDataAppOneTableOne="
				+ testDataAppOneTableOne + ", testDataAppOneTableTwo=" + testDataAppOneTableTwo + "]";
	}

	
}