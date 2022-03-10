package com.quinbay.march22.SpringApplication2.repository;
import com.quinbay.march22.SpringApplication2.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDb {

    public  List<Student> mylist= new ArrayList<>();
    //public List<Dept> mydept= new ArrayList<>();


    public List<Student> getstudentlist()
    {

        return mylist;

    }





}
