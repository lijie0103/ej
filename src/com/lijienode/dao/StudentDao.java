package com.lijienode.dao;

import com.lijienode.domain.Student;
import com.lijienode.vo.StudentAndClassroom;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student getById(String id);

    void save(Student student);

    List<Student> getAll();

    Student selectOne(String s);

    List<Student> selectAge(Integer age);

    List<Student> selectTwo(Student student);

    List<Student> selectThree(Map<String, Object> map);

    List<Student> selectFour(String z);

    List<Student> selectFive(String c);

    List<Student> selectSix(String s);

    String selectSeven(String a0006);

    List<String> selectEight();

    List<Map<String, Object>> selectNine();

    List<Student> selectTen(Student student);

    List<Student> selectEleven(String[] arr);

    Student selectA(String s);

    List<Map<String, Object>> select1();

    List<StudentAndClassroom> select2();

    List<StudentAndClassroom> select3(String name);
}
