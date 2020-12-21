package com.lijienode.service;

import com.lijienode.domain.Student;

import java.util.List;

public interface StudentService {
    Student getById(String id);

    void save(Student student);

    List<Student> getAll();
}
