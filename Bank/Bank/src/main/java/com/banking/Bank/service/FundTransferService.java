package com.banking.Bank.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.banking.Bank.entity.FundTransfer;

public interface FundTransferService {
	
	@Autowired
	public FundTransfer transferFund(FundTransfer fundTransfer);

	public Long getAccountIdFromPhoneNumber(String phoneNumber);

}
