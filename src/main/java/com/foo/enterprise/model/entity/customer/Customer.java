package com.foo.enterprise.model.entity.customer;

import com.foo.enterprise.model.commons.address.Address;
import com.foo.enterprise.model.entity.accounts.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

	private String salutation;
	private String firstName;
	private String lastName;
	
	private Address address;
	private Account[] accounts;
	
	public Customer(String salutation,
			String firstName,
			String lastName,
			Address address,
			Account[] accounts) {
		this.salutation=salutation;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.accounts=accounts;
	}

	public Customer(String salutation, 
			String firstName, 
			String lastName, 
			Address address) {
		this.salutation=salutation;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts=accounts;
	}
}
