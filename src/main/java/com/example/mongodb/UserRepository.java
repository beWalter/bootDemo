package com.example.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.example.bean.User;


public interface UserRepository extends MongoRepository<User, Long> {

	User findByUserName(String userName);
}
