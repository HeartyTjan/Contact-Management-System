package org.example.data.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class UserModel {

    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private Contact contact;
    private String role;

}

