package com.cg.demo;

import java.util.ArrayList;
import java.util.List;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Spring_Security extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("mounika")
		.password("1234")
		.roles("USER")
		.and()
		.withUser("mounika patel")
		.password("12345")
		.roles("ADMIN");

	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests()
			.antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/user").hasRole("USER")
            .antMatchers("/").permitAll()
			.and().formLogin();
		}
	}
	//@Bean
	//@Override
	//	protected UserDetailsService userDetailsService() {
	//
	//
	//		List<UserDetails> users = new ArrayList<>();
	//		users.add(User.withDefaultPasswordEncoder().username("Ranjith").password("hello").roles("USER").build());
	//		users.add(User.withDefaultPasswordEncoder().username("Malikarjun").password("1234").roles("ADMIN").build());
	//		return new InMemoryUserDetailsManager(users);
	//
	//
	//	}

