//package org.example.service;
//
//import org.example.data.model.Contact;
//import org.example.data.repository.BlockedContactRepository;
//import org.example.dto.response.GeneralResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BlockContactServicesImpl implements BlockContactService {
//
//    @Autowired
//    private BlockedContactRepository blockedContactRepository;
//
//    @Autowired
//    private ContactService contactService;
//
//
//    @Override
//    public GeneralResponse blockContact(String contactId) {
//        Contact contactToBeBlocked = contactService.findContactById(contactId);
//
//
//    }
//}
