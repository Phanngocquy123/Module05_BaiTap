package com.api.bai5.api;

import com.api.bai5.entity.UsersEntity;
import com.api.bai5.model2.TokenRequest;
import com.api.bai5.model2.TokenResponse;
import com.api.bai5.service2.impl.UserDetailServiceImpl;
import com.api.bai5.util2.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationApi {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody TokenRequest request) {
        UsersEntity entity = userDetailService.add(request);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/token")
    public ResponseEntity getToken(@RequestBody TokenRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return new ResponseEntity(tokenResponse, HttpStatus.OK);
    }
}

