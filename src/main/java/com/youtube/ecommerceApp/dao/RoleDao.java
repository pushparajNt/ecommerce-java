package com.youtube.ecommerceApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.ecommerceApp.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
