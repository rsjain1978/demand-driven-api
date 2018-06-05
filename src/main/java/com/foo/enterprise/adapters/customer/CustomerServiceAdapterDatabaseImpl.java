package com.foo.enterprise.adapters.customer;

import org.springframework.stereotype.Component;

import com.foo.enterprise.model.commons.address.Address;
import com.foo.enterprise.model.entity.customer.Customer;

@Component
public class CustomerServiceAdapterDatabaseImpl {

	public Customer getCustomerDetails() {
		
		Address address = new Address("line1","line2","fooPostCode");
		return new Customer("Mr.","Foo","Bar", address);		
	}

}
