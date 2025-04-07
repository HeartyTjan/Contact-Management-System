package org.example.utility.mapper;

import org.example.dto.response.BadRequestResponse;
import org.example.dto.response.GeneralResponse;

import java.util.Map;

public class ExceptionMapper {

    public static GeneralResponse mapExceptionToResponse(String message){
        GeneralResponse response = new GeneralResponse();
        response.setMessage(message);
        response.setSuccess(false);
        return response;
    }
    public static BadRequestResponse mapBadRequestToResponse(Map<String,String> message){
        BadRequestResponse response = new BadRequestResponse();
        response.setSuccess(false);
        response.setMessages(message);
        return response;
    }
}
