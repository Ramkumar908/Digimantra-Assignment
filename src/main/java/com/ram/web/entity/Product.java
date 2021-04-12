package com.ram.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	private String productName;
	private String productImagePath;
	private String productCategory;
	private String productColor;
	private String productPrice;
	public Product() {
		
	}
	
	public Product(int productid, String productName, String productImagePath, String productCategory,
			String productColor, String productPrice) {
		
		this.productid = productid;
		this.productName = productName;
		this.productImagePath = productImagePath;
		this.productCategory = productCategory;
		this.productColor = productColor;
		this.productPrice = productPrice;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	
	
}
