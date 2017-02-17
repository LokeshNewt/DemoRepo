package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String productName;
	
	private Long price;
	
	private String description;
	
	private Integer ratings;
	
	private Integer ProductCategory;

	public ProductDetails() {
	}
	
	public ProductDetails(Long id, String productName, Long price, String description, Integer ratings,
			Integer productCategory) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.ratings = ratings;
		this.ProductCategory = productCategory;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public Integer getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(Integer productCategory) {
		ProductCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + ", ratings=" + ratings + ", ProductCategory=" + ProductCategory + "]";
	}

}
