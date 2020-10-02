package com.ibm.productservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;
import com.ibm.productservice.mapper.ProductMapper;
import com.ibm.productservice.repository.ProductRepository;
import com.ibm.productservice.restclient.DiscountClient;
import com.ibm.productservice.restclient.TaxClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	final TaxClient taxClient;
	final DiscountClient discountClient;
	
	public ProductService(TaxClient taxClient, DiscountClient discountClient) {
		this.taxClient = taxClient;
		this.discountClient = discountClient;
	}
	
	public Product createProduct(ProductDTO productDTO) {
		
		ProductMapper mapper = new ProductMapper();
		Product entity = mapper.convertToEntity(productDTO);
		
		Product prod =repository.save(entity);
		
		return prod;
		
	}
	
	@HystrixCommand(fallbackMethod = "taxServiceFallBack")
	public Optional<ProductDTO> getProduct(Long id) {
		Optional<Product> product=	repository.findById(id);
		ProductMapper mapper = new ProductMapper();
		ProductDTO dto = mapper.convertToDTO(product.get());
		Double tax = taxClient.getTax(dto.getProductName());
		dto.setTax(tax);
		return Optional.ofNullable(dto);
		}
	public Optional<ProductDTO> taxServiceFallBack(Long id){
		Optional<Product> product=	repository.findById(id);
		ProductMapper mapper = new ProductMapper();
		ProductDTO dto = mapper.convertToDTO(product.get());
		
		dto.setTax(8.0);
		return Optional.ofNullable(dto);
	}
	public void deleteProduct(Long id) {
		  repository.deleteById(id);
		}
	@HystrixCommand(fallbackMethod = "taxServiceFallBack")
	public Optional<ProductDTO> getProductByName(String productName) {
		Optional<Product> product=	repository.findByProductName(productName);
		ProductMapper mapper = new ProductMapper();
		ProductDTO dto = mapper.convertToDTO(product.get());
		
		Double tax = taxClient.getTax(dto.getProductName());
		dto.setTax(tax);
		Double discount = discountClient.getDiscount(productName);
		dto.setDiscount(discount);
		return Optional.ofNullable(dto);
		}
	
	public Optional<ProductDTO> taxServiceFallBack(String productName){
		Optional<Product> product=	repository.findByProductName(productName);
		ProductMapper mapper = new ProductMapper();
		ProductDTO dto = mapper.convertToDTO(product.get());
		
		dto.setTax(8.0);
		dto.setDiscount(10.0);
		return Optional.ofNullable(dto);
	}
	
}
