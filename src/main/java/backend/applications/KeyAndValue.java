package backend.applications;

public class KeyAndValue
{
	private String columnName;
	private String columnValue;
	
	KeyAndValue()
	{}
	
	public KeyAndValue(String columnName, String columnValue)
	{
		super();
		this.columnName = columnName;
		this.columnValue = columnValue;
	}

	public String getColumnName()
	{
		return columnName;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	public String getColumnValue()
	{
		return columnValue;
	}

	public void setColumnValue(String columnValue)
	{
		this.columnValue = columnValue;
	}

	@Override
	public String toString()
	{
		return "KeyAndValue [columnName=" + columnName + ", columnValue=" + columnValue + "]";
	}

	
	
	
}
