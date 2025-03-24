package org.example.data.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Document
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Contact> contacts = new ArrayList<>();
}

