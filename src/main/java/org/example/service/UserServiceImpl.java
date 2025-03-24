package org.example.service;

import org.example.data.model.User;
import org.example.dto.CreateNewUser;
import org.example.dto.CreateNewUserResponse;
import org.example.utility.exception.UserAlreadyExistException;
import org.example.utility.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public CreateNewUserResponse createUser(CreateNewUser newUser) {
        if(userRepository.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyExistException("UserName already exist");
        }

        User user = UserMapper.INSTANCE.mapDTOToUser(newUser);
        userRepository.save(user);

        return UserMapper.INSTANCE.mapUserToResponse("User created successfully", true);

    }
}
