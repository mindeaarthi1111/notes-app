package com.springbootproject.notesapp.config;

import com.springbootproject.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
import com.springbootproject.notesapp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;


@Configuration
public class CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder)
    {

/*      In memory User details
        UserDetails userDetails= User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
 */

        return username -> {
            User user = userRepository.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>()
            );
        };
    }

}
