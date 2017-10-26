package cn.amumu.spring.dao;

import cn.amumu.spring.orm.Student;

import java.util.List;

public interface StudentDao {
    public Student findById(Long id);

    public void save(Student student);

    public List<Student> findAll();

    public void delete(long studentId);
}
