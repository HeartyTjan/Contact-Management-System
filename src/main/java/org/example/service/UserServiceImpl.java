package org.example.service;

import org.example.data.model.User;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.SecurePassword;
import org.example.utility.exception.ResourcesNotFoundException;
import org.example.utility.exception.ResourcesAlreadyExistException;
import org.example.utility.mapper.CreateUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.data.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public CreateNewUserResponse createUser(CreateNewUserRequest newUser) {

        if(userRepository.existsByContact_Email(newUser.getContact().getEmail())) {
            logger.warn("User with email{} already exist",newUser.getContact().getEmail());
            throw new ResourcesAlreadyExistException("User already exist");
        }

        User user = CreateUserMapper.mapToUser(newUser);

        User savedUser = userRepository.save(user);

        return CreateUserMapper.mapToResponse("User created successfully", true);
    }

    public UserLoginResponse login(UserLoginRequest loginRequest){
        User foundUser = userRepository.findUserByContact_Email(loginRequest.getEmail())
                .orElseThrow(()-> new ResourcesNotFoundException("Invalid Email or Password"));

        boolean isLoginSuccessfully = SecurePassword.matchPassword(loginRequest.getPassword(),foundUser.getPassword());
        if(isLoginSuccessfully){

            return CreateUserMapper.mapToLoginResponse("Login Successfully",true);
        }
        return CreateUserMapper.mapToLoginResponse("Login Failed",false);
    }

}
