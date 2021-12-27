package com.pia.piaworkshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pia.piaworkshop.model.User;

public interface UserRepository extends MongoRepository<User, UUID>{
	User findByUsername(String username);
	List<User> findByName(String name);
	
}
