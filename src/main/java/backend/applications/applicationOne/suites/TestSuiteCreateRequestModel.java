package backend.applications.applicationOne.suites;

import java.util.Arrays;

import backend.applications.applicationOne.testScripts.TestScriptsEntity;

public class TestSuiteCreateRequestModel
{
	private TestSuiteEntity suiteInfo;
	private TestScriptsEntity testScripts[];
	
	public TestSuiteCreateRequestModel() {}
	
	

	public TestSuiteCreateRequestModel(TestSuiteEntity suiteInfo, TestScriptsEntity[] testScripts)
	{
		super();
		this.suiteInfo = suiteInfo;
		this.testScripts = testScripts;
	}



	public TestSuiteEntity getSuiteInfo()
	{
		return suiteInfo;
	}

	public void setSuiteInfo(TestSuiteEntity suiteInfo)
	{
		this.suiteInfo = suiteInfo;
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
		return "TestSuiteCreateRequestModel [suiteInfo=" + suiteInfo + ", testScripts=" + Arrays.toString(testScripts)
				+ "]";
	}

	
	
	
}
