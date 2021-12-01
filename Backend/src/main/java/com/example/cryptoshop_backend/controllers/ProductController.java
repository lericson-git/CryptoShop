package com.example.cryptoshop_backend.controllers;

import com.example.cryptoshop_backend.models.Product;
import com.example.cryptoshop_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class ProductController {
    @Controller // This means that this class is a Controller
    public static class MainController {
        @Autowired
        private ProductRepository productRepository;

        @PostMapping(path="/addProduct")
        public @ResponseBody String addNewProduct(@RequestParam String name
                , @RequestParam (required = false) String description, @RequestParam Double price
                , @RequestParam String p_condition, @RequestParam String mainTag
                , @RequestParam String subTag, @RequestParam (required = false) Double weight
                , @RequestParam (required = false) Double height, @RequestParam (required = false) Double width
                , @RequestParam (required = false) Double length, @RequestParam Integer sellerId
                , @RequestParam (required = false) Integer buyerId, @RequestParam (required = false) boolean hasBeenBought)
        {
            Product p = new Product();
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            p.setCondition(p_condition);
            p.setMainTag(mainTag);
            p.setSubTag(subTag);
            p.setWeight(weight);
            p.setHeight(height);
            p.setWidth(width);
            p.setLength(length);
            p.setSellerId(sellerId);
            p.setBuyerId(buyerId);
            p.setHasBeenBought(hasBeenBought);
            productRepository.save(p);

            return "Saved";
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
