package org.example.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.data.model.Contact;

@Getter
@Setter
public class CreateNewUserRequest {
    @Valid

    @NotNull(message = "firstName is required")
    @NotBlank(message = "firstName Cannot be blank")
    private String firstName;

    @NotNull(message = "lastName is required")
    @NotBlank(message = "lastName Cannot be blank")
    private String lastName;

    @NotBlank(message = "Contact cannot be blank")
    @NotNull(message = "Contact is required")
    private Contact contact;

    @NotNull(message = "password is required")
    @NotBlank(message = "password Cannot be blank")
    @Size(min = 4, max = 15, message = "Password must not be below 5 and above 15")
    private String password;
}
