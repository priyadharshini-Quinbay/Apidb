package com.quinbay.march22.SpringApplication2.controller;


import com.quinbay.march22.SpringApplication2.dto.Student;
import com.quinbay.march22.SpringApplication2.service.StudentService;
import com.quinbay.march22.SpringApplication2.service.StudentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    StudentService st;

    @GetMapping("/studentlist")
    public List<Student> display()
    {

        return st.getAllStudents();
    }


  /*  @GetMapping(value = "/{id}", produces = "application/json")
    public Student getStudent(@PathVariable Integer id){
        return st.getStudent(id);
    }*/
//    @GetMapping(produces = "application/json")
//    public Student getStudent1(@RequestParam Long id,@RequestParam(required = false) String fname){
//
//            return st.getStudent(id,fname);
//
//    }
//
//
   @PostMapping
    public void addStudent(@RequestParam int test,@RequestBody  Student student)
    {
        st.addStudent(test,student);
    }
//
    @PutMapping("/update")
    public void updateStudent(@RequestParam int test,@RequestBody Student student)
    {
        st.updateStudent(test,student);
    }
//
    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam int test,@RequestParam Long id){
        st.deletestudent(test,id);
    }


}
