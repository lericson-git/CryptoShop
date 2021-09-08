package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class HelloWorldExperiment {
	
	@RequestMapping("/")
    public String getHelloWorld() {
        return "HELLO WORLD";


}
