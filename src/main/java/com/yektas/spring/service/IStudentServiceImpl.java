package com.yektas.spring.service;


import com.yektas.spring.dao.IStudentDao;
import com.yektas.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class IStudentServiceImpl implements IStudentService{

    @Autowired
    IStudentDao studentDao;

    public IStudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void registerStudent(Student student) {
        getStudentDao().saveStudent(student);
    }

    public Student getStudent(int id) {
        return null;
    }

    public List<Student> listStudents() {
        return getStudentDao().getAllStudents();
    }
}
