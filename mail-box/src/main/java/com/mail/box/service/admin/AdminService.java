package com.mail.box.service.admin;

import java.util.List;

import com.mail.box.entity.LoginUser;


public interface AdminService {
	public List<LoginUser> getUsers();
	
    public LoginUser getUser(final String email);

    public void addUser(final LoginUser loginUser);
}
