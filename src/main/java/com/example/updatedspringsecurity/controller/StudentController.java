package com.example.updatedspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/student")
@RestController
public class StudentController {
    @GetMapping("/hello")
    public ResponseEntity hello(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello Student");
    }
}
