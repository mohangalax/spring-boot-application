package com.mail.box.controller.admin;

import com.mail.box.entity.LoginUser;
import com.mail.box.service.admin.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    public AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        final List<LoginUser> loginUsers = adminService.getUsers();

        return new ResponseEntity<List<LoginUser>>(loginUsers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("email")
    final String email) {
        final LoginUser loginUser = adminService.getUser(email);

        return new ResponseEntity<LoginUser>(loginUser, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody
    final LoginUser loginUser) {
        final HttpStatus status = HttpStatus.CREATED;
        adminService.addUser(loginUser);

        return new ResponseEntity<HttpStatus>(status);
    }
}
