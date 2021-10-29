package com.banking.Bank.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.Bank.CustomerDto.CustomerDetailsDto;
import com.banking.Bank.CustomerDto.CustomerRequestDto;
import com.banking.Bank.CustomerDto.CustomerResponseDto;
import com.banking.Bank.entity.Customer;
import com.banking.Bank.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createCustomer")
	
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customerService.addCustomer(customer);
		
	}
	@PostMapping
	public CustomerResponseDto addCustomer(@Valid @RequestBody  CustomerRequestDto  customerRequestDto) {
		return customerService.addCustomer(customerRequestDto);
	}
	@GetMapping
	public List<CustomerDetailsDto> getAllCustomer(@RequestParam LocalDate dob){
		return customerService.getAllCustomers();
	}
	
	
	
	/*@GetMapping
	public List<CustomerDetailsDto> getAllCustomers(){
		return customerService.getAllCustomers();
		
	}*/

}
  