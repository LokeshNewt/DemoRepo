package com.product.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.ProductDetails;

@Repository
public interface ProductRepository extends CrudRepository<ProductDetails, Long>{
	
	public ProductDetails findProductDetailsByProductName(String productName);

}
