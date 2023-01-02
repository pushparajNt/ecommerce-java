package com.youtube.ecommerceApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.ecommerceApp.dao.ProductDao;
import com.youtube.ecommerceApp.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao  productDao;
	
	public Product  addNewProduct(Product product)
	{
		return productDao.save(product);
	}
}
