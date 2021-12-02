package com.example.cryptoshop_backend.repositories;

import com.example.cryptoshop_backend.models.Product;
import com.example.cryptoshop_backend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(int id);
}
