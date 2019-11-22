package com.example.demo.configuration;

import com.example.demo.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return new UserDetailsServiceImpl(userRepository);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				//.anyRequest().hasAuthority(Authorities.LOGIN.getRoleName())
				.anyRequest().permitAll()
				.and().httpBasic();
//		http
//				.authorizeRequests()
//				.antMatchers("/", "/home").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//				.logout()
//				.permitAll();
	}
}
