package com.ibm.taxservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.taxservice.service.TaxService;

@RestController
public class TaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaxController.class);
	
	@Autowired
	TaxService taxService;
	
	@GetMapping("/tax/{name}")
	public Double getTax(@PathVariable(value="name") String name) {
		logger.info("Get Tax for Product: " +name);
		return taxService.getTax(name);
		
	}

}
