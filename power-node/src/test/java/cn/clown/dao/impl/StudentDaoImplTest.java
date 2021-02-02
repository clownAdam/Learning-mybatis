package cn.clown.dao.impl;

import cn.clown.domain.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    StudentDaoImpl studentDao = null;
    @Before
    public void before(){
        studentDao = new StudentDaoImpl();
    }

    @Test
    public void selectAllStudents() {
        List<Student> students = studentDao.selectAllStudents();
        students.forEach(System.out::println);
    }

    @Test
    public void insertStudent() {
        int flag = studentDao.insertStudent(new Student(5, "王五", "555@qq.com", 25));
        System.out.println(flag);
    }
}