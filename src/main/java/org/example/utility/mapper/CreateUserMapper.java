package org.example.utility.mapper;
import org.example.data.model.User;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.SecuredDetails;

public class CreateUserMapper{

    public static User mapToUser(CreateNewUserRequest createNewUserRequest) {
        User newUser = new User();
        newUser.setFirstName(createNewUserRequest.getFirstName());
        newUser.setLastName(createNewUserRequest.getLastName());
        newUser.setContact(createNewUserRequest.getContact());
        String hashedPassword =  SecuredDetails.hashPassword(createNewUserRequest.getPassword());
        newUser.setPassword(hashedPassword);

        return newUser;
    }

    public static CreateNewUserResponse mapToResponse(String message, boolean success) {
        CreateNewUserResponse response = new CreateNewUserResponse();
        response.setMessage(message);
        response.setStatus(success);
        return response;
    }
    public static UserLoginResponse mapToLoginResponse(String message, boolean success){
        UserLoginResponse loginResponse = new UserLoginResponse();
        loginResponse.setMessage(message);
        loginResponse.setSuccess(success);
        return loginResponse;
    }
}