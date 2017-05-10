package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Art on 11/24/16.
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(path = "/products")
    public List<Product> getProducts() {
        return productService.getProductList();
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        if (productService.getProductName(product.getProductName()) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        productService.saveProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productId) {

        try {
            Product product = productService.getProduct(new Integer(productId));
            if (product == null) {
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String productId) {

        try {
            if (productService.getProduct(new Integer(productId)) == null) {
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }
            productService.deleteProduct(new Integer(productId));
            return new ResponseEntity<Product>(HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
}
