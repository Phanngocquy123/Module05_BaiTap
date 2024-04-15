package com.example.bai6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class Bai6Application {

    @GetMapping
    public String get(){
        return "xin chào oauth2";
    }

    @GetMapping("/user")
    public Principal getPrincipal(Principal principal){
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(Bai6Application.class, args);
    }

}
