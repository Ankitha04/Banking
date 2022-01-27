package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "desposit")
public class Deposit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer depoid;

	//Account Number
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 10)
	@NotBlank
	@NotNull
	private String accountnum;

	//Amount
	@NotBlank 
	@Pattern(regexp = "^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$")
	private Double amount;

	public Deposit(Integer depoId, String accountnum) {
		super();
	}
	
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
