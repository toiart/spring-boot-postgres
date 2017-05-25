package com.example.service;

import com.example.SpringBootPostgresApplication;
import com.example.domain.Product;
import com.example.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootPostgresApplication.class)
@TestPropertySource(properties = {
        "jwt.secret=testValue",
        "jwt.expiration=60",
        "jwt.header=Authorization",
})
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository productRepository;

    Product product;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        product = new Product();
        product.setProductId(1);
        product.setProductName("iPhone");

    }

    @After
    public void teardown() {
        reset(productRepository);
    }

    @Test
    public void findProduct() {
        // Given
        when(productRepository.findByProductNameContainingIgnoreCase("iPhone")).thenReturn(product);

        // When
        service.getProductName("iPhone");

        // Then
        verify(productRepository, times(1)).findByProductNameContainingIgnoreCase("iPhone");
    }

    @Test
    public void updateProduct() throws Exception {

        // Given
        when(productRepository.findByProductNameContainingIgnoreCase("iPhone")).thenReturn(product);

        // When
        product.setProductName("iPhone 8");
        service.saveProduct(product);

        // Then
        verify(productRepository, times(1)).save(product);

    }

}
