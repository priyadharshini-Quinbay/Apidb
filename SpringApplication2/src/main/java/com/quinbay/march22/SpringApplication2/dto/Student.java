package com.quinbay.march22.SpringApplication2.dto;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

    public Long id;
//@NotBlank(message = "Student name cannot be empty")
    public String fname;
    public String lname;
    public String branch;
   // public int did;

    public Student() {

    }
    public Student( Long id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public Student( Long id, String fname, String lname, String branch) {

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
       // this.did=did;
    }

    public  Long getId() {

        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

//    public int getDid() {
//        return did;
//    }
//
//    public void setDid(int did) {
//        this.did = did;
//    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", Id=" + id +
                ", Branch=" + branch + "Department number= "+
                '}';
    }
}
