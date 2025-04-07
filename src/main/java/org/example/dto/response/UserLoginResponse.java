package org.example.dto.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String message;
//    private String token;
    private boolean success;
}
