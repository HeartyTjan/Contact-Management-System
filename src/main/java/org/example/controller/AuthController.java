package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.AuthenticationTokenRequest;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.service.UserService;
import org.example.utility.exception.ResourcesNotFoundException;
import org.example.utility.mapper.CreateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthController {


    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateNewUserResponse> registerNewUser(@Valid @RequestBody CreateNewUserRequest createNewUserRequest){
        CreateNewUserResponse response = userService.createUser(createNewUserRequest);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest){
            UserLoginResponse response = userService.loginUser(userLoginRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

}
