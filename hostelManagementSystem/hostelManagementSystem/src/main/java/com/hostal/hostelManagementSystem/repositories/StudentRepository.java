package com.hostal.hostelManagementSystem.repositories;

import com.hostal.hostelManagementSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(Long studentId);
}
