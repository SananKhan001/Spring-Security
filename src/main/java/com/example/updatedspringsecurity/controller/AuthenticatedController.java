package com.example.updatedspringsecurity.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthenticatedController {

    private final String HOME_ACCESS_COUNT = "HOME_ACCESS_COUNT";

    @GetMapping("/home")
    public ResponseEntity home(Principal principal, HttpSession session){
        incrementCount(session, HOME_ACCESS_COUNT);
        return ResponseEntity.status(HttpStatus.OK)
                .body("You are authenticated user");
    }

    @GetMapping("/count")
    public ResponseEntity count(HttpSession session){
        return ResponseEntity.status(HttpStatus.OK)
                .body(session.getAttribute(HOME_ACCESS_COUNT));
    }

    private void incrementCount(HttpSession session, String attr) {
        var count = session.getAttribute(attr) == null ? 0 : (Integer) session.getAttribute(attr);
        session.setAttribute(attr, count+1);
    }

}
