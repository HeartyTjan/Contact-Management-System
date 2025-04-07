package org.example.utility.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.response.BadRequestResponse;
import org.example.dto.response.GeneralResponse;
import org.example.utility.mapper.ExceptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ResourcesAlreadyExistException.class)
    public GeneralResponse handleUserAlreadyExistException(ResourcesAlreadyExistException e) {
        return ExceptionMapper.mapExceptionToResponse(e.getMessage());
    }

    @ExceptionHandler(UserCreationException.class)
    public GeneralResponse handleUserCreationException(UserCreationException e){
        return ExceptionMapper.mapExceptionToResponse(e.getMessage());
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public GeneralResponse handleResourcesNotFoundException(ResourcesNotFoundException e) {
        return ExceptionMapper.mapExceptionToResponse(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public GeneralResponse handleIllegalArgumentException(IllegalArgumentException e) {
        return ExceptionMapper.mapExceptionToResponse(e.getMessage());
    }

    @ExceptionHandler(MalformedInputException.class)
    public GeneralResponse handleMalformedInputException(MalformedInputException e) {
        return ExceptionMapper.mapExceptionToResponse(e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return e.getMessage();
    }
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public String handleHttpMessageNotWritableException(HttpMessageNotWritableException e) {
        return e.getMessage();
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public BadRequestResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//        return ExceptionMapper.mapBadRequestToResponse(errors);
//    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return e.getMessage();
    }
}
