package com.quinbay.march22.SpringApplication2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class Hello {
    @GetMapping("/greet")
    public  String greet(){
        return "HELLO EVERYONE";
    }
}
