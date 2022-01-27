package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DepositRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	public void addUser(Customer customer) {
		Account acc = customer.getAccount();
		Deposit dep = customer.getDeposit();
		depositRepository.save(dep);
		customerRepository.save(customer);
		accountRepository.save(acc);
	}

}
