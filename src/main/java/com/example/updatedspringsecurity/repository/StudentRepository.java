package com.example.updatedspringsecurity.repository;

import com.example.updatedspringsecurity.model.Student;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
