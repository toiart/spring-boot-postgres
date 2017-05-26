package com.example;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootPostgresApplication implements CommandLineRunner {

    @Autowired
    private ProductService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        if (service != null)
            System.out.println("Good to Go " + service.toString());
    }

}
