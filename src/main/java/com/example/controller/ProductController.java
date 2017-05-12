package com.example.controller;

import com.example.domain.Product;
import com.example.exception.EntityNotFoundException;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/products")
    public List<Product> getProducts() {
        return productService.getProductList();
    }

    @PostMapping(path = "/product")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) throws Exception {
        if (productService.getProductName(product.getProductName()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        productService.saveProduct(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productId) {

        try {
            Product product = productService.getProduct(new Integer(productId));
            if (product == null) {
                throw new EntityNotFoundException("100", "Entity Not Found");
            }
            return new ResponseEntity(product, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            throw new EntityNotFoundException("100", "Entity Not Found");
        }
    }

    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String productId) {

        try {
            if (productService.getProduct(new Integer(productId)) == null) {
                throw new EntityNotFoundException("100", "Entity Not Found");
            }
            productService.deleteProduct(new Integer(productId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            throw new EntityNotFoundException("100", "Entity Not Found");
        }
    }
}
