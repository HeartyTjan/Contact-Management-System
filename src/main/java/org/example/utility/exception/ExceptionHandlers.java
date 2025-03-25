package org.example.utility.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ResourcesAlreadyExistException.class)
    public String handleUserAlreadyExistException(ResourcesAlreadyExistException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserCreationException.class)
    public String handleUserCreationException(UserCreationException e){
        return e.getMessage();
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public String handleResourcesNotFoundException(ResourcesNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }
}
