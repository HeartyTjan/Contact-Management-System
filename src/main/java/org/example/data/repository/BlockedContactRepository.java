package org.example.data.repository;

import org.example.data.model.BlockedContact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedContactRepository extends MongoRepository<BlockedContact, String> {
}
