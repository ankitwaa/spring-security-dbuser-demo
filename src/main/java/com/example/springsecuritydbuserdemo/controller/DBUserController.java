package com.example.springsecuritydbuserdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBUserController {

    @GetMapping("/secure/hello")
    public String hello(){
        return "Secure Hello";
    }

    @GetMapping("/public/hello")
    public String publicHello(){
        return "Public Hello";
    }

}
