package com.yektas.spring.dao;

import com.yektas.spring.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDaoImpl implements IStudentDao{

    @Autowired
    SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveStudent(Student student) {
        getSessionFactory().getCurrentSession().save(student);
    }

    @Transactional
    public List<Student> getAllStudents(){
        return getSessionFactory().getCurrentSession().createQuery("from Student").list();
    }

    @Transactional
    public Student getStudent(int id) {
        return null;
    }
}
