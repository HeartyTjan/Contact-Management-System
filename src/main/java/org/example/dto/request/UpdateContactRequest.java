package org.example.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
@Data
public class UpdateContactRequest {
    @Valid
    @NotNull(message = "Id is required")
    @NotBlank(message = "Id is required")
    private String id;

    @Size(min = 1, message = "Phone number is required")
    @Pattern(regexp = "^(234|0)(70|80|81|90|91)\\d{8}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;
    private String address;
}
