package com.quinbay.march22.SpringApplication2.repository;


import com.quinbay.march22.SpringApplication2.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository extends MongoRepository<Student, String> {

}