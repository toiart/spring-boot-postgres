package com.example.service;

import com.example.domain.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProduct(Integer productId) {
        return productRepository.findOne(productId);
    }

    public Product getProductName(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }

    public List<Product> getProductList() {
        return (List<Product>) productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.delete(productId);
    }
}
