package com.lijienode.service.impl;

import com.lijienode.dao.StudentDao;
import com.lijienode.domain.Student;
import com.lijienode.service.StudentService;
import com.lijienode.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }
}
