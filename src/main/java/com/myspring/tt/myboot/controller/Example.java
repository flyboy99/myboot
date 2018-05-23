package com.myspring.tt.myboot.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableAutoConfiguration
public class Example {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/getInfo")    
    String getInfo(){
    	return "my hub github test";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}