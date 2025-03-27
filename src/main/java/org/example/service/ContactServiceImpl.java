package org.example.service;

import org.example.data.model.Contact;
import org.example.data.repository.ContactRepository;
import org.example.dto.request.AddContactRequest;
import org.example.dto.request.UpdateContactRequest;
import org.example.dto.response.GeneralResponse;
import org.example.utility.exception.ResourcesAlreadyExistException;
import org.example.utility.exception.ResourcesNotFoundException;
import org.example.utility.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public GeneralResponse addContact(AddContactRequest contactRequest) {
        if(contactRepository.existsByPhoneNumbersContains(contactRequest.getPhoneNumbers())){
            throw new ResourcesAlreadyExistException("Contact with this phone number already exists.");
        }
        Contact newContact = ContactMapper.mapRequestToContact(contactRequest);
        contactRepository.save(newContact);
        return ContactMapper.mapContactToResponse("Contact added", true);
    }

    @Override
    public GeneralResponse deleteContact(String contactId) {
        Optional<Contact> contactToBeDeleted = contactRepository.findContactsById(contactId);
        if (contactToBeDeleted.isPresent()){
            contactRepository.deleteById(contactId);
            return ContactMapper.mapContactToResponse("Contact Deleted",true);
        }
        else return ContactMapper.mapContactToResponse("Contact does not exist",false);

    }

    @Override
    public GeneralResponse updateContact(UpdateContactRequest request) {
      Optional<Contact> contactToBeUpdated = contactRepository.findContactsById(request.getId());
      if(contactToBeUpdated.isPresent()){
          Contact contact  = contactToBeUpdated.get();
          Contact updatedContact = ContactMapper.mapUpdateContactRequestToContact(contact,request);
          contactRepository.save(updatedContact);
          return ContactMapper.mapContactToResponse("Contact Updated", true);
      }
      else return ContactMapper.mapContactToResponse("Attempt to update Contact Failed", false);
    }

//    @Override
//    public List<Contact> findContactByName(String name) {
//       return contactRepository.findAllByName(name)
//               .orElseThrow(()-> new ResourcesNotFoundException(String.format("Contact with name %s does not exist", name)));
//    }

    @Override
    public Contact findContactById(String contactId){
        return contactRepository.findContactsById(contactId)
                .orElseThrow(()-> new ResourcesNotFoundException(String.format("Contact with Id %s does not exist", contactId)));

    }

    @Override
    public GeneralResponse blockContact(String contactId) {
        Contact contactToBeBlocked = findContactById(contactId);
        if(!contactToBeBlocked.isBlocked()) {
            contactToBeBlocked.setBlocked(true);
            contactRepository.save(contactToBeBlocked);
            return ContactMapper.mapContactToResponse("Contact blocked successfully", true);
        }
        else throw new IllegalArgumentException ("Contact Is already blocked");
    }

    @Override
    public GeneralResponse unBlockContact(String contactId) {
        Contact contactToBeUnBlocked = findContactById(contactId);
        if(contactToBeUnBlocked.isBlocked()) {
            contactToBeUnBlocked.setBlocked(false);
            contactRepository.save(contactToBeUnBlocked);
            return ContactMapper.mapContactToResponse("Contact unblocked successfully", true);
        }
        else throw new IllegalArgumentException ("Contact was never blocked");
    }

    @Override
    public List<Contact> getAllBlockedContacts() {
        return contactRepository.findAllByBlockedTrue()
                .orElseThrow(()-> new ResourcesNotFoundException("There is no blocked contact"));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    @Override
    public GeneralResponse deleteAllContact() {
        contactRepository.deleteAll();
        return ContactMapper.mapContactToResponse("All contact deleted", true);
    }

}
