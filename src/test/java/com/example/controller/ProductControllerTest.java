package com.example.controller;

import com.example.domain.Product;
import com.example.service.ErrorMessageService;
import com.example.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    ErrorMessageService errorMessageService;

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void testProductList() throws Exception {
        when(productService.getProductList()).thenReturn(buildProducts());

        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].productName", is("iPhone")))
                .andExpect(jsonPath("$[1].productName", is("iPad")));
    }

    private List<Product> buildProducts() {
        Product p1 = new Product("iPhone");
        Product p2 = new Product("iPad");
        List<Product> pList = Arrays.asList(p1, p2);
        return pList;
    }

}
