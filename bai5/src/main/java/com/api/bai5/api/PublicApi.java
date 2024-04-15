package com.api.bai5.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicApi {
    @GetMapping
    public String get() {
        return "PUBLIC API";
    }
}
