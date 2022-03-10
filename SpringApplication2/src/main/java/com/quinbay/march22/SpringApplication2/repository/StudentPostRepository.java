package com.quinbay.march22.SpringApplication2.repository;

import com.quinbay.march22.SpringApplication2.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostRepository extends CrudRepository<StudentEntity,Long> {

}
