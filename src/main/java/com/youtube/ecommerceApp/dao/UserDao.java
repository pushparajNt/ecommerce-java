package com.youtube.ecommerceApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.ecommerceApp.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
