package com.example.Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Account.service.AccountService;
import com.example.Account.model.Account;
import com.example.Account.repo.AccountRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService IaccountService;
	
	@Autowired
	private AccountRepo arep;
	
	@GetMapping("/findAll")
	public Flux<Account> findAll(){
		return IaccountService.findAll();
	}
	
	@GetMapping("/findby/{id}")
	public Mono<Account> findbyDni(@PathVariable String id) {
		System.out.println(IaccountService.findById(id));
		return IaccountService.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<Account> createAccount(@RequestBody Account account) {
		return IaccountService.createAccount(account);
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public String dlAccount(@PathVariable String id) {
		arep.deleteById(id);
		return "account erased : " + id;
	}
}
