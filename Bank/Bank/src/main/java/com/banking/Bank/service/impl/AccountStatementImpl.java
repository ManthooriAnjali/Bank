package com.banking.Bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.Bank.entity.FundTransfer;
import com.banking.Bank.repository.FundTransferRepository;
import com.banking.Bank.service.AccountStatementService;
@Service
public class AccountStatementImpl implements AccountStatementService {


	@Autowired
	FundTransferRepository fundTransferRepository;

	@Override
	public List<FundTransfer> getAccountStatementFromID(Long accountID) {
		
		return  fundTransferRepository.findByFromAccountID(accountID);
	}

}
