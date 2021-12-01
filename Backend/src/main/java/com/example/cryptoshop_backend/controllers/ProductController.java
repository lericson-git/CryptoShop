package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.Product;
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
        public @ResponseBody
        ResponseEntity<?> addNewProduct(Product product)
        {
            if (product.getName()==null ||product.getSellerId() == null || product.getPrice() == null
                || product.getCondition() == null)
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
                return null;
        }

    }
}
