package com.example.Account.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Mono<ResponseEntity<Account>> createAccount(@Valid @RequestBody Account account) {
		return IaccountService.createAccount(account)
				.map(item-> ResponseEntity
						.created(URI.create("/account".concat(item.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(item));
	}
	
    //ACTUALIZAR UN CLIENTE
    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Account>> update(@PathVariable("id") String id, @RequestBody Account account) {
        return IaccountService.update(account, id)
                .map(c -> ResponseEntity
                        .created(URI.create("/account".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping("/delete/{id}")
	public Mono<ResponseEntity<Void>> dlAccount(@PathVariable String id) {
		return IaccountService.delete(id)
				.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
}
