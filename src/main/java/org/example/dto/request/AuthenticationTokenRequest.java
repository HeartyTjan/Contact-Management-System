package org.example.dto.request;

import lombok.Data;

@Data
public class AuthenticationTokenRequest {
    private String email;
    private String password;
}
