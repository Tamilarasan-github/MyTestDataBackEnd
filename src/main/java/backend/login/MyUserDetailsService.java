package backend.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		System.out.println("Inside loadUserByUsername(String username) :" +username);
		MyUserDetails myUserDetails=new MyUserDetails();
		try
		{
		Optional<User> user=userRepository.findByUsername(username);
		System.out.println("User fetched:" +user.get().toString());
		myUserDetails = new MyUserDetails(user.get());
		
		System.out.println("My User Details: "+myUserDetails.toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//user.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
		
		
		return myUserDetails;
	}

}
