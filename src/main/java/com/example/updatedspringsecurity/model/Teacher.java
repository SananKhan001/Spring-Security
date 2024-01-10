package com.example.updatedspringsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Student> students;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}
