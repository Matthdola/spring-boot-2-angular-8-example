package com.example.demo.model;

public class User {
	private String firstname;
	private String latname;
	private String login;
	private String password;
	private String passwordSalt;
	
	
	
	public User() {
		super();
	}



	public User(String firstname, String latname, String login, String password, String passwordSalt) {
		super();
		this.firstname = firstname;
		this.latname = latname;
		this.login = login;
		this.password = password;
		this.passwordSalt = passwordSalt;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLatname() {
		return latname;
	}



	public void setLatname(String latname) {
		this.latname = latname;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordSalt() {
		return passwordSalt;
	}



	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}
