package org.example.service;

import org.example.data.model.UserModel;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.SecuredDetails;
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
            logger.warn("UserModel with email{} already exist",newUser.getContact().getEmail());
            throw new ResourcesAlreadyExistException("UserModel already exist");
        }

        UserModel userModel = CreateUserMapper.mapToUser(newUser);

        UserModel savedUserModel = userRepository.save(userModel);

        return CreateUserMapper.mapToResponse("UserModel created successfully", true);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest loginRequest){
        UserModel foundUserModel = userRepository.findUserByContact_Email(loginRequest.getEmail())
                .orElseThrow(()-> new ResourcesNotFoundException("Invalid Email or Password"));

        boolean isLoginSuccessfully = SecuredDetails.matchPassword(loginRequest.getPassword(), foundUserModel.getPassword());
        if(isLoginSuccessfully){

            return CreateUserMapper.mapToLoginResponse("Login Successfully",true);
        }
        return CreateUserMapper.mapToLoginResponse("Login Failed",false);
    }




}
