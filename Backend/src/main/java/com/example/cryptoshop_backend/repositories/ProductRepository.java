package com.example.cryptoshop_backend.repositories;

import com.example.cryptoshop_backend.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
