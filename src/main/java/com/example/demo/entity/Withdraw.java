package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transaction;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "withdrawal")

public class Withdraw {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "withdrawal_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Transaction transcation;

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	private Account account;

	// Withdraw Amount
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 10)
	@NotBlank
	@NotNull
	private String wAmt;

	public String getwAmt() {
		return wAmt;
	}

	public void setwAmt(String wAmt) {
		this.wAmt = wAmt;
	}

}