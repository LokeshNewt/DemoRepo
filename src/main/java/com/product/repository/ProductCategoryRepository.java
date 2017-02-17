package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {

}
