package com.crossvale.cxp.cml.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService implements CustomerServiceInterface {

    private final Map<Integer, Customer> customers = new TreeMap<Integer, Customer>();

    public CustomerService() {
    	try {
    		// initialize customers
	    	customers.put(1, new Customer(1, "Jose Alonso"));
	    	customers.put(2, new Customer(2, "Cody Farris"));
	    	customers.put(3, new Customer(3, "Prajith Mudi"));
	    	customers.put(4, new Customer(4, "Scott Johnson"));
	    	customers.put(5, new Customer(5, "Sid Ravipati"));
	    	customers.put(6, new Customer(6, "Elon Mask"));
	    	
	    	// customer 6
	    	customers.get(6).setPhoneNr(new PhoneNr("mobile","(469) 123-4567"));
	    	customers.get(6).setIssuePlace("New York");
	    	customers.get(6).setStatus("Expired");
			customers.get(6).setExpirationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2014-05-01"));
			customers.get(6).setIssueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2004-05-01"));
    	    customers.get(6).setAddress(new Address("1818 Preston Rd","","Addison","TX","75015","US","United States"));
    	    customers.get(6).setNationalityCode("US");
    	    customers.get(6).setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-01"));
    	    customers.get(6).setEmail("emask@tesla.com");

    	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
   	}

    @Override
    public Customer findCustomer(Integer id) {
        return customers.get(id);
    }

    @Override
    public Collection<Customer> findCustomers() {
        return customers.values();
    }
    
    public void addCustomer(Customer customer){
    	customer.setCustomerNr(getMaxCustomerNr()+1);
    	customers.put(getMaxCustomerNr()+1, customer);
    }

    public void updateCustomer(Customer customer){
    	customers.put(customer.getCustomerNr(), customer);
    }
    
    public Integer getMaxCustomerNr() {
        return Collections.max(customers.keySet());
    }    
}
