package com.example.Account.service;
import java.awt.List;

import com.example.Account.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
	
	public Flux<Account> findAll();
	public Mono<Account> createAccount(Account account);
	public Mono<Account> update(Account c, String id);
	public Mono<Void> delete(String id );
	public Mono<Account> findById(String id);
}
