package com.ibm.productservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("taxservice")
public interface TaxClient {
	
	@GetMapping("/tax/{name}")
	public Double getTax(@PathVariable(value="name") String name);

}
