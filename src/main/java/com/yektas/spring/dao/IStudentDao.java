package com.yektas.spring.dao;


import com.yektas.spring.model.Student;

import java.util.List;

public interface IStudentDao {

    public void saveStudent(Student student);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
