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

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accid;

	//Customer ID
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 10)
	@NotBlank
	@NotNull
	private String custId;

	//Type of Account
	@Pattern(regexp ="^Saving?$|^Current?$")
	@NotBlank
	private String accType;

	//Initial Deposit
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?")
	@Range(min = 500)
	private Double initalDep;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Double getInitalDep() {
		return initalDep;
	}

	public void setInitalDep(Double initalDep) {
		this.initalDep = initalDep;
	}


}