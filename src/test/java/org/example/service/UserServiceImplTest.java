package org.example.service;

import org.example.data.model.Contact;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.request.UserLoginRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.exception.ResourcesAlreadyExistException;
import org.example.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    CreateNewUserRequest newUser = new CreateNewUserRequest();

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();

        Contact contact = new Contact();
        contact.setEmail("john@doe.com");
        contact.setPhoneNumber("0987654321");

        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setContact(contact);
        newUser.setPassword("password");

    }

    @Test
    public void userCanBeCreated_countIsOneTest() {
        CreateNewUserResponse response = userService.createUser(newUser);
        assertEquals(response.getMessage(), "User created successfully");
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatUserCannotRegisterTwice_throwsException() {
        CreateNewUserResponse response = userService.createUser(newUser);
        assertEquals(response.getMessage(), "User created successfully");
        assertEquals(1, userRepository.count());
        assertThrows(ResourcesAlreadyExistException.class, ()-> userService.createUser(newUser));
    }

    @Test
    public void userCanLoginWithCorrectDetails_returnsTrue(){
        CreateNewUserResponse response = userService.createUser(newUser);
        assertEquals(response.getMessage(), "User created successfully");
        assertEquals(1, userRepository.count());

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setEmail("john@doe.com");
        loginRequest.setPassword("password");

        UserLoginResponse loginResponse = userService.login(loginRequest);
        assertTrue(loginResponse.isSuccess());
    }



}