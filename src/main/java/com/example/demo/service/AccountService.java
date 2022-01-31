package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;


	public void addAccount(@Valid Account account) {
		Integer customerId = Integer.parseInt(account.getCustId());
		Customer customer = customerRepository.findById(customerId).get();	
		customer.setAccount(account);
		accountRepository.save(account);
		customerRepository.save(customer);

	}
}
