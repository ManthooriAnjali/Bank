package com.banking.Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.Bank.entity.FundTransfer;
import com.banking.Bank.service.AccountStatementService;

@RestController
@RequestMapping("/accountStatement")
public class AccountStatementController {

	@Autowired
	AccountStatementService accountStatementService;
	
	@GetMapping("/{accountID}")
	public List<FundTransfer> getAccountStatementFromID(@PathVariable Long accountID) {
		return accountStatementService.getAccountStatementFromID(accountID);
	}
 
	

}
