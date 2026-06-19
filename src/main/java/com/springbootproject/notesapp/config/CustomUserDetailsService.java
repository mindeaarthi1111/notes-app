package com.springbootproject.notesapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder)
    {

        UserDetails userDetails= User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}
