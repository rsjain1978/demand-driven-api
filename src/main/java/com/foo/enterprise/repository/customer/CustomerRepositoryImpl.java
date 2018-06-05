package com.foo.enterprise.repository.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foo.enterprise.adapters.account.AccountServiceAdapterWebServiceImpl;
import com.foo.enterprise.adapters.customer.CustomerServiceAdapterDatabaseImpl;
import com.foo.enterprise.model.commons.address.Address;
import com.foo.enterprise.model.entity.account.holdings.Cash;
import com.foo.enterprise.model.entity.account.holdings.MutualFundHolding;
import com.foo.enterprise.model.entity.accounts.Account;
import com.foo.enterprise.model.entity.accounts.DematAccount;
import com.foo.enterprise.model.entity.accounts.SavingsAccount;
import com.foo.enterprise.model.entity.customer.Customer;
import com.foo.enterprise.repository.CustomerRepository;

@Component
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	CustomerServiceAdapterDatabaseImpl customerServiceAdapter;
	
	@Autowired
	AccountServiceAdapterWebServiceImpl accountServiceAdapter;
	
	@Override
	public Customer getCustomer(String customerId) {
		
		//In an enterprise like setup this could be another web-service or database or remote call to some record keeping system.
		Customer customer = customerServiceAdapter.getCustomerDetails();
		
		//In an enterprise like setup this could be another web-service or database or remote call to some record keeping system.
		customer = accountServiceAdapter.populateAccountDetails(customer);
		
		return customer;
	}

}
