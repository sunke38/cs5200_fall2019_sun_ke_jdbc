package edu.northeastern.cs5200.model;

import java.util.Date;

public class User extends Person{
	private boolean userAgreement;

	public boolean isUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}

	public User(int id, String fristname, String lastname,String username,String password,String email) {
		super(id, fristname, lastname, username, password, email, new Date(0));
		// TODO Auto-generated constructor stub
		this.userAgreement = true;
	}
	
}
