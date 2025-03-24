package org.example.service;

import org.example.dto.CreateNewUser;
import org.example.dto.CreateNewUserResponse;

public interface UserService {
    CreateNewUserResponse createUser(CreateNewUser newUser);

}
