package com.example.updatedspringsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Teacher teacher;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}
