package com.avneet.userservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="signup")
public class UserLogin {
	
	@Id
	@NotNull
	private int id;
	private String name;
	@Size(min = 6 ,max=25)
	private String password;
	private String confirmpassword;
	private int contactno;
	@NotNull
	@Email
	private String email;
	
	
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserLogin(int id, String name, String password, String confirmpassword, int contactno, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.contactno = contactno;
		this.email = email;
	}
	
	public UserLogin() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", name=" + name + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", contactno=" + contactno + ", email=" + email + "]";
	}
	
	
	
	
	

}
