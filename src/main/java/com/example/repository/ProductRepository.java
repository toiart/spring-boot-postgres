package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Art on 11/24/16.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductNameContainingIgnoreCase(String productName);

}
