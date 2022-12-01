package backend.applications.applicationOne.suites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TEST_SUITE_TEST_SCRIPTS_CONNECTOR")
public class TestSuiteTestScriptsMapperEntity
{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="SUITE_ID")
	private Integer suiteId;
	
	@Column(name="TEST_SCRIPT_ID")
	private Integer testScriptId;
	
	public TestSuiteTestScriptsMapperEntity()
	{}
	
	public TestSuiteTestScriptsMapperEntity(Integer id, Integer suiteId, Integer testScriptId)
	{
		super();
		this.id = id;
		this.suiteId = suiteId;
		this.testScriptId = testScriptId;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getSuiteId()
	{
		return suiteId;
	}
	public void setSuiteId(Integer suiteId)
	{
		this.suiteId = suiteId;
	}
	public Integer getTestScriptId()
	{
		return testScriptId;
	}
	public void setTestScriptId(Integer testScriptId)
	{
		this.testScriptId = testScriptId;
	}
	
	@Override
	public String toString()
	{
		return "SuiteTestScriptsMapperEntity [id=" + id + ", suiteId=" + suiteId + ", testScriptId=" + testScriptId
				+ "]";
	}
	
	
	
}
