package backend.applications.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.applications.TestApplicationsInfo;
import backend.applications.applicationOne.TestDataMetaAppOneTableEntity;

@Entity
@Table(name="TEST_TABLE_INFO")
public class TestTablesInfo
{
	@Id
	@Column(name="ID")
	private long tableId;
	
	@Column(name="TABLE_NAME")
	private String tableName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "APPLICATION_ID")
	private TestApplicationsInfo testApplicationsInfo;

	@Column(name="DESCRIPTION")
	private String description;
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "testTableInfo", cascade = CascadeType.ALL)
	private List<TestDataMetaAppOneTableEntity> testDataMeta =new ArrayList<TestDataMetaAppOneTableEntity>();

	TestTablesInfo()
	{
		
	}

	public TestTablesInfo(long tableId, String tableName, TestApplicationsInfo testApplicationsInfo, String description,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate, String deleteFlag,
			List<TestDataMetaAppOneTableEntity> testDataMeta)
	{
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.testApplicationsInfo = testApplicationsInfo;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.deleteFlag = deleteFlag;
		this.testDataMeta = testDataMeta;
	}

	public long getTableId()
	{
		return tableId;
	}

	public void setTableId(long tableId)
	{
		this.tableId = tableId;
	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public TestApplicationsInfo getTestApplicationsInfo()
	{
		return testApplicationsInfo;
	}

	public void setTestApplicationsInfo(TestApplicationsInfo testApplicationsInfo)
	{
		this.testApplicationsInfo = testApplicationsInfo;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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

	public List<TestDataMetaAppOneTableEntity> getTestDataMeta()
	{
		return testDataMeta;
	}

	public void setTestDataMeta(List<TestDataMetaAppOneTableEntity> testDataMeta)
	{
		this.testDataMeta = testDataMeta;
	}

	@Override
	public String toString()
	{
		return "TestTablesInfo [tableId=" + tableId + ", tableName=" + tableName + ", description=" + description + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", deleteFlag="
				+ deleteFlag + "]";
	}

	
}
