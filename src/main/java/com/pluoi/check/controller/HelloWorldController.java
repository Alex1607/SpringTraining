package com.pluoi.check.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final String helloWorld = "Hello World";

    @GetMapping("hello")
    public String getHelloWorld() {
        return helloWorld;
    }

}
