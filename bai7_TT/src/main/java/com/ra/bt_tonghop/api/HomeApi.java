package com.ra.bt_tonghop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeApi {
    @GetMapping
    public String get() {
        return "HOME API";
    }
}

