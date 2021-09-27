package com.Experiment3.Experiment3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Experiment4Controller {

    @PostMapping("/test")
    public ResponseEntity<String> testPost(@RequestBody String args) {
        if (args == null)
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("NULL");
        if (args.equals("gimmie an ok"))
            return ResponseEntity.status(HttpStatus.OK).body("Here you go: OK");
        else
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("WRONG");
    }
}
