package com.example.catalog.service;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    private final JwtService jwtService;

    public JwtTokenUtil(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public boolean validateToken(String token) {
        return jwtService.validateToken(token);
    }
}
