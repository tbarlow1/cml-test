package com.crossvale.cxp.cml;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import static org.apache.camel.model.rest.RestParamType.path;

import org.apache.camel.Exchange;

import com.crossvale.cxp.cml.model.Customer;

@Component
public class RestAPI_Routes extends RouteBuilder {
	
	 @Override
     public void configure() throws Exception {
		 
		restConfiguration().component("restlet")
						   .port(9090);
		 
        rest("/customers").consumes("application/json")
        				  .produces("application/json")
        			
        				  .get()
        				  .bindingMode(RestBindingMode.json)
		        		  .outTypeList(Customer.class)
		        		  .to("bean:customerService?method=findCustomers")
		        
		        		  .get("/{id}")
		        		  .bindingMode(RestBindingMode.json)
		                  .outType(Customer.class)
		                  .param().name("id").type(path).dataType("integer").endParam()
		                  .to("bean:customerService?method=findCustomer(${header.id})")
		                  ;

		rest("/customers")
			.consumes("application/json")
			.produces("text/plain")
		    .post()
		    .to("direct:processCustomer")
		    ;

		rest("/customers")
			.consumes("application/json")
			.produces("text/plain")
		    .put()
		    .to("direct:processCustomer")
		    ;
		
		from("direct:processCustomer")
		    .process("customerProcessor")
		    .to("bean:notifyAboutCustomer?method=sendCustomerDetails");
        
     }
}