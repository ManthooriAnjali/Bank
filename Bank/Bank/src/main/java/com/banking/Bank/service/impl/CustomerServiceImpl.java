package com.banking.Bank.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.Bank.CustomerDto.CustomerDetailsDto;
import com.banking.Bank.CustomerDto.CustomerRequestDto;
import com.banking.Bank.CustomerDto.CustomerResponseDto;
import com.banking.Bank.entity.Customer;
import com.banking.Bank.repository.CustomerRepository;
import com.banking.Bank.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<CustomerDetailsDto> getAllCustomers() {
		
		return null;//customerRepository.findAll();
	}

	@Override
	public CustomerResponseDto addCustomer(@Valid CustomerRequestDto customerRequestDto)throws NullPointerException {
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDto, customer);
		customer.setCreationDate(LocalDateTime.now());
		Customer dbCustomer = customerRepository.save(customer);
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		BeanUtils.copyProperties(dbCustomer, customerResponseDto);
		return customerResponseDto ;
	}

	
}

