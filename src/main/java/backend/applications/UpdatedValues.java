package backend.applications;

public class UpdatedValues
{
	private String columnName;
	private String columnValue;
	
	UpdatedValues()
	{}
	
	public UpdatedValues(String columnName, String columnValue)
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
		return "UpdatedValues [columnName=" + columnName + ", columnValue=" + columnValue + "]";
	}
	
	
}
