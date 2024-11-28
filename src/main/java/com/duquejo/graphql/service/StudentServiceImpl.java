package com.duquejo.graphql.service;

import com.duquejo.graphql.entities.Student;
import com.duquejo.graphql.persistence.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  @Override
  @Transactional(readOnly = true)
  public Student findById(Long id) {
    return studentDao.findById(id).orElseThrow();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Student> findAll() {
    return (List<Student>) studentDao.findAll();
  }

  @Override
  @Transactional
  public void create(Student student) {
    studentDao.save(student);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    studentDao.deleteById(id);
  }
}
