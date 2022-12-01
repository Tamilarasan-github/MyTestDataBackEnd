package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.Arrays;

public class TestSuiteExecutionRequestModel
{
	private TestSuiteExecutionHistoryEntity testSuiteExecutionInfo;
	private ExecutionInputValues executionInputValues[];
	private TestDataFilter testDataFilter;
	
	TestSuiteExecutionRequestModel()
	{}

	public TestSuiteExecutionRequestModel(TestSuiteExecutionHistoryEntity testSuiteExecutionInfo,
			ExecutionInputValues[] executionInputValues, TestDataFilter testDataFilter)
	{
		super();
		this.testSuiteExecutionInfo = testSuiteExecutionInfo;
		this.executionInputValues = executionInputValues;
		this.testDataFilter = testDataFilter;
	}

	public TestSuiteExecutionHistoryEntity getTestSuiteExecutionInfo()
	{
		return testSuiteExecutionInfo;
	}

	public void setTestSuiteExecutionInfo(TestSuiteExecutionHistoryEntity testSuiteExecutionInfo)
	{
		this.testSuiteExecutionInfo = testSuiteExecutionInfo;
	}

	public ExecutionInputValues[] getExecutionInputValues()
	{
		return executionInputValues;
	}

	public void setExecutionInputValues(ExecutionInputValues[] executionInputValues)
	{
		this.executionInputValues = executionInputValues;
	}

	public TestDataFilter getTestDataFilter()
	{
		return testDataFilter;
	}

	public void setTestDataFilter(TestDataFilter testDataFilter)
	{
		this.testDataFilter = testDataFilter;
	}

	@Override
	public String toString()
	{
		return "TestSuiteExecutionRequestModel [testSuiteExecutionInfo=" + testSuiteExecutionInfo
				+ ", executionInputValues=" + Arrays.toString(executionInputValues) + ", testDataFilter="
				+ testDataFilter + "]";
	}

	
	
}
