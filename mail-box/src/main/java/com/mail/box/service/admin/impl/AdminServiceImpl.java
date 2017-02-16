package com.mail.box.service.admin.impl;

import com.mail.box.entity.LoginUser;
import com.mail.box.repository.admin.AdminRespository;
import com.mail.box.service.admin.AdminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminRespository adminRespository;
    
	@Override
	public List<LoginUser> getUsers() {
		final List<LoginUser> users = new ArrayList<LoginUser>();
		adminRespository.findAll().forEach(users::add);
		return users;
	}

    @Override
	public LoginUser getUser(final String email) {
    	String id = email;
    	if(!StringUtils.endsWithIgnoreCase(email, "@gmail.com")) {
    		id = email.concat("@gmail.com");
    	}
		return adminRespository.findOne(id);
	}
    
    @Override
    public void addUser(final LoginUser loginUser) {
    	adminRespository.save(loginUser);
    }

}
