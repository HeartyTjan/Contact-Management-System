package org.example.data.repository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.example.data.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    boolean existsByContact_Email(String email);
    void deleteAll();
    Optional<UserModel> findUserByContact_Email(@Valid @NotBlank(message = "email is required") String email);
}
