package backend.applications;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import backend.applications.tables.TestTablesInfo;

@Entity
@Table(name="TEST_APPLICATIONS_INFO")
public class TestApplicationsInfo
{
	@Id
	@Column(name="ID")
	private long applicationId;
	
	@Column(name="APPLICATION_NAME")
	private String applicationName;
		
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
	
	@OneToMany(mappedBy = "testApplicationsInfo",
	            cascade = CascadeType.ALL)   
	private List<TestTablesInfo> testTablesInfo = new ArrayList<TestTablesInfo>();

	TestApplicationsInfo(){
		 
	 }

	public TestApplicationsInfo(long applicationId, String applicationName, String description, String createdBy,
			Date createdDate, String updatedBy, Date updatedDate, String deleteFlag,
			List<TestTablesInfo> testTablesInfo)
	{
		super();
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.deleteFlag = deleteFlag;
		this.testTablesInfo = testTablesInfo;
	}

	public long getApplicationId()
	{
		return applicationId;
	}

	public void setApplicationId(long applicationId)
	{
		this.applicationId = applicationId;
	}

	public String getApplicationName()
	{
		return applicationName;
	}

	public void setApplicationName(String applicationName)
	{
		this.applicationName = applicationName;
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

	public List<TestTablesInfo> getTestTablesInfo()
	{
		return testTablesInfo;
	}

	public void setTestTablesInfo(List<TestTablesInfo> testTablesInfo)
	{
		this.testTablesInfo = testTablesInfo;
	}

	@Override
	public String toString()
	{
		return "TestApplicationsInfo [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", description=" + description + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", deleteFlag=" + deleteFlag
				+ ", testTablesInfo=" + testTablesInfo + "]";
	}
	 
	
	
}
