package com.banking.Bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.Bank.entity.Customer;
import com.banking.Bank.entity.FundTransfer;
import com.banking.Bank.repository.CustomerRepository;
import com.banking.Bank.repository.FundTransferRepository;
import com.banking.Bank.service.FundTransferService;

@Service
public class FundTransferImpl implements FundTransferService {
	
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public FundTransfer transferFund(FundTransfer fundTransfer) {
		validateAndMakeTransaction(fundTransfer);
		return  fundTransferRepository.save(fundTransfer);
	}
	
	private void validateAndMakeTransaction(FundTransfer fundTransfer) throws IllegalArgumentException{
		// first check if from and to accountids exists
				// Check if balance is available
				// change balance in both the account -> add/remove
		long fromAccountID = fundTransfer.getFromAccountID();
		long toAccoundID = fundTransfer.getToAccountID();
		long amountToTransfer = fundTransfer.getAmountToTransfer();
		
		Customer fromCustomer = customerRepository.findByAccountIDEquals(fromAccountID);
		Customer toCustomer = customerRepository.findByAccountIDEquals(toAccoundID);
		
		if(fromCustomer == null && toCustomer == null) {
			throw new IllegalArgumentException("Both Sender account and Receipient account doesn't exists,Please double check");
				
		}else if (fromCustomer == null) {
			throw new IllegalArgumentException("Sender account doesn't exists,Please double check fromAccountID");
			
		}else if (toCustomer == null) {
			throw new IllegalArgumentException("Recepient account doesn't exists, Please double check toAccountID");
		}else if (fromCustomer.getInitialAmount() < amountToTransfer) {
			throw new IllegalArgumentException("Funds are not sufficient to make this trnasaction,Please load funds");
		}else if (amountToTransfer == 0) {
			
			throw new IllegalArgumentException("Please add amount to transfer");
		}
		long finalAmountOfSender = fromCustomer.getInitialAmount() - amountToTransfer;
		customerRepository.updateCustomer(fromAccountID,(int) finalAmountOfSender );
		
		
		long finalAmountOfRecepient = toCustomer.getInitialAmount() + amountToTransfer;
		customerRepository.updateCustomer(toAccoundID,(int) finalAmountOfRecepient );
		
	}
	

	@Override
	public Long getAccountIdFromPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return customerRepository.getAccountIdFromPhoneNumber(phoneNumber);
	}

}
