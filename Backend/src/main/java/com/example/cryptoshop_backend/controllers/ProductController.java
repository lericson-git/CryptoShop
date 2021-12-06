package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.Product;
import com.example.cryptoshop_backend.models.User;
import com.example.cryptoshop_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class ProductController {
    @Controller // This means that this class is a Controller
    public static class MainController {
        @Autowired
        private ProductRepository productRepository;

        @PostMapping(path="/addProduct")
        public @ResponseBody ResponseEntity<?> addNewProduct(@RequestBody Product product)
        {
            if (product.getName()==null ||product.getSeller_id() == null || product.getPrice() == null
                || product.getP_condition() == null)
                return ResponseEntity.status(400).build();
            productRepository.save(product);
            return ResponseEntity.status(200).build();
        }


        @GetMapping(path="allProducts")
        public @ResponseBody Iterable<Product> getAllProducts() {
            return productRepository.findAll();
        }

        @GetMapping(path="product/{id}")
        public @ResponseBody Product getProductById(@PathVariable int id) {
            if (productRepository.findById(id) != null)
                return productRepository.findById(id);
            else
                return new Product();
        }

        /*@GetMapping(path="buyProduct")
        public @ResponseBody ResponseEntity<?> buyProduct (/*@RequestBody String prodId, @RequestBody String buyerId,
                                                           @RequestBody Product product, @RequestBody User buyer*///)
        /*{
            Product validProduct = new Product();
            validProduct.setName("Mockito Test 3");
            validProduct.setDescription("Description");
            validProduct.setPrice(123.45);
            validProduct.setP_condition("Condition!");
            validProduct.setMain_tag("main tag");
            validProduct.setSub_tag("sub tag");
            validProduct.setWeight((double) 123);
            validProduct.setHeight((double)123);
            validProduct.setWidth((double) 123);
            validProduct.setLength((double) 123);
            validProduct.setSeller_id(123);
            validProduct.setBuyer_id(321);
            validProduct.setHas_been_bought(false);
            updateProduct("1", validProduct);
            return null;
        }*/

        /*public boolean updateProduct (String id, Product product) {
            productRepository.save(product);
            return false;
        }*/


    }
}
