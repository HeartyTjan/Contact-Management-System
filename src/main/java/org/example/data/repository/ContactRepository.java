package org.example.data.repository;

import org.example.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<Contact> findContactsById(String contactId);

    Optional<List<Contact>> findAllByName(String name);

    Optional<List<Contact>> findAllByBlockedTrue();
}
