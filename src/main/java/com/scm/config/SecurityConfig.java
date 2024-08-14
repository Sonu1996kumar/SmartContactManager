package com.scm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.impl.SecurityCustomUserDetailsService;


@Configuration
public class SecurityConfig {

    //InMemory Authentication
    

    // @Bean
    // public UserDetailsService userDetailsService(){
        
    //      UserDetails user1 = User.withDefaultPasswordEncoder().username("sonu").password("sonu123").build();
    //      UserDetails user2 = User.withUsername("Kaushal").password("ks123")
    //      .roles("ADMIN","USER")
    //      .build();
    //      var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
         
    //     return inMemoryUserDetailsManager;
    // }

    @Autowired
    private SecurityCustomUserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        //configuration of the authentication provider for spring security
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // user detail service ka object:
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        // password encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());


        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       //urls configure kiye hain kon public rahega aur kon private rahega
        http.authorizeHttpRequests(authorize->{
           //authorize.requestMatchers("/home","/register","/services").permitAll();
           authorize.requestMatchers("/user/**").authenticated();
           authorize.anyRequest().permitAll();
        });

        //form default login
        //form login related change ke liye yanha aayenge
        http.formLogin(Customizer.withDefaults());
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
