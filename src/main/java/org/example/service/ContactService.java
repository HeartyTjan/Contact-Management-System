package org.example.service;

import org.example.data.model.Contact;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;

import java.util.List;

public interface ContactService {
    GeneralResponse addContact(AddContactRequest contactRequest);

    GeneralResponse deleteContact(String contactId);

    GeneralResponse updateContact(UpdateContactRequest request);

    List<Contact> findContactByName(String name);

    Contact findContactById(String contactId);

    GeneralResponse blockContact(String contactId);

    GeneralResponse unBlockContact(String contactId);

    List<Contact> getAllBlockedContacts();
    GeneralResponse deleteAllContact();
}
