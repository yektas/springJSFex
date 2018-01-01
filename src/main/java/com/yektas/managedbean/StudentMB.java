package com.yektas.managedbean;


import com.yektas.spring.model.Student;
import com.yektas.spring.service.IStudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "student")
@RequestScoped
public class StudentMB implements Serializable{

    @ManagedProperty(value = "#{studentService}")
    IStudentService studentService;

    List<Student> studentList = new ArrayList<Student>();
    Student st = new Student();

    @PostConstruct
    public void init(){
        setStudentList(getStudentService().listStudents());
    }
    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public IStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    public void registerStudent(){
        getStudentService().registerStudent(getSt());
    }

    /*public void getAllStudents(){
        setStudentList(getStudentService().listStudents());
        //FacesContext.getCurrentInstance().getExternalContext().redirect("listStudents.xhtml");
    }*/
}
