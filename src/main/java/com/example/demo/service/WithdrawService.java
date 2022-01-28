package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Withdraw;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.WithdrawRepository;

public class WithdrawService {

	@Autowired
	private WithdrawRepository withdrawRepository;
	@Autowired
	
	private CustomerRepository customerRepository;

	public void makeWithdraw(Withdraw withdraw, Integer id) {
		Customer customer = customerRepository.findById(id).get();

		Double initial_amount = customer.getDeposit().getAmount();
		
	}

}