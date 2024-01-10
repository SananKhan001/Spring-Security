package com.example.updatedspringsecurity.controller;

import com.example.updatedspringsecurity.request.StudentRequest;
import com.example.updatedspringsecurity.request.TeacherRequest;
import com.example.updatedspringsecurity.service.StudentService;
import com.example.updatedspringsecurity.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/signup")
@RestController
public class Signup {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity createTeacher(@RequestBody @Valid TeacherRequest teacherRequest){
        teacherService.createTeacher(teacherRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/student")
    public ResponseEntity createStudent(@RequestBody @Valid StudentRequest studentRequest){
        studentService.createStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
