package com.example.updatedspringsecurity.service;

import com.example.updatedspringsecurity.model.Student;
import com.example.updatedspringsecurity.model.User;
import com.example.updatedspringsecurity.repository.StudentRepository;
import com.example.updatedspringsecurity.request.StudentRequest;
import com.example.updatedspringsecurity.request.UserRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class StudentService {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(StudentRequest studentRequest) {
        UserRequest userRequest = studentRequest.toUserRequest();
        User user =  userService.createUser(userRequest);
        Student student = studentRequest.to();
        student.setUser(user);
        studentRepository.save(student);
    }
}
