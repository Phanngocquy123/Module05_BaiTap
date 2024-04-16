package com.ra.bt_tonghop.model;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String tokenType = "Bearer";
}
