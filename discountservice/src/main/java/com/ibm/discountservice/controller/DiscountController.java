package com.ibm.discountservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.discountservice.service.DiscountService;


@RestController
public class DiscountController {
	
private static final Logger logger = LoggerFactory.getLogger(DiscountController.class);
	
	@Autowired
	DiscountService discountService;
	
	@GetMapping("/discount/{name}")
	public Double getDiscount(@PathVariable(value="name") String name) {
		logger.info("Get Discount for Product: " +name);
		return discountService.getDiscountByProductName(name);
		
	}

}
