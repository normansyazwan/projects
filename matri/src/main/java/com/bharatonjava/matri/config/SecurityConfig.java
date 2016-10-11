package com.bharatonjava.matri.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin().loginPage("/login")
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.and()
		.authorizeRequests()
		// these resources don't need security
		.antMatchers("/resources/**", "/profile/new", "/aboutUs", "/contactUs").permitAll()
		.antMatchers("/profile").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/profile/new").hasRole("USER")
		.anyRequest().permitAll()
		.and()
		.requiresChannel()
		.antMatchers("/spitter/form").requiresSecure();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

}
