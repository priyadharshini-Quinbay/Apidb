package com.quinbay.march22.SpringApplication2.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name="Student")
@javax.persistence.Table(name="Student")
public class StudentEntity {


    public StudentEntity() {
    }

    public StudentEntity(Long id) {

        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id",nullable = false)
    private Long id;

    //@NotBlank(message = "Student name cannot be empty")
    private String fname;
    private String lname;
    private String branch;

    public StudentEntity(String fname, String lname, String branch) {
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
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

    public StudentEntity(String name) {
        this.fname = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }
}
