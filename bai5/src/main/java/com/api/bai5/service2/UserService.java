package com.api.bai5.service2;

import com.api.bai5.entity.UsersEntity;
import com.api.bai5.model2.TokenRequest;

public interface UserService {
    UsersEntity add(TokenRequest request);

}
