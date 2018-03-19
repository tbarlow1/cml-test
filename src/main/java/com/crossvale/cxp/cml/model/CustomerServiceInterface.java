package com.crossvale.cxp.cml.model;

import java.util.Collection;

public interface CustomerServiceInterface {

	    Customer findCustomer(Integer id);
	    Collection<Customer> findCustomers();
	
}
