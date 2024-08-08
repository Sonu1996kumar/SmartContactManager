package com.scm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig {

    //InMemory Authentication
    

    @Bean
    public UserDetailsService userDetailsService(){
        
         UserDetails user1 = User.withDefaultPasswordEncoder().username("sonu").password("sonu123").build();
         UserDetails user2 = User.withUsername("Kaushal").password("ks123")
         .roles("ADMIN","USER")
         .build();
         var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
         
        return inMemoryUserDetailsManager;
    }
}
