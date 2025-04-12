package org.example.utility.mapper;
import org.example.data.model.UserModel;
import org.example.dto.request.CreateNewUserRequest;
import org.example.dto.response.CreateNewUserResponse;
import org.example.dto.response.UserLoginResponse;
import org.example.utility.SecuredDetails;
import org.springframework.beans.BeanUtils;

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

    public static CreateNewUserResponse mapToResponse(String message, boolean success, String jwtToken) {
        CreateNewUserResponse response = new CreateNewUserResponse();
        response.setMessage(message);
        response.setStatus(success);
        response.setToken(jwtToken);
        return response;
    }
    public static UserLoginResponse mapToLoginResponse(String message,boolean success, String token){
        UserLoginResponse loginResponse = new UserLoginResponse();
        loginResponse.setMessage(message);
        loginResponse.setToken(token);
        loginResponse.setSuccess(success);
        return loginResponse;
    }

}