package backend.applications.applicationOne.testScripts;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TEST_SCRIPTS_APP_ONE")
public class TestScriptsEntity
{
	@Id
	@Column(name="TEST_SCRIPT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testScriptsId;
	
	@Column(name="TEST_SCRIPT_NAME")
	private String testScripts;
	
	@Column(name="TEST_SCRIPT_CATEGORY")
	private String testScriptsCategory;
	
	@Column(name="TEST_SCRIPT_DESCRIPTION")
	private String testScriptsDescription;
		
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
	
	protected TestScriptsEntity()
	{
		
	}

	public TestScriptsEntity(Integer testScriptsId, String testScripts, String testScriptsCategory,
			String testScriptsDescription, String createdBy, Date createdDate, String updatedBy, Date updatedDate,
			String deleteFlag)
	{
		super();
		this.testScriptsId = testScriptsId;
		this.testScripts = testScripts;
		this.testScriptsCategory = testScriptsCategory;
		this.testScriptsDescription = testScriptsDescription;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.deleteFlag = deleteFlag;
	}

	public Integer getTestScriptsId()
	{
		return testScriptsId;
	}

	public void setTestScriptsId(Integer testScriptsId)
	{
		this.testScriptsId = testScriptsId;
	}

	public String getTestScripts()
	{
		return testScripts;
	}

	public void setTestScripts(String testScripts)
	{
		this.testScripts = testScripts;
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
		return "TestScriptsAppOneEntity [testScriptsId=" + testScriptsId + ", testScripts=" + testScripts
				+ ", testScriptsCategory=" + testScriptsCategory + ", testScriptsDescription=" + testScriptsDescription
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", deleteFlag=" + deleteFlag + "]";
	}

	
	
}
