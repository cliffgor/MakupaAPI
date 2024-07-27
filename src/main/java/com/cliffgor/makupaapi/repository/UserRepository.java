package com.cliffgor.makupaapi.repository;

import com.cliffgor.makupaapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
