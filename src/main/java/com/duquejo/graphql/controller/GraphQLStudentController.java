package com.duquejo.graphql.controller;

import com.duquejo.graphql.entities.Course;
import com.duquejo.graphql.entities.Student;
import com.duquejo.graphql.graphql.InputStudent;
import com.duquejo.graphql.service.CourseService;
import com.duquejo.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private CourseService courseService;

  @QueryMapping(name = "findStudentById")
  public Student findById(@Argument(name = "studentId") String id) {
    Long studentId = Long.parseLong(id);
    return studentService.findById(studentId);
  }

  @QueryMapping(name = "findAllStudents")
  public List<Student> findAll() {
    return studentService.findAll();
  }

  @MutationMapping(name = "createStudent")
  public Student create(@Argument(name = "inputStudent") InputStudent inputStudent) {

    Student student = new Student();
    student.setName(inputStudent.getName());
    student.setLastName(inputStudent.getLastName());
    student.setAge(inputStudent.getAge());

    Course studentCourse = courseService.findById(Long.parseLong(inputStudent.getCourseId()));
    student.setCourse(studentCourse);

    studentService.create(student);

    return student;
  }

  @MutationMapping(name = "deleteStudentById")
   public String deleteById(@Argument(name = "studentId") String id) {
    studentService.deleteById(Long.parseLong(id));
    return "The student " + id + " has been successfully deleted";
   }
}
