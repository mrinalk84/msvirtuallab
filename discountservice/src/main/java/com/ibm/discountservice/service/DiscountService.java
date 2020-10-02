package com.ibm.discountservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.discountservice.entity.Discount;
import com.ibm.discountservice.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	DiscountRepository repository;
	
	public Double getDiscountByProductName(String productName) {
		Double discount = 0.0;
		Optional<Discount> discountObj = repository.getDiscountByProductName(productName);
		if(discountObj.isPresent()) {
			discount = discountObj.get().getDiscount();
		}
		else {
			discount=10.0;
		}
		return discount;
	}

}
