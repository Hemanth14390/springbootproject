package com.example.demo.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SchoolSecurityConfig {

	  @Bean
	    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("hema")
	                .password("hema123")
	                .roles("USER")
	                .build();
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                .username("hemanth")
	                .password("hema@123")
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((authorize) -> authorize
            		 .antMatchers("/api/school/school").permitAll() 
                .antMatchers("/api/school/fecth-all").hasRole("USER") 
                .antMatchers("/api/school/fetch/{id}").hasRole("ADMIN")
                .anyRequest().authenticated() 
            )
            .httpBasic(); 

        return http.build();
    }
}