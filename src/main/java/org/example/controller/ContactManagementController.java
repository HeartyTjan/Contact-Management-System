package org.example.controller;

import jakarta.validation.Valid;
import org.example.data.model.Contact;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;
import org.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactManagementController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    private ResponseEntity<GeneralResponse> addNewContact( @Valid @RequestBody AddContactRequest addContactRequest){
        GeneralResponse response = contactService.addContact(addContactRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<GeneralResponse> deleteContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.deleteContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/update")
    private ResponseEntity<GeneralResponse> updateContact(@Valid @RequestBody UpdateContactRequest updateContactRequest){
        GeneralResponse response = contactService.updateContact(updateContactRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//    @GetMapping("{name}")
//    private ResponseEntity<List<Contact>> searchContact(@PathVariable("name") String name){
//        List<Contact> response = contactService.findContactByName(name);
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

    @PostMapping("/block/{id}")
    private ResponseEntity<GeneralResponse> blockContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.blockContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PostMapping("/unBlock/{id}")
    private ResponseEntity<GeneralResponse> unBlockContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.unBlockContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/block/retrieveAll")
    private ResponseEntity<List<Contact>> retrieveAllBlockedContact(){
        List<Contact> response = contactService.getAllBlockedContacts();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @GetMapping("/retrieveALL")
    private ResponseEntity<List<Contact>> retrieveAllContact(){
        List<Contact> response = contactService.getAllContacts();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    @PreAuthorize("hasAnyAuthority('Admin')")
    private ResponseEntity<GeneralResponse> deleteAllContact(){
        GeneralResponse response = contactService.deleteAllContact();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
