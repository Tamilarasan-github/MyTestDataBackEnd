package backend.applications.applicationOne.suites;

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
@Table(name="TEST_SUITE_APP_ONE")
public class TestSuiteEntity
{
	@Id
	@Column(name="SUITE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "SUITE_ID", sequenceName = "TEST_SUITE_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUITE_ID")
	private Integer suiteId;
	
	@Column(name="SUITE_NAME")
	private String suiteName;
	
	@Column(name="SUITE_DESCRIPTION")
	private String suiteDescription;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	public TestSuiteEntity()
	{
		
	}
	
	

	public TestSuiteEntity(Integer suiteId, String suiteName, String suiteDescription, String createdBy,
			Date createdDate, String updatedBy, Date updatedDate)
	{
		super();
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.suiteDescription = suiteDescription;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}



	public long getSuiteId()
	{
		return suiteId;
	}

	public void setSuiteId(Integer suiteId)
	{
		this.suiteId = suiteId;
	}

	public String getSuiteName()
	{
		return suiteName;
	}

	public void setSuiteName(String suiteName)
	{
		this.suiteName = suiteName;
	}

	public String getSuiteDescription()
	{
		return suiteDescription;
	}

	public void setSuiteDescription(String suiteDescription)
	{
		this.suiteDescription = suiteDescription;
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

	@Override
	public String toString()
	{
		return "SuiteEntity [suiteId=" + suiteId + ", suiteName=" + suiteName + ", suiteDescription=" + suiteDescription
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

	
}
