package com.ibm.productservice.mapper;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;

public class ProductMapper {
	
	public Product convertToEntity(ProductDTO productDTO) {
		
		Product entity = new Product();
		entity.setProductName(productDTO.getProductName());
		entity.setQuantity(productDTO.getQuantity());
		
		return entity;
	}
	
	public ProductDTO convertToDTO(Product product) {
		
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setProductName(product.getProductName());
		dto.setQuantity(product.getQuantity());
		
		return dto;
	}


}
