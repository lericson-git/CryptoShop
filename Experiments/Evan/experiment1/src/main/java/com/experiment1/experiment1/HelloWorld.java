package com.experiment1.experiment1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String getHelloWorld() {
        return "HELLO WORLD";
    }
}
