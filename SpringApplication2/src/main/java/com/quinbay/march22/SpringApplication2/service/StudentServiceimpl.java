package com.quinbay.march22.SpringApplication2.service;

import com.quinbay.march22.SpringApplication2.dto.Student;
import com.quinbay.march22.SpringApplication2.entity.StudentEntity;
import com.quinbay.march22.SpringApplication2.repository.StudentDb;
import com.quinbay.march22.SpringApplication2.repository.StudentMongoRepository;
import com.quinbay.march22.SpringApplication2.repository.StudentRedisRepository;
import com.quinbay.march22.SpringApplication2.repository.StudentPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {


    @Autowired
    StudentDb studentDb;

    @Autowired
    StudentPostRepository strp;

    @Autowired
    StudentRedisRepository strep;

    @Autowired
    StudentMongoRepository str;




    @Override
    public List<Student> getAllStudents() {

        List<Student> newlist = new ArrayList<>();

        List<Student> mylist1 = new ArrayList<>();

        newlist.addAll(studentDb.getstudentlist());
        Iterable<StudentEntity> studententityList = strp.findAll();
        for (StudentEntity st : studententityList) {
           // Student student = new Student(st.getId(), st.getName());
            //student.setId(st.getId());
           // student.setFname(st.getName());
            mylist1.add(new Student(st.getId(), st.getName(),st.getLname(),st.getBranch()));
        }
        newlist.addAll(mylist1);


        newlist.addAll(strep.findAll());
        List<Student> list = new ArrayList<Student>();
        str.findAll().forEach(list::add);
        newlist.addAll(list);

        return newlist;


    }




    public void addStudent(int test, Student student)

    {
        if (test == 1) {

            studentDb.getstudentlist().add(new Student(student.getId(), student.getFname(), student.getLname(), student.getBranch()));

        } else if (test == 2) {
            //List<Student> mylist1 = new ArrayList<>();
            //Iterable<Student> studentList = Iterable<Student> student;
            strp.save(new StudentEntity(student.getFname(),student.getLname(),student.getBranch()));
            //mylist1.add(student);
        } else if (test == 3) {
            StudentRedisRepository.insert(student);

        } else if (test == 4) {

            System.out.println(str.save(new Student(student.getId(), student.getFname(),student.getLname(),student.getBranch())));
        }
    }





    public Student updateStudent(int n,Student student) {
        List<Student> mylist1 = new ArrayList<>();
        if (n == 1) {

            for (Student st : studentDb.getstudentlist()) {
                if (st.getId().equals(student.getId())) {
                    studentDb.getstudentlist().remove(st);
                    studentDb.getstudentlist().add(new Student(student.getId(), student.getFname(), student.getLname(), student.getBranch()));
                }
            }
            return student;
        } else if (n == 2) {
            //Student student1=new Student();
            for (StudentEntity studentEntity : strp.findAll()) {
                if (studentEntity.getId().equals(student.getId())) {
                    //student = new Student(studentEntity.getId(), studentEntity.getName());
                    studentEntity.setId(student.getId());
                    studentEntity.setName(student.getFname());

                    strp.save(studentEntity);
                    }

                }
                return student;



            } else if (n == 3) {
            return StudentRedisRepository.save(student);


        }
        else if (n==4) {
            for (Student stu : str.findAll()) {
                if (student.getId().equals(stu.getId()))
                    return str.save(new Student(student.getId(), student.getFname(), student.getLname(), student.getBranch()));


            }
            return null;

        }

        return null;
    }




   public void deletestudent(int n,Long id) {

       if (n == 1) {
           List<Student> st = studentDb.getstudentlist();
           for (Student student : studentDb.getstudentlist()) {
               if (student.getId().equals(id)) {
                   st.remove(student);
                   break;
               }
           }
       } else if (n == 2) {

           for (StudentEntity studentEntity : strp.findAll()) {

               if (studentEntity.getId().equals(id)) {
                   strp.delete(studentEntity);
               }
           }


       } else if (n == 3) {
           List<Student> mylist1 = strep.findAll();
           for (Student st : mylist1) {
               if (st.getId().equals(id)) {
                   strep.delete(st);
               }
           }


       } else if (n == 4) {
           for (Student stu : str.findAll()) {
               if (stu.getId().equals(id))

                   str.delete(stu);
           }

       }
   }


}