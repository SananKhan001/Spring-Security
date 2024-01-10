package com.example.updatedspringsecurity.repository;

import com.example.updatedspringsecurity.model.Teacher;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
