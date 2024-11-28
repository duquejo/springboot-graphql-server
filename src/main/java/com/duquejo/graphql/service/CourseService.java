package com.duquejo.graphql.service;

import com.duquejo.graphql.entities.Course;

import java.util.List;

public interface CourseService {
  Course findById(Long id);

  List<Course> findAll();

  void create(Course student);

  void deleteById(Long id);
}
