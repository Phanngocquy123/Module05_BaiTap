package com.api.bai5.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/roles")
public class RoleApi {
    @GetMapping
    public String get() {
        return "ROLE API";
    }
}
