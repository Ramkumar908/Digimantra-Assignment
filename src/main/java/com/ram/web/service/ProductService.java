package com.ram.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.web.entity.Product;
import com.ram.web.repository.ProductRepository;

@Service
public class  ProductService {
	
	
	@Autowired
	ProductRepository  productRepo;
	/*
	 * Add product
	 */
	public Product AddNewProduct(Product product)
	{
		 return productRepo.save(product);
	}
	
	/*
	 * Search  product by id
	 */
	
	public Product getProductByName(String  productName) 
	{
		
		 Product existProductByName=null;
		try
		{ 
			
		existProductByName=productRepo.findByProductName(productName);
		System.out.println(existProductByName.getProductName());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return existProductByName;
		
	}
	
	/*
	 * 
	 * Search product by category
	 */
	public Product searchProductByCategory(String categoryName)
	{
		Product existProductByCategory=null;
		try
		{
			
			existProductByCategory=productRepo.findByProductCategory(categoryName);
		}catch(Exception e)
		{
			 e.printStackTrace();
		}
		return existProductByCategory;
		
	}
	
	/*
	 * 
	 * Search product by color
	 */
	
	 public Product searchProductByColor(String color)
	 {
		 
		 Product existProductByColor=null;
		 try
		 {
			 existProductByColor=productRepo.findByProductColor(color);
			 
		 }catch(Exception e)
		 {
			  e.printStackTrace();
		 }
		 
		 return  existProductByColor;
	 }
	
	
	

}
