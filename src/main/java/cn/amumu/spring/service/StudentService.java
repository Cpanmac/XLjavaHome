package cn.amumu.spring.service;

import cn.amumu.spring.orm.Student;

import java.util.List;

public interface StudentService {
    public Student getStudent(long studentId);

    public void saveStudent(Student student);

    public List<Student> findAll();

    public void delete(long studentId);
}
