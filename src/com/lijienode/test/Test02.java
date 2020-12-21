package com.lijienode.test;

import com.lijienode.dao.StudentDao;
import com.lijienode.domain.Student;
import com.lijienode.util.SqlSessionUtil;
import com.lijienode.vo.StudentAndClassroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test02 {
    public static void main(String[] args) {
        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

        /*Student student = studentDao.selectOne("A0006");
        System.out.println(student);*/

        /*List<Student> sList = studentDao.selectAge(23);
        for(Student student : sList){
            System.out.println(student);
        }*/

        //不可以为sql语句传递多个参数,需要封装
        //List<Student> sList = studentDao.selectTwo("cxk",23);
        /*Student student = new Student();
        student.setName("cxk");
        student.setAge("23");
        List<Student> sList = studentDao.selectTwo(student);
        for(Student s : sList){
            System.out.println(s);
        }*/

        /*Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","cxk");
        map.put("age",23);
        List<Student> sList = studentDao.selectThree(map);
        for(Student s : sList){
            System.out.println(s);
        }*/

        //like模糊查询 ${}
        /*List<Student> sList = studentDao.selectFour("c");
        for(Student s : sList){
            System.out.println(s);
        }*/
        //like模糊查询 #{}
        /*List<Student> sList = studentDao.selectFive("%c%");
        for(Student s : sList){
            System.out.println(s);
        }*/
        //like模糊查询 #{} 重点
        /*List<Student> sList = studentDao.selectSix("%c%");
        for(Student s : sList){
            System.out.println(s);
        }*/

        //resultType返回String
        /*String name = studentDao.selectSeven("A0006");
        System.out.println(name);*/

        //resultType返回List<String>
        /*List<String> nameList = studentDao.selectEight();
        for(String s : nameList){
            System.out.println(s);
        }*/

        //动态查询  where if
        /*Student student = new Student();
        student.setName("c");
        student.setAddress("西");
        List<Student> sList = studentDao.selectTen(student);
        for(Student s : sList){
            System.out.println(s);
        }*/

        //动态查询 foreach
        /*String[] arr = {"A0001","A0002","A0003"};
        List<Student> sList = studentDao.selectEleven(arr);
        for(Student s : sList){
            System.out.println(s);
        }*/

        //sql片段
        /*Student student = studentDao.selectA("A0007");
        System.out.println(student);*/

        //测试多表联查  查询学生姓名和班级名称
        /*List<Map<String,Object>> mapList = studentDao.select1();
        for(Map<String,Object> map : mapList){
            Set<String> keys = map.keySet();
            for(String key : keys){
                System.out.println("key:" + key);
                System.out.println("value:" + map.get(key));
            }
            System.out.println("========");
        }*/

        //测试多表联查 查询出学生和班级所有信息,加VO
        /*List<StudentAndClassroom> voList = studentDao.select2();
        for(StudentAndClassroom vo : voList){
            System.out.println(vo);
        }*/

        //测试多表联查 查询出学生和班级所有信息,加VO
        List<StudentAndClassroom> voList = studentDao.select3("k");
        for(StudentAndClassroom vo : voList){
            System.out.println(vo);
        }
    }
}
