package com.duquejo.graphql.persistence;

import com.duquejo.graphql.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course, Long> {
}
