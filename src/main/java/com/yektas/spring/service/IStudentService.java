package com.yektas.spring.service;


import com.yektas.spring.model.Student;

import java.util.List;

public interface IStudentService {

    public void registerStudent(Student student);
    public Student getStudent(int id);
    public List<Student> listStudents();
}
