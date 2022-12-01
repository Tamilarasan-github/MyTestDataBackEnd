package backend.applications.applicationOne.testExecutionResults.testSuite;

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
@Table(name="TEST_SUITE_EXECUTION_HISTORY_APP_ONE")
public class TestSuiteExecutionHistoryEntity
{
	@Id
	@Column(name="EXECUTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "SUITE_ID", sequenceName = "TEST_SUITE_EXECUTION_ID_SEQ", schema="tamil", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUITE_ID")
	private Integer executionId;
	
	@Column(name="SUITE_ID")
	private Integer suiteId;
	
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
	private String executedBy;
	
	@Column(name="CREATED_DATE")
	private Date executedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	public TestSuiteExecutionHistoryEntity()
	{}

	public TestSuiteExecutionHistoryEntity(Integer executionId, Integer suiteId, String suiteName,
			String suiteDescription, String suiteStatus, String url, String browser, String executedBy,
			Date executedDate, String updatedBy, Date updatedDate)
	{
		super();
		this.executionId = executionId;
		this.suiteId = suiteId;
		this.suiteName = suiteName;
		this.suiteDescription = suiteDescription;
		this.suiteStatus = suiteStatus;
		this.url = url;
		this.browser = browser;
		this.executedBy = executedBy;
		this.executedDate = executedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Integer getExecutionId()
	{
		return executionId;
	}

	public void setExecutionId(Integer executionId)
	{
		this.executionId = executionId;
	}

	public Integer getSuiteId()
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
		return "TestSuiteExecutionHistoryEntity [executionId=" + executionId + ", suiteId=" + suiteId + ", suiteName="
				+ suiteName + ", suiteDescription=" + suiteDescription + ", suiteStatus=" + suiteStatus + ", url=" + url
				+ ", browser=" + browser + ", executedBy=" + executedBy + ", executedDate=" + executedDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
}
