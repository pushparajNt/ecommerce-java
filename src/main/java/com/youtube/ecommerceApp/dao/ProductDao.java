package com.youtube.ecommerceApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.ecommerceApp.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

}
