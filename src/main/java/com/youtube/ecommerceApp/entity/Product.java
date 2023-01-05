package com.youtube.ecommerceApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productDescription;
	private String productActualPrice;
	private String productDiscountPrice;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "product_images",
	joinColumns = {
			@JoinColumn(name="product_id")
	},
	inverseJoinColumns = {
			@JoinColumn(name="image_di")
	}
	)
	private Set<ImageModel> imageModels;
	
	
	
	
	public Set<ImageModel> getImageModels() {
		return imageModels;
	}
	public void setImageModels(Set<ImageModel> imageModels) {
		this.imageModels = imageModels;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductActualPrice() {
		return productActualPrice;
	}
	public void setProductActualPrice(String productActualPrice) {
		this.productActualPrice = productActualPrice;
	}
	public String getProductDiscountPrice() {
		return productDiscountPrice;
	}
	public void setProductDiscountPrice(String productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}
	
	

}
