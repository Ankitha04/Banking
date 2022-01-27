package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DepositRepository;

@Service
public class DepositService {
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public void addDeposit(Deposit deposit, Integer id) {
		Customer customer = customerRepository.findById(id).get();

		Double initial_amount = customer.getDeposit().getAmount();
		Double total_amount = initial_amount + deposit.getAmount();

		Deposit depositfinal = customer.getDeposit();
		depositfinal.setAmount(total_amount);


		depositRepository.save(depositfinal);
		customer.setDeposit(depositfinal);
		customerRepository.save(customer);
	}

}
