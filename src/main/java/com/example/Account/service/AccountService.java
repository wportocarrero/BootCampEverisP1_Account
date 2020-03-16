package com.example.Account.service;
import java.awt.List;

import com.example.Account.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
	
	Flux<Account> findAll();
	Mono<Account> createAccount(Account account);
	void deleteAccount(String id );
	Mono<Account> findById(String id);
}
