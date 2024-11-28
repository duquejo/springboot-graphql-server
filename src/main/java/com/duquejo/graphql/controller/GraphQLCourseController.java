package com.duquejo.graphql.controller;

import com.duquejo.graphql.entities.Course;
import com.duquejo.graphql.graphql.InputCourse;
import com.duquejo.graphql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

  @Autowired
  private CourseService courseService;

  @QueryMapping(name = "findCourseById")
  public Course findById(@Argument(name = "courseId") String courseId) {
    return courseService.findById(Long.parseLong(courseId));
  }

  @QueryMapping(name = "findAllCourses")
  public List<Course> findAll() {
    return courseService.findAll();
  }

  @MutationMapping(name = "createCourse")
  public Course create(@Argument(name = "inputCourse") InputCourse inputCourse) {
    Course course = new Course();
    course.setName(inputCourse.getName());
    course.setCategory(inputCourse.getCategory());
    course.setTeacher(inputCourse.getTeacher());

    courseService.create(course);

    return course;
  }

  @MutationMapping(name = "deleteCourseById")
  public String deleteById(@Argument(name = "courseId") String courseId) {
    courseService.deleteById(Long.parseLong(courseId));

    return "The course " + courseId + " has been successfully deleted";
  }
}
