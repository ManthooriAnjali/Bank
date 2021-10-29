package com.banking.Bank.CustomerDto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerRequestDto implements Serializable {

	@NotNull
	@Size(min = 3, max = 6)

	private String firstName;

	private String lastName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
