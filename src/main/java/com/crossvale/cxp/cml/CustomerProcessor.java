package com.crossvale.cxp.cml;

import java.io.IOException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.crossvale.cxp.cml.model.Customer;
import com.crossvale.cxp.cml.model.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component 
public class CustomerProcessor implements Processor {

	@Autowired
	private ApplicationContext appContext;
	
	
	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("CustomerProcessor");
		String message = exchange.getIn().getBody(String.class);
		String httpmethod = (String)exchange.getIn().getHeader(Exchange.HTTP_METHOD);
		
		ObjectMapper mapper = new ObjectMapper();
        try {
			Customer customer = mapper.readValue((String) message, Customer.class);
			CustomerService cs = (CustomerService)appContext.getBean("customerService");
			if (httpmethod.equals("POST")){
				cs.addCustomer(customer);
			} else if (httpmethod.equals("PUT")) {
				cs.updateCustomer(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
