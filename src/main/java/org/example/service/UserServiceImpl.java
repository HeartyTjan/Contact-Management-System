package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.UserModel;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.exception.ResourcesAlreadyExistException;
import org.example.utility.exception.ResourcesNotFoundException;
import org.example.utility.mapper.CreateUserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.data.repository.UserRepository;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public CreateNewUserResponse createUser(CreateNewUserRequest newUser) {

        if(userRepository.existsByContact_Email(newUser.getContact().getEmail())) {
            throw new ResourcesAlreadyExistException("User already exist");
        }
        UserModel userModel = CreateUserMapper.mapToUser(newUser);
         userRepository.save(userModel);
         var jwtToken = jwtService.generateToken(userModel);
        return CreateUserMapper.mapToResponse("User created successfully",true,jwtToken);
    }

//    @Override
//    public UserLoginResponse login(UserLoginRequest loginRequest){
//        UserModel foundUserModel = userRepository.findUserByContact_Email(loginRequest.getEmail())
//                .orElseThrow(()-> new ResourcesNotFoundException("Invalid Email or Password"));
//
//        boolean isLoginSuccessfully = SecuredDetails.matchPassword(loginRequest.getPassword(), foundUserModel.getPassword());
//        if(isLoginSuccessfully){
//
//            return CreateUserMapper.mapToLoginResponse("Login Successfully",true);
//        }
//        return CreateUserMapper.mapToLoginResponse("Login Failed",false);
//    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userRepository.findUserByContact_Email(loginRequest.getEmail())
                .orElseThrow(()-> new ResourcesNotFoundException("User not found"));
        String token = jwtService.generateToken(user);
        return CreateUserMapper.mapToLoginResponse("Login Successfully", true,token);
    }




}
