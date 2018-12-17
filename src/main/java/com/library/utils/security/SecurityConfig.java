package com.library.utils.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		// bcrypt, domyslny algorytm hashujacy
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/","/register").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/loginform")
		.permitAll()
		.loginProcessingUrl("/loginform")
        .permitAll()
     .usernameParameter("username")
     .passwordParameter("password")
		.and()
        .logout()
          	.logoutUrl("/logout")
          	.logoutSuccessUrl("/")
          	.permitAll();
	}

}