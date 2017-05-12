package com.example.controller;

import com.example.domain.Product;
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
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(product, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String productId) {

        try {
            if (productService.getProduct(new Integer(productId)) == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            productService.deleteProduct(new Integer(productId));
            return new ResponseEntity(HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
