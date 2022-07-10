package backend.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import backend.applications.applicationOne.testScripts.TestScriptsEntity;

public class TestScriptsExecution
{
	private String suiteName;
	private String url;
	private String browser;
	private String userName;
	private String password;
	private TestScriptsEntity testScripts [];
	
	public TestScriptsExecution(){}

	public TestScriptsExecution(String suiteName, String url, String browser, String userName, String password,
			TestScriptsEntity[] testScripts)
	{
		super();
		this.suiteName = suiteName;
		this.url = url;
		this.browser = browser;
		this.userName = userName;
		this.password = password;
		this.testScripts = testScripts;
	}

	public String getSuiteName()
	{
		return suiteName;
	}

	public void setSuiteName(String suiteName)
	{
		this.suiteName = suiteName;
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

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public TestScriptsEntity[] getTestScripts()
	{
		return testScripts;
	}

	public void setTestScripts(TestScriptsEntity[] testScripts)
	{
		this.testScripts = testScripts;
	}

	@Override
	public String toString()
	{
		return "TestScriptsExecution [suiteName=" + suiteName + ", url=" + url + ", browser=" + browser + ", userName="
				+ userName + ", password=" + password + ", testScripts=" + Arrays.toString(testScripts) + "]";
	}
	
	
}
