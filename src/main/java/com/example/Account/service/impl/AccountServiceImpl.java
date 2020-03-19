package com.example.Account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Account.model.Account;
import com.example.Account.repo.AccountRepo;
import com.example.Account.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo dao;

	@Override
	public Flux<Account> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Account> createAccount(Account account) {
		return dao.save(account);
	}

	@Override
	public void deleteAccount(String id) {
		dao.deleteById(id);
	}

	@Override
	public Mono<Account> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Account> update(Account c, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
