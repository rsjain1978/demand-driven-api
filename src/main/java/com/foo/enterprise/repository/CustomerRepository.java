package com.foo.enterprise.repository;

import com.foo.enterprise.model.entity.customer.Customer;

public interface CustomerRepository {

	Customer getCustomer(String customerId);

}
