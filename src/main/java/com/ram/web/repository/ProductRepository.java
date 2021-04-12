package com.ram.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ram.web.entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

	@Query(value="select * from product where product_category=?1",nativeQuery=true)
	Product findByProductCategory(String categoryName);

	@Query(value="select * from product where product_color=?1",nativeQuery=true)
	Product findByProductColor(String color);

	@Query(value="select * from product where product_name= ?1",nativeQuery=true)
	Product findByProductName(String productName);

}
