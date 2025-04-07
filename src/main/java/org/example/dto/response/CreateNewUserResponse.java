package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewUserResponse {
    private String message;
    private String token;
    private boolean status;
}
