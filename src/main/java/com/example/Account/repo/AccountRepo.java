package com.example.Account.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Account.model.Account;

@Repository
public interface AccountRepo extends ReactiveMongoRepository<Account, String>{

}
