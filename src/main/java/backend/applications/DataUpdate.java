package backend.applications;

import java.util.List;

public class DataUpdate
{
	private Integer id;
	
	private List<UpdatedValues> values;
	
	DataUpdate()
	{}

	public DataUpdate(Integer id, List<UpdatedValues> values)
	{
		super();
		this.id = id;
		this.values = values;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public List<UpdatedValues> getValues()
	{
		return values;
	}

	public void setValues(List<UpdatedValues> values)
	{
		this.values = values;
	}

	@Override
	public String toString()
	{
		return "DataUpdate [id=" + id + ", values=" + values + "]";
	}

	

	
	
	
}
