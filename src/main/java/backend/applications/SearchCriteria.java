package backend.applications;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SearchCriteria
{
	public enum SearchOperator
	{
		GREATER_THAN,
		LESSER_THAN,
		GREATER_THAN_EQUAL,
		LESSER_THAN_EQUAL,
		NOT_EQUAL,
		EQUALS_TO,
		CONTAINS,
		STARTS_WITH,
		ENDS_WITH,
		BETWEEN_DATES,
		IN,
		NOT_IN		
	}
	
	private String key;
	private SearchOperator operator;
	private String text;
	private long number;
	private String stringList[];
	private List<Integer> numberList;
	private long numberFrom;
	private long numberTo;
	private Date dateFrom;
	private Date dateTo;
	
	SearchCriteria()
	{
		
	}

	public SearchCriteria(String key, SearchOperator operator, String text)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.text = text;
	}

	public SearchCriteria(String key, SearchOperator operator, long number)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.number = number;
	}

	public SearchCriteria(String key, SearchOperator operator, String[] stringList)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.stringList = stringList;
	}

	public SearchCriteria(String key, SearchOperator operator, List<Integer> numberList)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.numberList = numberList;
	}

	public SearchCriteria(String key, SearchOperator operator, long numberFrom, long numberTo)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.numberFrom = numberFrom;
		this.numberTo = numberTo;
	}

	public SearchCriteria(String key, SearchOperator operator, Date dateFrom, Date dateTo)
	{
		super();
		this.key = key;
		this.operator = operator;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public SearchOperator getOperator()
	{
		return operator;
	}

	public void setOperator(SearchOperator operator)
	{
		this.operator = operator;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public long getNumber()
	{
		return number;
	}

	public void setNumber(long number)
	{
		this.number = number;
	}

	public String[] getStringList()
	{
		return stringList;
	}

	public void setStringList(String[] stringList)
	{
		this.stringList = stringList;
	}

	public List<Integer> getNumberList()
	{
		return numberList;
	}

	public void setNumberList(List<Integer> numberList)
	{
		this.numberList = numberList;
	}

	public long getNumberFrom()
	{
		return numberFrom;
	}

	public void setNumberFrom(long numberFrom)
	{
		this.numberFrom = numberFrom;
	}

	public long getNumberTo()
	{
		return numberTo;
	}

	public void setNumberTo(long numberTo)
	{
		this.numberTo = numberTo;
	}

	public Date getDateFrom()
	{
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom)
	{
		this.dateFrom = dateFrom;
	}

	public Date getDateTo()
	{
		return dateTo;
	}

	public void setDateTo(Date dateTo)
	{
		this.dateTo = dateTo;
	}

	@Override
	public String toString()
	{
		return "SearchCriteria [key=" + key + ", operator=" + operator + ", text=" + text + ", number=" + number
				+ ", stringList=" + Arrays.toString(stringList) + ", numberList=" + numberList + ", numberFrom="
				+ numberFrom + ", numberTo=" + numberTo + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}
	

	
}
