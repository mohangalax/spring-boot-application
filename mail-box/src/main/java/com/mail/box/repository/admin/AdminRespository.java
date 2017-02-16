package com.mail.box.repository.admin;

import org.springframework.data.repository.CrudRepository;

import com.mail.box.entity.LoginUser;

public interface AdminRespository extends CrudRepository<LoginUser, String>{

}
