package com.duquejo.graphql.service;

import com.duquejo.graphql.entities.Course;
import com.duquejo.graphql.persistence.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

  @Autowired
  private CourseDao courseDao;

  @Override
  @Transactional(readOnly = true)
  public Course findById(Long id) {
    return courseDao.findById(id).orElseThrow();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Course> findAll() {
    return (List<Course>) courseDao.findAll();
  }

  @Override
  @Transactional
  public void create(Course student) {
    courseDao.save(student);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    courseDao.deleteById(id);
  }
}
