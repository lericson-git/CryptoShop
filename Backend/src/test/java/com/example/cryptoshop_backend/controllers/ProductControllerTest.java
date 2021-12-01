package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void givenValidProduct_Return200ok() throws Exception {
        //GIVEN
        Product validProduct = new Product();
        validProduct.setSellerId(1);
        validProduct.setName("Boook");
        validProduct.setCondition("Used");
        validProduct.setPrice(9.99);
        //WHEN
        mvc.perform(post("/addProduct")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validProduct)))
                // THEN
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void givenInvalidProduct_returnNull() throws Exception {
        //GIVEN
        Product validProduct = new Product();
        //WHEN
        mvc.perform(post("/addProduct")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validProduct)))
                // THEN
                .andExpect(status().is(400))
                .andReturn();
    }

}
