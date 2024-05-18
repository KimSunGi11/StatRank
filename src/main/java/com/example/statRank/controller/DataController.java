package com.example.statRank.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DataController {

    @GetMapping("/api/data")
    public String getData() {
        return "Hello from Spring Boot!";
    }
}