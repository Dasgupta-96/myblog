package com.myblog.myblog11.repository;

import com.myblog.myblog11.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
