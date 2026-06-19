package com.springbootproject.notesapp.controller;

import com.springbootproject.notesapp.dto.AuthRequest;
import com.springbootproject.notesapp.dto.AuthResponse;
import com.springbootproject.notesapp.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private  JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

//    public String login(@RequestParam String username,@RequestParam String password)
//    {
//        if("admin".equals(username) && "admin123".equals(password))
//            return jwtUtil.generateToken(username);
//
//        throw new RuntimeException("Invalid credentials");
//
//    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        String token = jwtUtil.generateToken(authRequest.getUsername());

        return new AuthResponse(token,"Login Successful");
    }
}
