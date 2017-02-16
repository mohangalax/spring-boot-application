package com.mail.box.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class LoginUser {
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String password;
}
