package com.ibm.discountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.discountservice.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long>{
	
	Optional<Discount> getDiscountByProductName(String productName);

}
