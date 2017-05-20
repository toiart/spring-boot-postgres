package com.example.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class VersionController {

    @GetMapping(path = "/version")
    public ResponseEntity<InputStreamResource> getProducts() throws IOException {
        ClassPathResource json = new ClassPathResource("version.json");
        return ResponseEntity.ok()
                .contentLength(json.contentLength())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(new InputStreamResource(json.getInputStream()));
    }
}
