package com.crossvale.cxp.cml;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("notifyAboutCustomer")
@Component
public class MQProducer {

    @Autowired
    private ProducerTemplate producerTemplate;
    
    public void sendCustomerDetails(String message) {
    	System.out.println("sending a message to MQ");
		producerTemplate.sendBody("activemq:customers", message);
	}

}