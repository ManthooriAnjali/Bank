package com.banking.Bank.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.Bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer findByAccountIDEquals(Long accountID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Customer c SET c.initialAmount = :initialAmount WHERE c.accountID = :accountID")
	public void updateCustomer(@Param("accountID") long accountID, @Param("initialAmount") int initialAmount);

	@Query("SELECT u.accountID from Customer u where u.phone=:phoneNumber")
	public Long getAccountIdFromPhoneNumber(@Param("phoneNumber") String phoneNumber);
	


}
