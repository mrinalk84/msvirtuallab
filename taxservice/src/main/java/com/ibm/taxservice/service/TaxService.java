package com.ibm.taxservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.taxservice.entity.Tax;
import com.ibm.taxservice.repository.TaxRepository;
@Service
public class TaxService {
	
	@Autowired
	TaxRepository repository;
	
	public Double getTax(String productName) {
		
		
		Double tax = 0.0;
		Optional<Tax> taxObj = repository.getByProductName(productName);
		if(taxObj.isPresent()) {
			tax = taxObj.get().getTax();
		}
		else {
			tax=8.0;
		}
		return tax;
	}
		

}
