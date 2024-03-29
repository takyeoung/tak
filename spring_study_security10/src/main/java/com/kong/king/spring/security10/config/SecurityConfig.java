package com.kong.king.spring.security10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user1")
//		.password("$2a$10$YP/VtmSm0lQI1GSNQiLD3.vrklUprRs6mTkdSKljIyfGMZH2TMqDy")
//		.roles("USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/sample/all").permitAll()
			.antMatchers("/sample/member").hasRole("USER")
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/manager/**").hasRole("MANAGER")
			.antMatchers("/admin/**").hasRole("ADMIN");
//		http.formLogin().loginPage("/login").defaultSuccessUrl("/sample/all");
		http.formLogin().defaultSuccessUrl("/sample/all");
		
		 http.csrf().disable();
		
		// http.logout().logoutUrl("/logout").invalidateHttpSession(true);
	}
	
}
