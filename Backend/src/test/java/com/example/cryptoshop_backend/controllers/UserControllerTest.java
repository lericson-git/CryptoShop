package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenValidUser_return200OK() throws Exception {
        //GIVEN
        User validUser = new User();
        validUser.setName("ValidName");
        validUser.setEmail("Valid_email1@gmail.com");
        validUser.setHashed_pass("hashedpassword");

        //WHEN
        mvc.perform(post("/signUp")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validUser)))
                // THEN
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void givenInvalidUser_returnNull() throws Exception {
        //GIVEN
        User invalidUser = new User();
        //WHEN
        mvc.perform(post("/signUp")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidUser)))
                // THEN
                .andExpect(status().is(400))
                .andReturn();

    }
}
