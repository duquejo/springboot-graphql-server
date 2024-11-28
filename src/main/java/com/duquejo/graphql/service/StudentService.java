package com.duquejo.graphql.service;

import com.duquejo.graphql.entities.Student;

import java.util.List;

public interface StudentService {
  Student findById(Long id);

  List<Student> findAll();

  void create(Student student);

  void deleteById(Long id);
}
