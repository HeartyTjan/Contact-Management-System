package org.example.utility.mapper;
import org.example.data.model.UserModel;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.SecuredDetails;

public class CreateUserMapper{

    public static UserModel mapToUser(CreateNewUserRequest createNewUserRequest) {
        UserModel newUserModel = new UserModel();
        newUserModel.setFirstName(createNewUserRequest.getFirstName());
        newUserModel.setLastName(createNewUserRequest.getLastName());
        newUserModel.setContact(createNewUserRequest.getContact());
        String hashedPassword =  SecuredDetails.hashPassword(createNewUserRequest.getPassword());
        newUserModel.setPassword(hashedPassword);
        newUserModel.setRole(createNewUserRequest.getRole());

        return newUserModel;
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