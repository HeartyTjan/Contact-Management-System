package org.example.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class UpdateContactRequest {
    @Valid
    @NotNull(message = "Id is required")
    @NotBlank(message = "Id is required")
    private String id;

    private List<String> phoneNumbers;
    private String name;
    private String email;
    private String address;
}
