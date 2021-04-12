package com.ram.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ram.web.entity.Product;
import com.ram.web.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/*
	 * Add Product
	 * @Param  Product product
	 * return product
	 */
	@PostMapping("/addproduct")
 public ResponseEntity<Object> addProduct(@RequestParam("productImagePath") MultipartFile productImagePath,HttpServletRequest request  )
 {
		String saveDirectory="/Images/";
	    Product product = new Product();
	    try {
			String filename=productImagePath.getOriginalFilename();
            product.setProductImagePath(filename);
            productImagePath.transferTo(new File(saveDirectory+filename));
	    	product.setProductName(request.getParameter("productName"));
	    	product.setProductCategory(request.getParameter("productCategory"));
	    	product.setProductColor(request.getParameter("productColor"));
	    	product.setProductPrice(request.getParameter("productPrice"));
	    	productService.AddNewProduct(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	

	    return new ResponseEntity<Object>(product,HttpStatus.OK);
	 
	 
 }
	
	/*
	 * Search product by its Name Product
	 * @Param  String  productName
	 * return product
	 */
	
	@GetMapping("/SearchByName/{productName}")
	public ResponseEntity<Object> SearchByName(@PathVariable("productName") String productName)
	{
		System.out.println("In method Entry");
		Product product=productService.getProductByName(productName);
		return new ResponseEntity<Object>(product,HttpStatus.OK);
		
	}
	
	
	/*
	 * Search product by its Category 
	 * @Param  String  Category
	 * return product
	 */
	@GetMapping("/SearchBycategory/{productCategory}")
	public ResponseEntity<Object> SearchByCategory(@PathVariable("productCategory") String productCategory)
	{
		Product product=productService.searchProductByCategory(productCategory);
		return new ResponseEntity<Object>(product,HttpStatus.OK);
		
	}
	
	/*
	 * Search product by its Color 
	 * @Param  String  Color
	 * return product
	 */
	
	@GetMapping("/SearchByColor/{productColor}")
	public ResponseEntity<Object> SearchByColor(@PathVariable("productColor") String productColor)
	{
		Product product=productService.searchProductByColor(productColor);
		return new ResponseEntity<Object>(product,HttpStatus.OK);
		
	}
	

}
