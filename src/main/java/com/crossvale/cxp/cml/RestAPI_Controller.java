package com.crossvale.cxp.cml;


import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI_Controller {
	
 @Autowired
 ProducerTemplate producerTemplate;
 
}