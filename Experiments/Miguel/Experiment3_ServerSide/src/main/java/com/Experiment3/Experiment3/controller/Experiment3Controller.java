package com.Experiment3.Experiment3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Experiment3Controller {
    @GetMapping("/test")
    public ResponseEntity<String> testGET () {
        return ResponseEntity.status(HttpStatus.OK).body("Everything good");
    }

}
