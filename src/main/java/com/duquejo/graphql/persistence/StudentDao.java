package com.duquejo.graphql.persistence;

import com.duquejo.graphql.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}
