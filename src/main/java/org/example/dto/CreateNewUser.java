package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
