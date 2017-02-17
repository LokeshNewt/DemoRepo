package com.product.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.ProductCategory;
import com.product.model.ProductDetails;
import com.product.repository.ProductCategoryRepository;
import com.product.repository.ProductRepository;
import com.product.repository.utils.DataUtils.ProductCategories;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/productdetails")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository pdtCategoryRepository;
	
	 private static Logger logger = Logger.getLogger(ProductController.class);
	
//Method for add product by using parameter webservice call	
	/*@RequestMapping(value = "addProduct/{productName}/{price}/{description}/{ratings}", 
			method = RequestMethod.POST, produces = "application/json")
	public String addProductDetails(@PathVariable String productName,@PathVariable Long price,
			@PathVariable String description,@PathVariable Integer ratings){
			System.out.println("productName"+productName+"price"+price);
			ProductDetails productDetails = new ProductDetails();	
			productDetails.setProductName(productName);
			productDetails.setPrice(price);
			productDetails.setRatings(ratings);
			productDetails.setDescription(description);
			productDetails = productRepository.save(productDetails);
			if(productDetails != null){
				return "Successfully Inserted";
			}
			
		return null;
	}
*/	
	@ResponseBody @RequestMapping(value = "addProduct/{productCategory}", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	@ApiOperation(value = "Add Product along with details")
	public String addProductDetails(@RequestBody ProductDetails product,@PathVariable String productCategory){			
			try{
				logger.info("====>Enter into add product based on product category<=====");
				ProductCategory category = new ProductCategory();
				category.setProductCategory(ProductCategories.valueOf(productCategory.toUpperCase()));
				category.setCreatedDate(new Date());
				category.setCreatedBy("Admin");
				category = pdtCategoryRepository.save(category);
				
				ProductDetails productDetails = new ProductDetails();	
				productDetails.setProductName(product.getProductName());
				productDetails.setPrice(product.getPrice());
				productDetails.setRatings(product.getRatings());
				productDetails.setDescription(product.getDescription());
				productDetails.setProductCategory(category.getProductId());
				productDetails = productRepository.save(productDetails);
				if(productDetails != null){
					return "Successfully Inserted";
				}
			}catch(Exception e){
				logger.error("Add Product ==>"+e);
			}
				return null;
	}
	
	@RequestMapping(value = "search/getAllProducts", 
			method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get all products exist in the database")
	public List<ProductDetails> getAllProductDetails(){
		return  (List<ProductDetails>) productRepository.findAll();
	}
	
	@RequestMapping(value = "search/{productName}", 
			method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get a particular product by using produt name")
	public ProductDetails getProductDetails(@PathVariable String productName){
		ProductDetails productDetails = productRepository.findProductDetailsByProductName(productName);
		return  productDetails;
	}
	
}
