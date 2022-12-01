package backend.home;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DashboardStatsRequest
{
	private Date dateFrom;
	private Date dateTo;
	
	DashboardStatsRequest()
	{}

//	public DashboardStatsRequest(String dateFrom, String dateTo)
//	{
//		this.dateFrom = dateFrom;
//		this.dateTo = dateTo;
//	}
//
//	public String getDateFrom()
//	{
//		return dateFrom;
//	}
//
//	public void setDateFrom(String dateFrom)
//	{
//		this.dateFrom = dateFrom;
//	}
//
//	public String getDateTo()
//	{
//		return dateTo;
//	}
//
//	public void setDateTo(String dateTo)
//	{
//		this.dateTo = dateTo;
//	}
//
//	@Override
//	public String toString()
//	{
//		return "DashboardStatsRequest [dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
//	}
	
	
	
	
	public DashboardStatsRequest(Date dateFrom, Date dateTo)
	{
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
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
		return "DashboardStatsRequest [dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}
	
	
}
