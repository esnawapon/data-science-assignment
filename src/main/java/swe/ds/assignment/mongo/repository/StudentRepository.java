package swe.ds.assignment.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swe.ds.assignment.mongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
