package com.reviewer.mvc.model.dto;

public class User {
	private String id;
	private String name;
	private String pass;
	private String signupDate;
	
	public User() {
	}

	public User(String id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", signupDate=" + signupDate + "]";
	}
	
}
