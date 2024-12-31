package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller_check {
    @GetMapping("/")
    public String hello(){
        return "How are you ?";
    }
}
