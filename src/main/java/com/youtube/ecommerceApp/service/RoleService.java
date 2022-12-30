package com.youtube.ecommerceApp.service;

import com.youtube.ecommerceApp.dao.RoleDao;
import com.youtube.ecommerceApp.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
