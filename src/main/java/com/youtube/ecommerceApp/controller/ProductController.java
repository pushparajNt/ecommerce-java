package com.youtube.ecommerceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.ecommerceApp.entity.Product;
import com.youtube.ecommerceApp.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addNewProduct")
	public Product addNewProduct(@RequestBody Product product)
	{
		return productService.addNewProduct(product);
	}
	
}
