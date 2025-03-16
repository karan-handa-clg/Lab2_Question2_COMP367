package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/")
    public String greet(@RequestParam(value = "name", defaultValue = "Karan") String name) {
        LocalTime currentTime = LocalTime.now();
        String greeting = (currentTime.getHour() < 12) ? "Good morning" : "Good afternoon";
        return greeting + ", " + name + "! Welcome to COMP367";
    }
}
