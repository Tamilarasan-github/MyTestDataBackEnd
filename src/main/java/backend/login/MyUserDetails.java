package backend.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetails implements UserDetails
{
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	
	public MyUserDetails()
	{}
	
	public MyUserDetails(User user)
	{
		System.out.println("Inside MyUserDetails(User user) constructor");
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.authorities= new ArrayList<>();
		this.accountNonLocked=true;
		this.accountNonExpired=true;
		this.credentialsNonExpired=true;
		this.enabled=true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	@Override
	public String getPassword()
	{
		
		return password;
	}

	@Override
	public String getUsername()
	{
		return username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	@Override
	public String toString()
	{
		return "MyUserDetails [username=" + username + ", password=" + password + ", authorities=" + authorities
				+ ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
				+ ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + "]";
	}

	
}
