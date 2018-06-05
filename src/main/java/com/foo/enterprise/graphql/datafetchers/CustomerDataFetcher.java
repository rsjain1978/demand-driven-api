package com.foo.enterprise.graphql.datafetchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foo.enterprise.model.entity.customer.Customer;
import com.foo.enterprise.repository.CustomerRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomerDataFetcher implements DataFetcher<Customer>{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer get(DataFetchingEnvironment environment) {
		String customerId = environment.getArgument("id");
		return customerRepository.getCustomer(customerId);
	}

}
