package com.example.service;

import com.example.domain.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(Product product) throws Exception {
        productRepository.save(product);

        if (product.getProductId() == 4) {
            throw new Exception("Save Product Rollback");
        }
    }

    // Default rollback is throws runtime exception
    @Transactional
    public void deleteProduct(Integer productId) {
        productRepository.delete(productId);

        if (productId == 2) {
            throw new RuntimeException("Delete Product Roolback");
        }
    }
}
