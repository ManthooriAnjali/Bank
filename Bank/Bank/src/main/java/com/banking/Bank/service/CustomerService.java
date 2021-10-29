package com.banking.Bank.service;

import java.util.List;

import javax.validation.Valid;

import com.banking.Bank.CustomerDto.CustomerDetailsDto;
import com.banking.Bank.CustomerDto.CustomerRequestDto;
import com.banking.Bank.CustomerDto.CustomerResponseDto;
import com.banking.Bank.entity.Customer;

public interface CustomerService {
	
	
	public List<CustomerDetailsDto> getAllCustomers();

	public CustomerResponseDto addCustomer(@Valid CustomerRequestDto customerRequestDto);

	public Customer addCustomer(Customer customer);

}
