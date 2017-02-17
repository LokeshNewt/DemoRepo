package com.product.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.product.repository.utils.DataUtils.ProductCategories;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Enumerated(EnumType.STRING)
	private ProductCategories productCategory; 
	
	@Version
	private Date createdDate;
	
	private String createdBy;
	
	public ProductCategory() {
	}

	public ProductCategory(Integer productId, ProductCategories productCategory, Date createdDate, String createdBy) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductCategories getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategories productCategory) {
		this.productCategory = productCategory;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "ProductCategory [productId=" + productId + ", productCategory=" + productCategory + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + "]";
	}
	
}
