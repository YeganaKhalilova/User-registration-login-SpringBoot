package com.example.userloginregistration.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {

    User findByEmail(String email);
}
