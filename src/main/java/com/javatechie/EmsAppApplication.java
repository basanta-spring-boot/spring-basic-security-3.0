package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@RestController
public class EmsAppApplication {

    @GetMapping("/greeting")
    public String greeting(Principal principal) {
        return "Welcome to Spring-Security Demo Session"+" : - "+principal.getName();
    }

    @GetMapping("/text/display")
    public String text() {
        return "secure";
    }

    @GetMapping("/text")
    public String hello() {
        return "non secure";
    }

    public static void main(String[] args) {
        SpringApplication.run(EmsAppApplication.class, args);
    }

}
