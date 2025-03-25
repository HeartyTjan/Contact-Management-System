package org.example.utility.mapper;

import org.example.data.model.Contact;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;

public class ContactMapper {
    public static Contact mapRequestToContact(AddContactRequest addContactRequest){
        Contact contact = new Contact();
        contact.setName(addContactRequest.getName());
        contact.setEmail(addContactRequest.getEmail());
        contact.setAddress(addContactRequest.getAddress());
        contact.setPhoneNumbers(addContactRequest.getPhoneNumbers());
        return contact;
    }

    public static GeneralResponse mapContactToResponse(String message, boolean success){
        GeneralResponse response = new GeneralResponse();
        response.setMessage(message);
        response.setSuccess(success);
        return response;
    }

    public static Contact mapUpdateContactRequestToContact(Contact contactToUpdated, UpdateContactRequest request){

        contactToUpdated.setName(request.getName());
        contactToUpdated.setEmail(request.getEmail());
        contactToUpdated.setAddress(request.getAddress());
        contactToUpdated.setPhoneNumbers(request.getPhoneNumbers());
        return contactToUpdated;
    }
}
