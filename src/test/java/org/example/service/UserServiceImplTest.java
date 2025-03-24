package org.example.service;

import org.example.Main;
import org.example.dto.CreateNewUser;
import org.example.dto.CreateNewUserResponse;
import org.example.utility.exception.UserAlreadyExistException;
import org.example.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void userCanBeCreatedTest() {
        CreateNewUser newUser = new CreateNewUser();
        newUser.setUserName("John");
        newUser.setPassword("password");

        CreateNewUserResponse response = userService.createUser(newUser);
        assertEquals(response.getMessage(), "User created successfully");
    }

    @Test
    public void testThatUserCannotHaveSameUseName() {
        CreateNewUser newUser = new CreateNewUser();
        newUser.setUserName("John");
        newUser.setPassword("password");

        CreateNewUserResponse response = userService.createUser(newUser);
        assertThrows(UserAlreadyExistException.class, ()-> userService.createUser(newUser));

    }

}