package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateNewUserResponse> registerNewUser(@RequestBody @Valid CreateNewUserRequest createNewUserRequest){
        CreateNewUserResponse response = userService.createUser(createNewUserRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> userLogin(@RequestBody @Valid UserLoginRequest userLoginRequest){
        UserLoginResponse response = userService.login(userLoginRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
