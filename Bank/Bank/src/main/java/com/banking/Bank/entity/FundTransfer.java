package com.banking.Bank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FundTransfer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private Long fromAccountID;

	private Long toAccountID;

	private int amountToTransfer;

	private LocalDate transactionDate  = LocalDate.now();

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFromAccountID() {
		return fromAccountID;
	}

	public void setFromAccountID(Long fromAccountID) {
		this.fromAccountID = fromAccountID;
	}

	public Long getToAccountID() {
		return toAccountID;
	}

	public void setToAccountID(Long toAccountID) {
		this.toAccountID = toAccountID;
	}

	public int getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(int amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




}
