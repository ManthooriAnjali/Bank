package com.banking.Bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.Bank.entity.FundTransfer;


public interface AccountStatementService {
	@Autowired
	public List<FundTransfer> getAccountStatementFromID(Long accountID);

}
