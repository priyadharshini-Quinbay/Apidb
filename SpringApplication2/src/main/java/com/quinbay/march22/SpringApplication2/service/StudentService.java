package com.quinbay.march22.SpringApplication2.service;

import com.quinbay.march22.SpringApplication2.dto.Student;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface StudentService
{
    List<Student> getAllStudents() ;

  void addStudent(int test,Student student);

 Student updateStudent (int n,Student student);
  void deletestudent(int n,Long id);



}
