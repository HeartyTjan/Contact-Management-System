package org.example.data.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Contact {

    private String id;
    @Valid

    @Size(min = 1, message = "Phone number is required")
    @Pattern(regexp = "^(234|0)(70|80|81|90|91)\\d{8}$", message = "Invalid phone number format")
    private String phoneNumber;


    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    private String email;

    private String address;
    private boolean blocked = false;
}
