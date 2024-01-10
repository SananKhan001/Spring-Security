package com.example.updatedspringsecurity.request;

import com.example.updatedspringsecurity.model.Student;
import com.example.updatedspringsecurity.model.Teacher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String password;

    private Student student;
    private Teacher teacher;
}
