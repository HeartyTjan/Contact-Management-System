package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.data.model.Contact;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;
import org.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactManagementController {

    private final ContactService contactService;

    @Autowired
    public ContactManagementController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<GeneralResponse> addNewContact( @Valid @RequestBody AddContactRequest addContactRequest){
        System.out.println(addContactRequest);
        GeneralResponse response = contactService.addContact(addContactRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<GeneralResponse> deleteContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.deleteContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/update")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
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
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<GeneralResponse> blockContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.blockContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PostMapping("/unBlock/{id}")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<GeneralResponse> unBlockContact(@PathVariable("id") String contactId){
        GeneralResponse response = contactService.unBlockContact(contactId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/block/retrieveAll")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<List<Contact>> retrieveAllBlockedContact(){
        List<Contact> response = contactService.getAllBlockedContacts();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/retrieveALL")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    private ResponseEntity<List<Contact>> retrieveAllContact(){
        System.out.println("Inside the all contact " + contactService);
        List<Contact> response = contactService.getAllContacts();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    private ResponseEntity<GeneralResponse> deleteAllContact(){
        GeneralResponse response = contactService.deleteAllContact();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
//    @GetMapping("/test")
//    public String test() {
//        return "Service is " + (contactService != null ? "working" : "null");
//    }
}
