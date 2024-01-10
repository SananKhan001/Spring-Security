package com.example.updatedspringsecurity.request;

import com.example.updatedspringsecurity.model.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotNull(message = "Age should not be blank")
    private int age;

    @NotBlank(message = "username should not be blank")
    private String username;

    @NotBlank(message = "password should not be blank")
    private String password;

    public Student to(){
        return Student.builder()
                .age(this.age)
                .name(this.name)
                .build();
    }

    public UserRequest toUserRequest(){
        return UserRequest.builder()
                .username(this.username)
                .password(this.password)
                .student(to())
                .build();
    }

}
