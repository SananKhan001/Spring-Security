package com.example.updatedspringsecurity.controller;

import com.example.updatedspringsecurity.JWT_config.Authenticator;
import com.example.updatedspringsecurity.JWT_config.JwtHelper;
import com.example.updatedspringsecurity.JWT_model.JwtRequest;
import com.example.updatedspringsecurity.JWT_model.JwtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticatedController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthenticatedController.class);

    // http://localhost:8080/login

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        authenticator.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity home(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("You are authenticated user");
    }


}
