package org.example.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
@Data
public class AddContactRequest {

    @Size(min = 1, message = "At least one phone number is required")
    private List<@Pattern(regexp = "^(\\+234|0)(70|80|81|90|91)\\d{8}$", message = "Invalid phone number format") String> phoneNumbers;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String address;

}
