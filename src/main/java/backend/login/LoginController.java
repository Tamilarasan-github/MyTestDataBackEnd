package backend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController
{
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/auth")
	public User login()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		System.out.println("Principal:"+principal);
		String username="";
		
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		return new User(0, username, "", "");
	}
}
