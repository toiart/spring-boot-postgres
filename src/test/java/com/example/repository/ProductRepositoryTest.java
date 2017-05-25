package com.example.repository;

import com.example.SpringBootPostgresApplication;
import com.example.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootPostgresApplication.class)
@TestPropertySource(properties = {
        "jwt.secret=testValue",
        "jwt.expiration=60",
        "jwt.header=Authorization",
})
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        Product product = new Product();
        product.setProductName("iPhone 7");
        productRepository.save(product);

        Product productNew = new Product();
        productNew.setProductName("iPhone 8");
        productRepository.save(productNew);
    }

    @After
    public void teardown() {
        productRepository.deleteAll();
    }

    @Test
    public void findAllProducts() {
        List<Product> list = productRepository.findAll();
        assertEquals(2, list.size());
    }

    @Test
    public void updateProduct() {
        // Given
        Product product = productRepository.findByProductNameContainingIgnoreCase("iPhone 7");
        assertEquals("iPhone 7", product.getProductName());

        // When
        product.setProductName("iPhone 9");
        productRepository.save(product);

        // Then
        product = productRepository.findByProductNameContainingIgnoreCase("iPhone 9");
        assertEquals("iPhone 9", product.getProductName());
    }
}
