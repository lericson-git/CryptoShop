package com.experiment1.experiment1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String getHelloWorld() {
        return "HELLO WORLD";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String read() {
        return "start";
    }

    @PostMapping("/start")
    public String create(){
        return "start post";
    }
}
