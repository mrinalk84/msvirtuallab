package com.ibm.productservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient("discountservice")
public interface DiscountClient {
	
	@GetMapping("/discount/{name}")
	public Double getDiscount(@PathVariable(value="name") String name);

}
