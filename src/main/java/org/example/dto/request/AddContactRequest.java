package org.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class AddContactRequest {

    @NotBlank(message = "At least one phone number is required")
    @NotNull(message = "At least one phone number is required")
    private List<String> phoneNumbers;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String address;

}
