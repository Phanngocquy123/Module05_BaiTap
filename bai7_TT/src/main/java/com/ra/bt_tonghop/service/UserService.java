package com.ra.bt_tonghop.service;

import com.ra.bt_tonghop.entity.UsersEntity;
import com.ra.bt_tonghop.model.TokenRequest;

public interface UserService {
    UsersEntity add(TokenRequest request);
}
