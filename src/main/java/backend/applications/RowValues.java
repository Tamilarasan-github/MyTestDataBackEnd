package backend.applications;

import java.util.List;

public class RowValues
{
	private Integer id;
	
	private List<KeyAndValue> keyAndValue;
	
	RowValues()
	{}

	
	public RowValues(Integer id, List<KeyAndValue> keyAndValue)
	{
		super();
		this.id = id;
		this.keyAndValue = keyAndValue;
	}

	

	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public List<KeyAndValue> getKeyAndValue()
	{
		return keyAndValue;
	}


	public void setKeyAndValue(List<KeyAndValue> keyAndValue)
	{
		this.keyAndValue = keyAndValue;
	}


	@Override
	public String toString()
	{
		return "RowValues [id=" + id + ", keyAndValue=" + keyAndValue + "]";
	}


	
	
	

	

	
	
	
}
