package com.example.Account.service.impl;

import java.util.Date;

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
	public Mono<Void> delete(String id) {
		try {
            return dao.findById(id).flatMap(acc -> {
                return dao.delete(acc);
            });
        } catch (Exception e) {
            return Mono.error(e);
        }
	}

	@Override
	public Mono<Account> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Account> update(Account c, String id) {
	      return dao.findById(id).flatMap(acc -> {
	    	  acc.setAccountNumber(c.getAccountNumber());
	    	  acc.setAccountType(c.getAccountType());
	    	  acc.setAccountHolder(c.getAccountHolder());
	    	  acc.setModifyDate(new Date());
	          return dao.save(acc);
	        }).switchIfEmpty(Mono.empty());
	}

}
