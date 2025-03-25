package org.example.data.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Contact {

    private String id;
    private List<String> phoneNumbers;
    private String name;
    private String email;
    private String address;
    private boolean blocked = false;
}
