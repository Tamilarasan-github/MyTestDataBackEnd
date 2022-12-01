package backend.applications.applicationOne.testExecutionResults.testSuite;

public class ExecutionInputValues
{
	private String key;
	private String value;
	private String type;
	
	ExecutionInputValues()
	{}
	
	public ExecutionInputValues(String key, String value, String type)
	{
		super();
		this.key = key;
		this.value = value;
		this.type = type;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	@Override
	public String toString()
	{
		return "ExecutionInputValues [key=" + key + ", value=" + value + ", type=" + type + "]";
	}
	
	

}
