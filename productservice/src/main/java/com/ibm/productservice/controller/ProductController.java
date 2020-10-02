package com.ibm.productservice.controller;

import java.util.Optional;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;
import com.ibm.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Value("${msg}")
	String message;
	
	@ApiOperation("This is to create product")
	@PostMapping("product")
	public ResponseEntity<Product> products(@RequestBody  ProductDTO productDTO){
		return new  ResponseEntity<Product>(productService.createProduct(productDTO), HttpStatus.OK);
	}
	
	
	@GetMapping("/product")
	public ResponseEntity<ProductDTO> products(@RequestParam(value="id") Long id){
		
		Optional<ProductDTO> product=productService.getProduct(id);
		
		if(product.isPresent()) {
			
			return ResponseEntity.ok().body(product.get());
		}else {
			return ResponseEntity.noContent().build();
		}
		
		
		
	}
	
	@ApiOperation("This is to get product by ID")
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> product(@PathVariable(value="id") Long id){
		
		Optional<ProductDTO> product=productService.getProduct(id);
		
		if(product.isPresent()) {
			
			return ResponseEntity.ok().body(product.get());
		}else {
			return ResponseEntity.noContent().build();
		}
		
		
		
	}
	
	@ApiOperation("This is to get product by ProductName")
	@GetMapping("/product/name/{productName}")
	public ResponseEntity<ProductDTO> productByName(@PathVariable(value="productName") String productName){
		
		Optional<ProductDTO> product=productService.getProductByName(productName);
		
		if(product.isPresent()) {
			
			return ResponseEntity.ok().body(product.get());
		}else {
			return ResponseEntity.noContent().build();
		}
		
		
		
	}
	@ApiOperation("This is to delete product by ID")
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value="id") Long id){
		
		productService.deleteProduct(id);
			
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/message")
	public String message() {
		return message;
	}

}
