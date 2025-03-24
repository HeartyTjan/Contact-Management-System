package org.example.data.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Contact {

    private String id;
    private String phone;
    private String name;
    private String email;
    private String address;
}
