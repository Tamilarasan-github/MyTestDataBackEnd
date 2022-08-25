package backend.applications.applicationOne.testExecutionResults.testSuite;

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
@Table(name="TEST_SUITE_EXECUTION_HISTORY")
public class TestSuiteExecutionHistoryEntity
{
	@Id
	@Column(name="SUITE_ID")
//	@SequenceGenerator(name = "SUITE_ID", sequenceName = "TEST_SUITE_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUITE_ID")
	private long suiteId;
	
	@Column(name="SUITE_NAME")
	private String suiteName;
	
	@Column(name="SUITE_DESCRIPTION")
	private String suiteDescription;
	
	@Column(name="SUITE_STATUS")
	private String suiteStatus;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="BROWSER")
	private String browser;
		
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	public TestSuiteExecutionHistoryEntity()
	{
		
	}

	public TestSuiteExecutionHistoryEntity(long suiteId, String suiteName, String suiteDescription, String suiteStatus,
			String url, String browser, String createdBy, Date createdDate, String updatedBy, Date updatedDate)
	{
		super();
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.suiteDescription = suiteDescription;
		this.suiteStatus = suiteStatus;
		this.url = url;
		this.browser = browser;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public long getSuiteId()
	{
		return suiteId;
	}

	public void setSuiteId(long suiteId)
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

	public String getSuiteStatus()
	{
		return suiteStatus;
	}

	public void setSuiteStatus(String suiteStatus)
	{
		this.suiteStatus = suiteStatus;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getBrowser()
	{
		return browser;
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
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
		return "TestSuiteExecutionHistoryEntity [suiteId=" + suiteId + ", suiteName=" + suiteName
				+ ", suiteDescription=" + suiteDescription + ", suiteStatus=" + suiteStatus + ", url=" + url
				+ ", browser=" + browser + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	
}
