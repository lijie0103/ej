package com.lijienode.test;

import com.lijienode.domain.Student;
import com.lijienode.service.StudentService;
import com.lijienode.service.impl.StudentServiceImpl;
import com.lijienode.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        StudentService service = (StudentService)
                ServiceFactory.getService(new StudentServiceImpl());
        /*Student student = new Student();
        student.setId("A0008");
        student.setName("kd");
        student.setAge("25");

        service.save(student);*/

        /*
        Student student = service.getById("A0005");
        System.out.println(student);
        */

        List<Student> sList = service.getAll();
        for(Student student : sList){
            System.out.println(student);
        }
    }
}
