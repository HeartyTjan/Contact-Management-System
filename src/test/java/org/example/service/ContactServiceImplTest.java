package org.example.service;

import org.example.data.model.Contact;
import org.example.data.repository.ContactRepository;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;
import org.example.utility.exception.ResourcesAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceImplTest {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    AddContactRequest contactRequest = new AddContactRequest();

    @BeforeEach
    public void setUp(){

        contactRepository.deleteAll();

        contactRequest.setName("Babatunde Fola");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("09088389329");
        phoneNumbers.add("07012838033");
        contactRequest.setPhoneNumbers(phoneNumbers);
        contactRequest.setEmail("babs@gmail.com");

    }

    @Test
    public void addNewContact_countIsOneTest(){
        contactService.addContact(contactRequest);
        assertEquals(1, contactRepository.count());

    }

    @Test
    public void test_ContactWith_samePhoneNumberCannotBeAddedTwice(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        assertThrows(ResourcesAlreadyExistException.class,()-> contactService.addContact(contactRequest), "Contact with this phone number already exists.");

    }

    @Test
    public void test_ContactCanBeDeletedById(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeDeletedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.deleteContact(contactToBeDeletedId);
        assertTrue((response.isSuccess()));
        assertEquals(0, contactRepository.count());

    }

    @Test
    public void updateContactRequest_ContactInfoIsUpdate_countIsOne(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeUpdatedId = contactRepository.findAll().getFirst().getId();
        UpdateContactRequest request = new UpdateContactRequest();
        request.setId(contactToBeUpdatedId);
        request.setName("Bolatito");
        request.setEmail("bola@gmail.com");

       GeneralResponse response =  contactService.updateContact(request);
       assertTrue(response.isSuccess());
       assertEquals(1,contactRepository.count());

    }

    @Test
    public void testThatContactCan_beBlocked_andBlockedStatusIsTrue(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeBlockedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.blockContact(contactToBeBlockedId);
        assertTrue(response.isSuccess());

        Contact blockedContact = contactService.findContactById(contactToBeBlockedId);
        assertTrue(blockedContact.isBlocked());

    }

    @Test
    public void testThatBlockingContactAlready_blockedThrowsAnException(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeBlockedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.blockContact(contactToBeBlockedId);
        assertTrue(response.isSuccess());

        Contact blockedContact = contactService.findContactById(contactToBeBlockedId);
        assertTrue(blockedContact.isBlocked());

        assertThrows(IllegalArgumentException.class,()-> contactService.blockContact(contactToBeBlockedId),"Contact Is already blocked");

    }

    @Test
    public void testThatContactCan_beUnBlocked_andBlockedStatusIsFalse(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeBlockedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.blockContact(contactToBeBlockedId);
        assertTrue(response.isSuccess());

        Contact blockedContact = contactService.findContactById(contactToBeBlockedId);
        assertTrue(blockedContact.isBlocked());

        contactService.unBlockContact(blockedContact.getId());
        Contact UnblockedContact = contactService.findContactById(blockedContact.getId());
        assertFalse(UnblockedContact.isBlocked());
    }

    @Test
    public void testThatContactNotBlockedThrowsAnException_whenUnBlocking(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeBlockedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.blockContact(contactToBeBlockedId);
        assertTrue(response.isSuccess());

        Contact blockedContact = contactService.findContactById(contactToBeBlockedId);
        assertTrue(blockedContact.isBlocked());

        GeneralResponse unBlockedContactResponse = contactService.unBlockContact(blockedContact.getId());
        assertFalse(unBlockedContactResponse.isSuccess());
        Contact unBlockedContact = contactService.findContactById(blockedContact.getId());
        assertFalse(unBlockedContact.isBlocked());

        assertThrows(IllegalArgumentException.class,()-> contactService.unBlockContact(unBlockedContact.getId()),"Contact was never blocked");

    }

    @Test
    public void testThatFindAllBlockedContactReturnListOfBlockedContacts(){
        contactService.addContact(contactRequest);
        assertEquals(1,contactRepository.count());

        String contactToBeBlockedId = contactRepository.findAll().getFirst().getId();
        GeneralResponse response = contactService.blockContact(contactToBeBlockedId);
        assertTrue(response.isSuccess());

        Contact blockedContact = contactService.findContactById(contactToBeBlockedId);
        assertTrue(blockedContact.isBlocked());

        List<Contact> blockedContacts = contactService.getAllBlockedContacts();
        assertEquals(1, blockedContacts.size());
    }

}