package org.example.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class BlockedContact {
    private String id;
    private List<Contact> contacts = new ArrayList<Contact>();

}
