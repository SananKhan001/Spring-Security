package com.example.updatedspringsecurity.service;

import com.example.updatedspringsecurity.model.Student;
import com.example.updatedspringsecurity.model.Teacher;
import com.example.updatedspringsecurity.model.User;
import com.example.updatedspringsecurity.repository.TeacherRepository;
import com.example.updatedspringsecurity.request.TeacherRequest;
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
public class TeacherService {

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherRepository teacherRepository;

    public void createTeacher(TeacherRequest teacherRequest) {
        UserRequest userRequest = teacherRequest.toUserRequest();
        User user =  userService.createUser(userRequest);
        Teacher teacher = teacherRequest.to();
        teacher.setUser(user);
        teacherRepository.save(teacher);
    }
}
