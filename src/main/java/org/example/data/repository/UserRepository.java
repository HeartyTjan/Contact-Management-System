package org.example.data.repository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.example.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByContact_Email(String email);
    void deleteAll();
    Optional<User> findUserByContact_Email(@Valid @NotBlank(message = "email is required") String email);
}
