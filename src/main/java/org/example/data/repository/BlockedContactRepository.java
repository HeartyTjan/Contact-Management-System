package org.example.data.repository;

import org.example.data.model.BlockedContact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockedContactRepository extends MongoRepository<BlockedContact, String> {
}
