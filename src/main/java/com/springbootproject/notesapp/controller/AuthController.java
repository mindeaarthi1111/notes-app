package com.springbootproject.notesapp.controller;

import com.springbootproject.notesapp.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private  JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password)
    {
        if("admin".equals(username) && "admin123".equals(password))
            return jwtUtil.generateToken(username);

        throw new RuntimeException("Invalid credentials");

    }
}
