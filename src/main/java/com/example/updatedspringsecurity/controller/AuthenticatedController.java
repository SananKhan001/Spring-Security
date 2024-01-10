package com.example.updatedspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController {
    @GetMapping("/home")
    public ResponseEntity home(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("You are authenticated user");
    }
}
