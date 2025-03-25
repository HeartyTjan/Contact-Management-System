package org.example.service;

import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;

public interface UserService {
    CreateNewUserResponse createUser(CreateNewUserRequest newUser);
    UserLoginResponse login(UserLoginRequest loginRequest);

}
