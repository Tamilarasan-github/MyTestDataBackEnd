package backend.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/applications/1001/")
public class HomeController
{
	
	@Autowired
	HomeService homeService;
	
	@PostMapping("dashboardStats")
	public DashboardStats getDashboardStats(@RequestBody DashboardStatsRequest dashboardStatsRequest)
	{
		System.out.println("DashboardStatsRequest:"+dashboardStatsRequest.toString());
		return homeService.getDashboardStats(dashboardStatsRequest);
		
	}
}
