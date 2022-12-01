package backend.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	 @Autowired
	 private UserDetailsService userDetailsService;
	 
	 @Bean
	   public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Inside configure(AuthenticationManagerBuilder auth)");
		System.out.println("UserDetailsService:"+userDetailsService.toString());
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Inside configure(HttpSecurity http)");
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/**")
        .permitAll() //we are asking to disable csrf requests which matches method type OPTIONS
        .anyRequest() //rest all other requests are validated/authenticated
        .authenticated()
        .and()
        .httpBasic(); //also we are saying, it is basic authentication, not form authentication
        
    }
	
}
